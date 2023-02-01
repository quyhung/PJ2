package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Answer")
public class Answer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AnswersID")
    private short answersId;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @Column(name = "isCorrect")
    private boolean isCorrect;

    public short getAnswerId() {
        return answersId;
    }

    public void setAnswerId(short answerId) {
        this.answersId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answersId +
                ", content='" + content + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
