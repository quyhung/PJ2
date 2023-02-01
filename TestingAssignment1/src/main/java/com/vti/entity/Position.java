package com.vti.entity;




import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Position")
public class Position implements Serializable {

    @Id
    @Column(name = "PositionId")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(generator = "article-sequence-generator")
    @GenericGenerator(name = "article-sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "article_sequence"),
                    @Parameter(name = "initial_value", value = "10"),
                    @Parameter(name = "increment_size", value = "1")


            }
    )

    private short positionId;


    @Column(name = "PositionName", nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private PositionName positionName;

    public PositionName getPositionName() {
        return positionName;
    }

    public void setPositionName(PositionName positionName) {

        this.positionName = positionName;
    }

    public short getPositionId() {
        return positionId;
    }

    public void setPositionId(short positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionId=" + positionId +
                ", positionName=" + positionName +
                '}';
    }
}
