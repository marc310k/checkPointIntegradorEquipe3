package com.dh.cleanodonto.cleanodonto.dto;

import com.dh.cleanodonto.cleanodonto.model.Endereco;
import com.dh.cleanodonto.cleanodonto.model.Paciente;
import com.dh.cleanodonto.cleanodonto.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data //CRIA OS GETTER E SETTER
@AllArgsConstructor
@NoArgsConstructor

public class PacienteDTO {
    private Integer id;
    @NotEmpty(message ="O campo não pode ficar em branco") //PERMITE CAMPO VAZIO, MAS NÃO PERMITE CAMPO NULO,  CASO ACONTEÇA A MENSAGEM É EXIBIDA
    @NotNull(message = "É obrigatório informar o Usuario") // NotNull sinaliza que o campo não pode ser vazio
    private Usuario usuario;
    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o RG")
    private String rg;
    @NotEmpty(message ="O campo não pode ficar em branco") //PERMITE CAMPO VAZIO, MAS NÃO PERMITE CAMPO NULO,  CASO ACONTEÇA A MENSAGEM É EXIBIDA
    @NotNull(message = "É obrigatório informar o Endereç0") // NotNull sinaliza que o campo não pode ser vazio
    private Endereco endereco;



    public Paciente toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Paciente.class);
    }
}
