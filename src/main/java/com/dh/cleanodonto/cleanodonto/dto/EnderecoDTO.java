package com.dh.cleanodonto.cleanodonto.dto;


import com.dh.cleanodonto.cleanodonto.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data //CRIA OS GETTER E SETTER
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO {

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o lougradouro")
    private String logradouro;

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o numero, ou s/n caso não haja numero")
    private String numero;

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o bairro")
    private String bairro;

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar cidade")
    private String cidade;

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar Estado")
    private String estado;

    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar o CEP")
    private String cep;

    public Endereco toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Endereco.class);
    }
}
