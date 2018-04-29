package com.zhc.collaborativeinnovation.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @Column(name = "roleid")
    private int roleid;

    @Column(name = "rolename")
    private String rolename;

    @Column(name = "permission")
    private String permission;

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (roleid != role.roleid) return false;
        if (rolename != null ? !rolename.equals(role.rolename) : role.rolename != null) return false;
        return permission != null ? permission.equals(role.permission) : role.permission == null;
    }

    @Override
    public int hashCode() {
        int result = roleid;
        result = 31 * result + (rolename != null ? rolename.hashCode() : 0);
        result = 31 * result + (permission != null ? permission.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "{\n\troleid : " + roleid + ",\n\trolename : " + rolename + ",\n\tpermission : " + permission + "\n}";
    }
}


