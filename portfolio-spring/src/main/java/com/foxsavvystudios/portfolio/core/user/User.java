package com.foxsavvystudios.portfolio.core.user;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
public class User {

    public enum Role {
        SUPERADMIN, ADMIN, ARTIST, USER
    }

    private Long userId;
    private String username;
    private String password;
    private String email;
    private Role role;

    private boolean enabled;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    @PrePersist
    private void prePersist() {
        createdDate = LocalDateTime.now();
        modifiedDate = LocalDateTime.now();
        if(role == null) {
            role = Role.USER;
        }
    }

    public User() {
    }

    public User(String username, String password, String email, Role role, boolean enabled) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.enabled = enabled;
    }

    @PreUpdate
    private void preUpdate() {
        modifiedDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name = "enabled")
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Column(name = "created_date")
    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "modified_date")
    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
