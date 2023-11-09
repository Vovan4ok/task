package models;

import javax.persistence.*;
import java.util.Objects;

@jakarta.persistence.Entity
@Entity
@Table(name="user")
public class User {
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    @Id
    @Column(name="id")
    @GeneratedValue
    @jakarta.persistence.Column(name = "id", nullable = false)
    private Integer id;
    @jakarta.persistence.Basic
    @Column(name="name")
    @jakarta.persistence.Column(name = "name", nullable = false, length = 45)
    private String name;
    @jakarta.persistence.Basic
    @Column(name="surname")
    @jakarta.persistence.Column(name = "surname", nullable = false, length = 45)
    private String surname;
    @jakarta.persistence.Basic
    @Column(name="email")
    @jakarta.persistence.Column(name = "email", nullable = false, length = 45)
    private String email;
    @jakarta.persistence.Basic
    @Column(name="password")
    @jakarta.persistence.Column(name = "password", nullable = false, length = 45)
    private String password;
    @jakarta.persistence.Basic
    @Column(name="role")
    @jakarta.persistence.Column(name = "role", nullable = false, length = 45)
    private String role;
    public User() {}

    public User(Integer id, String name, String surname, String email, String password, String role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    public User(String name, String surname, String email, String password, String role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public User(String name, String surname, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = "default";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(surname, user.surname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, password, role);
    }

    @Override
    public String toString() {
        return "User [" + "id = " + id + ", name='" + name + '\'' + ", surname='" + surname + '\'' +
                ", email='" + email + '\'' + ", password='" + password + '\'' + ", role='" + role + '\'' + ']';
    }

}
