package com.example.biblioteca.resource.dto;

import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public class ErroResposta {

    private String status;
    private String mensagem;
    private List<ErroCampo> erros;

    public static ErroResposta erroResposta(String mensagem) {
        return new ErroResposta(String.valueOf(HttpStatus.BAD_REQUEST.value()),
                mensagem,
                Collections.emptyList()
        );
    }

    public static ErroResposta conflito(String mensagem) {
        return new ErroResposta(String.valueOf(HttpStatus.CONFLICT.value()),
                mensagem,
                Collections.emptyList()
        );
    }

    public ErroResposta() {
    }

    public ErroResposta(String status, String mensagem, List<ErroCampo> erros) {
        this.status = status;
        this.mensagem = mensagem;
        this.erros = erros;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return mensagem;
    }

    public void setMessage(String mensagem) {
        this.mensagem = mensagem;
    }

    public List<ErroCampo> getErros() {
        return erros;
    }

    public void setErros(List<ErroCampo> erros) {
        this.erros = erros;
    }
}
