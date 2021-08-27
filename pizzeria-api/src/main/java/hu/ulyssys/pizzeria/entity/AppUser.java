package hu.ulyssys.pizzeria.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@NamedQuery(name = AppUser.FIND_BY_USERNAME, query = "select u from AppUser u where u.username=:username")
@Entity
@Table(name = "appuser")
public class AppUser extends AbstractIdentity {
    public static final String FIND_BY_USERNAME = "AppUser.findByUsername";

    @Column(name = "created_date", nullable = false)
    private Date createdDate;

    @Column(name = "username", unique = true,nullable = false,length = 200)
    private String username;

    @Column(name = "password_hash",nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AppUserRole role;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AppUser appUser = (AppUser) o;
        return Objects.equals(createdDate, appUser.createdDate) &&
            Objects.equals(username, appUser.username) &&
            Objects.equals(passwordHash, appUser.passwordHash) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdDate, username, passwordHash, role);
    }
}
