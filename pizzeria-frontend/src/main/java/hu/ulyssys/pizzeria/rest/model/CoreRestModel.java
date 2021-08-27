package hu.ulyssys.pizzeria.rest.model;

import javax.json.bind.annotation.JsonbDateFormat;
import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;
import java.util.Date;

public abstract class CoreRestModel {
    private Long id;
    @JsonbDateFormat("yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date createdDate;
    @JsonbDateFormat("yyyy-MM-dd HH:mm:ss")
    @NotNull
    private Date modifiedDate;
    @NotNull
    private Long creatorUserId;
    private Long modifierUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Long getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(Long creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public Long getModifierUserId() {
        return modifierUserId;
    }

    public void setModifierUserId(Long modifierUserId) {
        this.modifierUserId = modifierUserId;
    }
}
