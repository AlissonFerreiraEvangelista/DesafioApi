package br.com.api.desafio.api_desafio.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.desafio.api_desafio.dto.WorkspaceDto;
import br.com.api.desafio.api_desafio.models.WorkspaceModel;
import br.com.api.desafio.api_desafio.services.WorkspaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@Api(value = "API REST Desafio")
public class WorkspaceController {
    
    @Autowired
    WorkspaceService workspaceService;

    @PostMapping("/workspace/save")
    @ApiOperation(value = "salva um workspace")
    public ResponseEntity<WorkspaceModel> saveWorkspace(@RequestBody WorkspaceDto workspaceDto){
    	var workspaceModel = new WorkspaceModel();
    	BeanUtils.copyProperties(workspaceDto, workspaceModel);
        return ResponseEntity.status(HttpStatus.OK).body(workspaceService.save(workspaceModel));
    };
    
 

    @GetMapping("/workspaces")
    @ApiOperation(value = "Retorna uma lista de todos os workspaces cadastrados")
    public ResponseEntity<List<WorkspaceModel>> getAllWorkspace(){
        return ResponseEntity.status(HttpStatus.OK).body(workspaceService.findAll());
          
    };

    @GetMapping("/workspace/{id}")
    @ApiOperation(value = "Retorna um workspace cadastrados")
    public ResponseEntity<Object> getOneWorkspace(@PathVariable(value ="id") Long id){
        Optional<WorkspaceModel> workspaceModelOptional = workspaceService.findById(id);
        if(!workspaceModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Workspace not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(workspaceModelOptional.get());
    }
     

    @DeleteMapping("/workspace/{id}")
    @ApiOperation(value = "Deleta um workspace")
    public ResponseEntity<Object> deleteWorkspace(@PathVariable(value="id") Long id){
        Optional<WorkspaceModel> workspaceModelOptional = workspaceService.findById(id);
        if(!workspaceModelOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            workspaceService.delete(workspaceModelOptional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        
    }
}
