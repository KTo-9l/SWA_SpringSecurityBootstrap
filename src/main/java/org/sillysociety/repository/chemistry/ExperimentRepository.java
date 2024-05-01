package org.sillysociety.repository.chemistry;

import org.sillysociety.models.chemistry.Experiment;
import org.springframework.data.repository.CrudRepository;

public interface ExperimentRepository extends CrudRepository<Experiment, Integer> {
}
