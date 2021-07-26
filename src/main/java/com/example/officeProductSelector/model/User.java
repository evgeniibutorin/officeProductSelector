package com.example.officeProductSelector.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@Table(name = "usr")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String login;

    String password;

    Status status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    List<Comment> comments;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    List<Mark> marks;

    public boolean isAdmin() {
        return Status.ADMIN.equals(this.status);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(login, user.login) && Objects.equals(password, user.password) && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, login, password, status);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}