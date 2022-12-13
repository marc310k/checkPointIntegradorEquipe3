package com.dh.cleanodonto.cleanodonto.dto;

import com.dh.cleanodonto.cleanodonto.model.Endereco;
import com.dh.cleanodonto.cleanodonto.model.Paciente;
import com.dh.cleanodonto.cleanodonto.model.Usuario;
import lombok.Data;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data //CRIA OS GETTER E SETTER


public class PacienteDTO {

    @Valid
    @NotEmpty(message ="O campo não pode ficar em branco") //PERMITE CAMPO VAZIO, MAS NÃO PERMITE CAMPO NULO,  CASO ACONTEÇA A MENSAGEM É EXIBIDA
    @NotNull(message = "É obrigatório informar o Usuario") // NotNull sinaliza que o campo não pode ser vazio
    private UsuarioDTO usuario;

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o RG")
    @Size(min=9, max=10, message = "Rg precisa ter 10 caracteres.")
    private String rg;

    @Valid
    @NotEmpty(message ="O campo não pode ficar em branco") //PERMITE CAMPO VAZIO, MAS NÃO PERMITE CAMPO NULO,  CASO ACONTEÇA A MENSAGEM É EXIBIDA
    @NotNull(message = "É obrigatório informar o Endereç0") // NotNull sinaliza que o campo não pode ser vazio
    private EnderecoDTO endereco;

    public PacienteDTO() {

    }

    public PacienteDTO(UsuarioDTO usuario, String rg, EnderecoDTO endereco) {
        this.usuario = usuario;
        this.rg = rg;
        this.endereco = endereco;
    }

    public Paciente toEntity() {

        Usuario usuario = this.usuario.toEntity();
        Endereco endereco = this.endereco.toEntity();
        Paciente paciente = new Paciente(null, usuario, this.rg, endereco );
        return paciente;
    }
}
