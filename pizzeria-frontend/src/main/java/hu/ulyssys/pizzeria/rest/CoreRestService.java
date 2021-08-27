package hu.ulyssys.pizzeria.rest;

import hu.ulyssys.pizzeria.entity.AbstractEntity;
import hu.ulyssys.pizzeria.rest.model.CoreRestModel;
import hu.ulyssys.pizzeria.service.CoreService;
import hu.ulyssys.pizzeria.util.CoreModelMapperBean;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;

public abstract class CoreRestService<T extends AbstractEntity, M extends CoreRestModel> {

    @Inject
    private CoreService<T> coreService;

    @Inject
    private CoreModelMapperBean<M, T> modelMapperBean;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response findByID(@PathParam("id") Long id) {
        T entity = coreService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(coreService.getAll().stream().map(this::createModelFromEntity).collect(Collectors.toList())).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid M model) {

        T entity = initNewEntity();
        populateEntityFromModel(entity, model);

        coreService.add(entity);
        return Response.ok(createModelFromEntity(entity)).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Valid M model) {
        T entity = coreService.findById(model.getId());
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        populateEntityFromModel(entity, model);
        coreService.update(entity);
        return Response.ok(createModelFromEntity(entity)).build();

    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        T entity = coreService.findById(id);
        if (entity == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        coreService.remove(entity);
        return Response.ok().build();
    }

    protected void populateEntityFromModel(T entity, M model) {
        modelMapperBean.populateEntityFromModel(entity, model);
    }

    protected M createModelFromEntity(T entity) {
        return modelMapperBean.createModelFromEntity(entity);
    }


    protected abstract T initNewEntity();
    protected M initNewModel() {
        return modelMapperBean.initNewModel();
    }

}
