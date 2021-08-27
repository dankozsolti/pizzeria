package hu.ulyssys.pizzeria.mbean;

import hu.ulyssys.pizzeria.entity.AbstractIdentity;
import hu.ulyssys.pizzeria.service.CoreService;
import org.primefaces.PrimeFaces;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;

public abstract class CoreCRUDMbean<T extends AbstractIdentity> implements Serializable {
    private List<T> list;
    private T selectedEntity;

    protected CoreService<T> service;

    public CoreCRUDMbean(CoreService<T> service) {
        this.service = service;
        setSelectedEntity(initNewEntity());
        setList(service.getAll());
    }

    public void initSave() {
        selectedEntity = initNewEntity();
    }

    public void save() {
        try {
            if (selectedEntity.getId() == null) {
                service.add(selectedEntity);
                list = service.getAll();
                selectedEntity = initNewEntity();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres mentés"));

            } else {
                service.update(selectedEntity);
                list = service.getAll();
                selectedEntity = initNewEntity();
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres módosítás"));
            }
            PrimeFaces.current().executeScript("PF('" + dialogName() + "').hide()");
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen mentés", null));

        }
    }


    public void remove() {
        try {
            service.remove(selectedEntity);
            list = service.getAll();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Sikeres törlés"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen törlés", null));

        }


    }

    protected abstract String dialogName();

    protected abstract T initNewEntity();

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public T getSelectedEntity() {
        return selectedEntity;
    }

    public void setSelectedEntity(T selectedEntity) {
        this.selectedEntity = selectedEntity;
    }
}
