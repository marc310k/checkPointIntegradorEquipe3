package com.dh.cleanodonto.cleanodonto.dto;

import com.dh.cleanodonto.cleanodonto.model.Dentista;
import com.dh.cleanodonto.cleanodonto.model.Usuario;

import lombok.Data;


import javax.validation.Valid;

import javax.validation.constraints.NotNull;

@Data //CRIA OS GETTER E SETTER

public class DentistaDTO {


    @Valid
    //@NotBlank(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o Usuario")
    private UsuarioDTO usuario;
    //@NotBlank(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o CRO")
    private String cro;

    public DentistaDTO() {
    }

    public DentistaDTO(UsuarioDTO usuario, String cro) {
        this.usuario = usuario;
        this.cro = cro;
    }

    public Dentista toEntity() {

        Usuario usuario = this.usuario.toEntity();
        Dentista dentista = new Dentista(usuario, this.cro);
        return dentista;
    }

}
