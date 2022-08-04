package br.com.api.desafio.api_desafio.dto;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.api.desafio.api_desafio.enums.Kind;
import lombok.Data;

@Data
public class WorkspaceDto {
    
    private String name;
   

    @Enumerated(EnumType.STRING)
    private Kind kind;
   

    private String description;
}
