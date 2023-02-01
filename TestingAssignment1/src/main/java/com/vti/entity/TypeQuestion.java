package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="TypeQuestion")
public class TypeQuestion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "TypeId", nullable = false)
    private short typeId;

    @Column(name="TypeName", nullable = false, unique = true)
    private boolean typeName;

    public boolean isTypeName() {
        return typeName;
    }

    public void setTypeName(boolean typeName) {
        this.typeName = typeName;
    }

    public short getTypeId() {
        return typeId;
    }

    public void setTypeId(short typeId) {
        this.typeId = typeId;
    }
}
