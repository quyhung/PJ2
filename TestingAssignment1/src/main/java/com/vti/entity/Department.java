package com.vti.entity;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "Department")
public class Department implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentId")
    private short departmentId;

    @Column(name = "DepartmentName", length = 50, nullable = false, unique = true)
    private String departmentName;

    public short getId() {
        return departmentId;
    }

    public void setId(short departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return departmentName;
    }

    public void setName(String name) {
        this.departmentName = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + departmentId +
                ", name='" + departmentName + '\'' +
                '}';
    }
}
