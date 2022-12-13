package com.dh.cleanodonto.cleanodonto.model;

import com.dh.cleanodonto.cleanodonto.dto.EnderecoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;

@Data //CRIA OS GETTER E SETTER
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Endereco {
    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;



    public EnderecoDTO toDTO() {
        ModelMapper mapper = new ModelMapper();

        EnderecoDTO dto = mapper.map(this, EnderecoDTO.class);

        return dto;


    }

}
