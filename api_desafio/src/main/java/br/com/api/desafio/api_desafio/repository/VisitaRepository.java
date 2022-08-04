package br.com.api.desafio.api_desafio.repository;

import java.time.LocalDate;
import java.util.*;


import org.springframework.data.jpa.repository.*;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.desafio.api_desafio.models.VisitaModel;

@Repository
@Transactional
public interface VisitaRepository extends JpaRepository<VisitaModel, Long> {
    
    
    @Query(value = "FROM VisitaModel v WHERE v.workspaceModel.id = ?1")
    List<VisitaModel> findByModels(Long workspaceId);

    @Query(value = "SELECT v FROM VisitaModel v WHERE v.workspaceModel.id = ?1 AND v.data = ?2")
    public List<VisitaModel> findByVisits(Long workspaceId, LocalDate data);
    
    @Query(value="FROM VisitaModel v WHERE v.data BETWEEN ?1 AND ?2")
    List<VisitaModel> findByStartDateBetween(LocalDate starDate, LocalDate endDate);
    
    @Query(value = "FROM VisitaModel v WHERE v.workspaceModel.id = ?1 AND v.year = ?2")
    List<VisitaModel> findByYear(Long workspaceId, Integer year);

}
