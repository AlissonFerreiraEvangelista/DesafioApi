package br.com.api.desafio.api_desafio.services;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import br.com.api.desafio.api_desafio.models.WorkspaceModel;
import br.com.api.desafio.api_desafio.repository.WorkspaceRepository;


@Service
public class WorkspaceService {

    @Autowired
    WorkspaceRepository workspaceRepository;

    @Transactional
    public WorkspaceModel save(WorkspaceModel workspaceModel) {
        return workspaceRepository.save(workspaceModel);
    }

    public List<WorkspaceModel> findAll() {
        return workspaceRepository.findAll();
    }

    public Optional<WorkspaceModel> findById(Long id) {
        return workspaceRepository.findById(id);
    }

    @Transactional
    public void delete(WorkspaceModel workspaceModel) {
        workspaceRepository.delete(workspaceModel);
    }
    
}
