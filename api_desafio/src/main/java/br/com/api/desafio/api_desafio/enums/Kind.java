package br.com.api.desafio.api_desafio.enums;

public enum Kind {
    APP("app"),SITE("site");

    private String descricao;
 
    Kind(String descricao) {
     this.descricao = descricao;
    }
 
    public String getDescicao() {
     return this.descricao;
    }
 
    @Override
    public String toString() {
     return this.descricao;
    }
 
}
