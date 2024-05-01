package org.sillysociety.service.impl;

import org.sillysociety.models.chemistry.Brigade;
import org.sillysociety.models.chemistry.Experiment;
import org.sillysociety.models.chemistry.ExperimentBrigade;
import org.sillysociety.repository.chemistry.BrigadeRepository;
import org.sillysociety.repository.chemistry.ExperimentBrigadeRepository;
import org.sillysociety.repository.chemistry.ExperimentRepository;
import org.sillysociety.service.ExperimentBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperimentBrigadeServiceImpl implements ExperimentBrigadeService {
    @Autowired
    private ExperimentBrigadeRepository experimentBrigadeRepository;
    @Autowired
    private BrigadeRepository brigadeRepository;
    @Autowired
    private ExperimentRepository experimentRepository;

    @Override
    public ExperimentBrigade addExperimentBrigade(ExperimentBrigade brigade) {
        return experimentBrigadeRepository.save(brigade);
    }

    @Override
    public void delete(ExperimentBrigade brigade) {
        experimentBrigadeRepository.delete(brigade);
    }

    @Override
    public ExperimentBrigade getById(Integer id) {
        return experimentBrigadeRepository.findById(id).orElse(null);
    }

    @Override
    public List<ExperimentBrigade> getAllExperimentBrigades() {
        return (List<ExperimentBrigade>) experimentBrigadeRepository.findAll();
    }

    @Override
    public ExperimentBrigade updateExperimentBrigade(ExperimentBrigade experimentBrigade) {
        return experimentBrigadeRepository.save(experimentBrigade);
    }

    @Override
    public Brigade addBrigade(Brigade brigade) {
        return brigadeRepository.save(brigade);
    }

    @Override
    public Experiment addExperiment(Experiment experiment) {
        return experimentRepository.save(experiment);
    }
}
