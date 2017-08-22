package com.brainacad.oop.testpredefannotation;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;

    List<PermissionAction> permissions = new ArrayList<>();

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public List<PermissionAction> getPermissions() {
        return permissions;
    }

    public void addPermission(PermissionAction permission) {
        this.permissions.add(permission);
    }

}
