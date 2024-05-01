package org.sillysociety.models.chemistry;

import jakarta.persistence.*;

@Entity
@Table(name="experiment", schema="chemistry")
public class Experiment {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="experiment_id", nullable = false)
    private Integer experiment_id;
    @Column(name="experiment_name", nullable = false)
    private String experiment_name;
    @Column(name="experiment_status", nullable = false)
    private String experiment_status;

    public Experiment() {}
    public Experiment(Integer experiment_id, String experiment_name, String experiment_status) {
        this.experiment_id = experiment_id;
        this.experiment_name = experiment_name;
        this.experiment_status = experiment_status;
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

    @Override
    public String toString() {
        return "Experiment{" +
                "experiment_id=" + experiment_id +
                ", experiment_name='" + experiment_name + '\'' +
                ", experiment_status=" + experiment_status +
                '}';
    }
}
