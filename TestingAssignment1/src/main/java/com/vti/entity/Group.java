package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="Group")
public class Group implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "GroupId")
    private short groupId;

    @Column(name="GroupName", length = 50, nullable = false, unique = true)
    private String groupName;

    @Column(name="CreateDate",updatable = false )
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;


    public short getGroupId() {
        return groupId;
    }

    public void setGroupId(short groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
