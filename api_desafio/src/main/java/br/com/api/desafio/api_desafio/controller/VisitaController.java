package br.com.api.desafio.api_desafio.controller;

import java.time.LocalDate;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import br.com.api.desafio.api_desafio.models.VisitaModel;

import br.com.api.desafio.api_desafio.repository.VisitaRepository;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/visits")
public class VisitaController {

    @Autowired
    VisitaRepository visitaRepository;


    @GetMapping("/{workspaceId}")
    @ApiOperation(value = "Rota para listar todas as visitas de um workspace")
    public ResponseEntity<Object> getVisitaModel(@PathVariable("workspaceId") Long workspaceId){
        List<VisitaModel> model = visitaRepository.findByModels(workspaceId);       
        
        if(model.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sem registro de visita no workspace informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }


    @GetMapping("/{workspaceId}/")
    @ApiOperation(value = "Filtra visitas por data")
    public ResponseEntity<Object> getListDate(@PathVariable("workspaceId")Long workspaceId,
    													@RequestParam(value = "date") LocalDate data)  {
    	List<VisitaModel> model = visitaRepository.findByVisits(workspaceId, data);
        
        if(model.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sem registro de visita na data informada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(model);

    }
    
    @GetMapping("/find/")
    @ApiOperation(value = "Pesquisa por intervalo de data")
    public ResponseEntity<List<VisitaModel>>findDateBetween(@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate starDate,
    											 @RequestParam(value = "date2") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate){
    	
        List<VisitaModel> model = visitaRepository.findByStartDateBetween(starDate,endDate);
        
        if(model.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(model);

    }
    
    @GetMapping("/{workspaceId}/ano")
    @ApiOperation(value = "Pesquisa por ano")
    public ResponseEntity<Object> getYear(@PathVariable("workspaceId")Long workspaceId,
    									@RequestParam(value = "year") int year)  {
        List<VisitaModel> model = visitaRepository.findByYear(workspaceId,year);
        if(model.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sem registros de visitas no ano informado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(model);
    }
    
    @PostMapping("/")
    @ApiOperation(value = "salva um workspace")
    public ResponseEntity<VisitaModel> saveVisit(@RequestBody VisitaModel visitaModel){
        return ResponseEntity.status(HttpStatus.OK).body(visitaRepository.save(visitaModel));
    };
    
    

    
}
