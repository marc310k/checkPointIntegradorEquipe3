package com.dh.cleanodonto.cleanodonto.model;

import com.dh.cleanodonto.cleanodonto.dto.DentistaDTO;
import com.dh.cleanodonto.cleanodonto.dto.UsuarioDTO;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Data //CRIA OS GETTER E SETTER

@Entity

public class Dentista {
    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;



    @Size(min=5, max=6, message = "CRO precisa ter 06 caracteres.")
    private String cro;

    //@OneToMany(mappedBy = "dentista", cascade = CascadeType.ALL)//campo de referencia na outra tabela ( se deletar um paciente ele já leva todas as consultas juntas)
    //private List<Consulta> consultas;

    public Dentista() {
    }

    public Dentista(Usuario usuario, String cro) {
        this.usuario = usuario;
        this.cro = cro;

    }

    public DentistaDTO toDTO() {
        UsuarioDTO usuario = this.usuario.toDTO(); // pegar um dto
        DentistaDTO dentista = new DentistaDTO(usuario, this.cro); //conversao para entity
        return dentista;


    }


}
