package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CategoryQuestion")
public class CategoryQuestion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "CategoryId", nullable = false)
    private short categoryId;

    @Column(name="CategoryName", length=50, nullable = false, unique = true )
    private String categoryName;

    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryid) {
        this.categoryId = categoryid;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
