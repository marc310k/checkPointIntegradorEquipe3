package com.dh.cleanodonto.cleanodonto.model;


import com.dh.cleanodonto.cleanodonto.dto.UsuarioDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


import javax.persistence.*;


@Data //CRIA OS GETTER E SETTER
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Usuario {
    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;

    @Column(unique=true,nullable = false)
    private String nome;

    @Column(unique=true,nullable = false)
    private String sobrenome;
    //O CPF (SÓ PODERA SER GRAVADO UMA UNICA VEZ

    @Column(unique=true,nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String tipoPessoa;




    public UsuarioDTO toDTO() {
       ModelMapper mapper = new ModelMapper();

       UsuarioDTO dto = mapper.map(this, UsuarioDTO.class);

        return dto;


    }

}
