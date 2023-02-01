package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name="Account")
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "AccountId")
    private short accountId;

    @Column(name = "Email",  length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "UserName",  length = 50, nullable = false, unique = true, updatable = false)
    private String userName;

    @Column(name = "FullName",  length = 50, nullable = false)
    private String fullName;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }



    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }


    public short getAccountId() {
        return accountId;
    }

    public void setAccountId(short accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createDate='" + createDate + '\'' +
                '}';
    }
}
