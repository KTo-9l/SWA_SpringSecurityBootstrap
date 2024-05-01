package org.sillysociety.models.swa;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "users", schema = "simplewebapp")
public class MyUser {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "login", unique = true, nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "role", nullable = false)
    private String role = "user";
    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    public MyUser(String login, String password, String email, String role, Boolean deleted) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
        this.deleted = deleted;
    }
    public MyUser() {}

    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public Boolean getDeleted() {return deleted;}
    public void setDeleted(Boolean deleted) {this.deleted = deleted;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyUser that = (MyUser) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(login, that.login)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(email, that.email)) return false;
        return Objects.equals(role, that.role);
    }
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
