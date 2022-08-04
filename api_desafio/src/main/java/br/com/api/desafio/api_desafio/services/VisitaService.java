package br.com.api.desafio.api_desafio.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.desafio.api_desafio.models.VisitaModel;
import br.com.api.desafio.api_desafio.repository.VisitaRepository;


@Service
public class VisitaService {
    
    @Autowired
    VisitaRepository visitaRepository;

    @Transactional
    public VisitaModel save(VisitaModel visitaModel) {
        return visitaRepository.save(visitaModel);
    }

    public List<VisitaModel> findAll() {
        return (List<VisitaModel>) visitaRepository.findAll();
    }

     public Optional<VisitaModel> findById(Long id) {
        return visitaRepository.findById(id);
    }
    
    @Transactional
    public void delete(VisitaModel visitsModel) {
        visitaRepository.delete(visitsModel);
    }
}
