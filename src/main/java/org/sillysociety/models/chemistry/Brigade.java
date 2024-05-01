package org.sillysociety.models.chemistry;

import jakarta.persistence.*;

@Entity
@Table(name="brigade", schema="chemistry")
public class Brigade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="brigade_id", nullable = false)
    private Integer brigade_id;
    @Column(name="member_first", nullable = false)
    private String member_first;
    @Column(name="member_second", nullable = false)
    private String member_second;

    public Brigade() {}
    public Brigade(Integer brigade_id, String member_first, String member_second) {
        this.brigade_id = brigade_id;
        this.member_first = member_first;
        this.member_second = member_second;
    }

    public Integer getBrigade_id() {
        return brigade_id;
    }

    public void setBrigade_id(Integer brigade_id) {
        this.brigade_id = brigade_id;
    }

    public String getMember_first() {
        return member_first;
    }

    public void setMember_first(String member_first) {
        this.member_first = member_first;
    }

    public String getMember_second() {
        return member_second;
    }

    public void setMember_second(String member_second) {
        this.member_second = member_second;
    }
    @Override
    public String toString() {
        return "Brigade{" +
                "brigade_id=" + brigade_id +
                ", member_first='" + member_first + '\'' +
                ", member_second=" + member_second +
                '}';
    }
}
