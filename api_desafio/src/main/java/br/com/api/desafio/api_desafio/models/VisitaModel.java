package br.com.api.desafio.api_desafio.models;

import java.io.Serializable;
import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="visit")
public class VisitaModel implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    
    	
    LocalDate data;
    int year;
    int month;
    int dayOfMonth;
    int datOfWeek;

 
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="visits_id")
    private VisitModel visits;
    
    @JsonIgnore 
    @ManyToOne
    @JoinColumn(name="workspace_id")
    private WorkspaceModel workspaceModel;

    
}
