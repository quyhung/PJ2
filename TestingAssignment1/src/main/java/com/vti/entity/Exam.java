package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class Exam implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExamId", nullable = false)
    private short examId;
    public Exam(){

    }

    @Column(name="`Code`", length = 50, nullable = false)
    private String code;

    @Column(name="Title", length = 50, nullable = false)
    private String title;

    @Column(name="Duration",  columnDefinition = "tinyint default 45")
    private short duration;

    @Column(name="CreateDate",  updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public short getExamId() {
        return examId;
    }

    public void setExamId(short examId) {
        this.examId = examId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public Date getCreateDate(Date createDate) {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", createDate=" + createDate +
                '}';
    }
}
