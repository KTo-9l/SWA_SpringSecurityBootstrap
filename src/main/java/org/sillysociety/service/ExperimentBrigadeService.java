package org.sillysociety.service;

import org.sillysociety.models.chemistry.ExperimentBrigade;

import java.util.List;

public interface ExperimentBrigadeService {
    ExperimentBrigade addExperimentBrigade(ExperimentBrigade experimentBrigade);
    void delete(ExperimentBrigade experimentBrigade);
    ExperimentBrigade getById(Integer id);
    List<ExperimentBrigade> getAllExperimentBrigades();
    ExperimentBrigade updateExperimentBrigade(ExperimentBrigade experimentBrigade);
}
