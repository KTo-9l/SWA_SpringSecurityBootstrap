package org.sillysociety.service;

import org.sillysociety.models.chemistry.Experiment;

import java.util.List;

public interface ExperimentsService {
    Experiment addExperiment(Experiment experiments);
    void delete(Experiment experiments);
    Experiment getById(Integer id);
    List<Experiment> getAllExperiments();
    Experiment updateExperiment(Experiment experiment);
}
