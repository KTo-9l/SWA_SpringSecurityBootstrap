package org.sillysociety.service;

import org.sillysociety.models.chemistry.Brigade;

import java.util.List;

public interface BrigadeService {
    Brigade addBrigade(Brigade brigade);
    void delete(Brigade brigade);
    Brigade getById(Integer id);
    List<Brigade> getAllBrigades();
    Brigade updateBrigade(Brigade brigade);
}
