package com.example.biblioteca.resource.dto;

public class ErroCampo {

    private String campo;
    private String erro;

    public ErroCampo() {
    }

    public ErroCampo(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
}
