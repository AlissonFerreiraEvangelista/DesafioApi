package br.com.api.desafio.api_desafio.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.api.desafio.api_desafio.enums.Kind;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Table(name = "workspace")
public class WorkspaceModel implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    private String name;

    @Enumerated(EnumType.STRING)
    private Kind kind;
    

    private String description;

    @JsonIgnore 
    @OneToMany(mappedBy = "workspaceModel")
    private List<VisitaModel> visitaModel;
}
