package org.sillysociety.models.chemistry;

import jakarta.persistence.*;

@Entity
@Table(name="experiment", schema="chemistry")
public class Experiment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="experiment_id", nullable = false)
    private Integer experiment_id;
    @Column(name="experiment_name")
    private String experiment_name;
    @Column(name="experiment_status")
    private String experiment_status;
    @Column(name="brigade_id")
    private Integer brigade_id;

    public Experiment() {}
    public Experiment(Integer experiment_id, String experiment_name, String experiment_status, Integer brigade_id) {
        this.experiment_id = experiment_id;
        this.experiment_name = experiment_name;
        this.experiment_status = experiment_status;
        this.brigade_id = brigade_id;
    }

    public Integer getExperiment_id() {
        return experiment_id;
    }

    public void setExperiment_id(Integer experiment_id) {
        this.experiment_id = experiment_id;
    }

    public String getExperiment_name() {
        return experiment_name;
    }

    public void setExperiment_name(String experiment_name) {
        this.experiment_name = experiment_name;
    }

    public String getExperiment_status() {
        return experiment_status;
    }

    public void setExperiment_status(String experiment_status) {
        this.experiment_status = experiment_status;
    }

    public Integer getBrigade_id() {
        return brigade_id;
    }

    public void setBrigade_id(Integer brigade_id) {
        this.brigade_id = brigade_id;
    }

    @Override
    public String toString() {
        return "Experiment{" +
                "experiment_id=" + experiment_id +
                ", experiment_name='" + experiment_name + '\'' +
                ", experiment_status=" + experiment_status +
                '}';
    }
}
