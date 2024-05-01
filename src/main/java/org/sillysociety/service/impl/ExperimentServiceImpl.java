package org.sillysociety.service.impl;

import org.sillysociety.models.chemistry.Experiment;
import org.sillysociety.repository.chemistry.ExperimentRepository;
import org.sillysociety.service.ExperimentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperimentServiceImpl implements ExperimentsService {
    @Autowired
    private ExperimentRepository experimentRepository;

    @Override
    public Experiment addExperiment(Experiment experiment) {
        return experimentRepository.save(experiment);
    }

    @Override
    public void delete(Experiment experiment) {
        experimentRepository.delete(experiment);
    }

    @Override
    public Experiment getById(Integer id) {
        return experimentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Experiment> getAllExperiments() {
        return (List<Experiment>) experimentRepository.findAll();
    }

    @Override
    public Experiment updateExperiment(Experiment experiment) {
        return experimentRepository.save(experiment);
    }
}
