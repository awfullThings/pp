package ru.kata.spring.boot_security.demo.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String rolename;
    @Transient
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>();

    public  Role(){
    }
    public Role(int id) {
        this.id = id;
    }

    public Role(int id, String role) {
        this.id = id;
        this.rolename = role;
    }
    public String getNoPrefix() {
        String prefix = "ROLE_";
        return rolename.substring(prefix.length());
    }


    public String getRole() {
        return rolename; }

    public void setRole(String role) {
        this.rolename = role;
    }

    @Override
    public String getAuthority() {
        return rolename;
    }

    @Override
    public String toString() {
        return rolename;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return id == role.id && Objects.equals(rolename, role.rolename) && Objects.equals(users, role.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rolename, users);
    }


}
