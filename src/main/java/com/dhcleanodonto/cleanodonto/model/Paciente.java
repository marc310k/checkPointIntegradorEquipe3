package com.dh.cleanodonto.cleanodonto.model;

import com.dh.cleanodonto.cleanodonto.dto.PacienteDTO;
import lombok.*;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;

@Data //CRIA OS GETTER E SETTER
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity


public class Paciente {
    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.AUTO)//GERA ID AUTOMATICAMENTE
    private Integer id;
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String rg;
    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;




    public PacienteDTO toDTO() {
        ModelMapper mapper = new ModelMapper();

        PacienteDTO dto = mapper.map(this, PacienteDTO.class);

        return dto;


    }
}
