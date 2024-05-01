package org.sillysociety.service.impl;

import org.sillysociety.models.chemistry.ExperimentBrigade;
import org.sillysociety.repository.chemistry.ExperimentBrigadeRepository;
import org.sillysociety.service.ExperimentBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperimentBrigadeServiceImpl implements ExperimentBrigadeService {
    @Autowired
    private ExperimentBrigadeRepository experimentBrigadeRepository;

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
    public ExperimentBrigade updateExperimentBrigade(ExperimentBrigade brigade) {
        return experimentBrigadeRepository.save(brigade);
    }
}
