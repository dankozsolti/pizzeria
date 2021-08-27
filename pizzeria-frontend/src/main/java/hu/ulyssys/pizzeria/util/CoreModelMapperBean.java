package hu.ulyssys.pizzeria.util;


import hu.ulyssys.pizzeria.entity.AbstractEntity;
import hu.ulyssys.pizzeria.rest.model.CoreRestModel;
import hu.ulyssys.pizzeria.service.AppUserService;

import javax.inject.Inject;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public abstract class CoreModelMapperBean<M extends CoreRestModel, T extends AbstractEntity> {

    @Inject
    private AppUserService appUserService;

    public M createModelFromEntity(T entity) {
        M model = initNewModel();
        model.setId(entity.getId());
        model.setCreatedDate(Date.from(entity.getCreatedDate().toInstant()));
        model.setModifiedDate(Date.from(entity.getModifiedDate().toInstant()));
        if (entity.getCreatorUser() != null && entity.getModifierUser() != null) {
            model.setCreatorUserId(entity.getCreatorUser().getId());
            model.setModifierUserId(entity.getModifierUser().getId());
        }
        return model;

    }

    public void populateEntityFromModel(T entity, M model) {
        if (model.getCreatorUserId() != null && model.getModifierUserId() != null) {
            entity.setCreatorUser(appUserService.findById(model.getCreatorUserId()));
            entity.setModifierUser(appUserService.findById(model.getModifierUserId()));
        }
        entity.setId(model.getId());
        entity.setCreatedDate(ZonedDateTime.ofInstant(model.getCreatedDate().toInstant(), ZoneId.systemDefault()));
        entity.setModifiedDate(ZonedDateTime.ofInstant(model.getModifiedDate().toInstant(), ZoneId.systemDefault()));
    }

    public abstract M initNewModel();

}
