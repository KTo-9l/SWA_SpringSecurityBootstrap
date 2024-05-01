package org.sillysociety.models.chemistry;

import jakarta.persistence.*;

@Entity
@Table(name="experiment_brigade", schema="chemistry")
public class ExperimentBrigade {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="experiment_brigade_id", nullable = false)
    private Integer experiment_brigade_id;
    @ManyToOne
    @JoinColumn(name="experiment_id")
    private Experiment experiment_id;
    @ManyToOne
    @JoinColumn(name="brigade_id")
    private Brigade brigade_id;

    public ExperimentBrigade() {}
    public ExperimentBrigade(Integer experiment_brigade_id, Experiment experiment_id, Brigade brigade_id) {
        this.experiment_brigade_id = experiment_brigade_id;
        this.experiment_id = experiment_id;
        this.brigade_id = brigade_id;
    }

    public void setExperiment_brigade_id(Integer experimentBrigadeId) {
        this.experiment_brigade_id = experimentBrigadeId;
    }
    public Integer getExperiment_brigade_id() {
        return experiment_brigade_id;
    }

    public Experiment getExperiment_id() {
        return experiment_id;
    }

    public void setExperiment_id(Experiment experiment_id) {
        this.experiment_id = experiment_id;
    }

    public Brigade getBrigade_id() {
        return brigade_id;
    }

    public void setBrigade_id(Brigade brigade_id) {
        this.brigade_id = brigade_id;
    }
}
