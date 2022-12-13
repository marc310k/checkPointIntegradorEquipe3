package com.dh.cleanodonto.cleanodonto.dto;

import com.dh.cleanodonto.cleanodonto.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data //CRIA OS GETTER E SETTER
@AllArgsConstructor
@NoArgsConstructor

public class UsuarioDTO {

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o nome")
    private String nome;

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o sobrenome")
    private String sobrenome;

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o CPF")
    @Size(min=9, max=11, message = "CPF precisa ter 11 caracteres.")
    private String cpf;


    public Usuario toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Usuario.class);
    }

}
