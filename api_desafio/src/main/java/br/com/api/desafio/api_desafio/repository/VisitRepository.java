package br.com.api.desafio.api_desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.desafio.api_desafio.models.VisitModel;

@Repository
public interface VisitRepository extends JpaRepository<VisitModel,Long> {
    
}
