package hu.ulyssys.pizzeria.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;
import java.util.Date;

@MappedSuperclass
public abstract class AbstractEntity extends AbstractIdentity {

    @Column(name = "created_date", nullable = false)
    private ZonedDateTime createdDate;

    @Column(name = "modified_date")
    private ZonedDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "creator_user_id", nullable = false)
    private AppUser creatorUser;

    @ManyToOne
    @JoinColumn(name = "modifier_user_id")
    private AppUser modifierUser;

    public AbstractEntity() {
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(ZonedDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public ZonedDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(ZonedDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public AppUser getCreatorUser() {
        return creatorUser;
    }

    public void setCreatorUser(AppUser creatorUser) {
        this.creatorUser = creatorUser;
    }

    public AppUser getModifierUser() {
        return modifierUser;
    }

    public void setModifierUser(AppUser modifierUser) {
        this.modifierUser = modifierUser;
    }
}
