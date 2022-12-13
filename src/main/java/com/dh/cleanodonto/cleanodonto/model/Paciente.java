package com.dh.cleanodonto.cleanodonto.model;
import com.dh.cleanodonto.cleanodonto.dto.EnderecoDTO;
import com.dh.cleanodonto.cleanodonto.dto.PacienteDTO;
import com.dh.cleanodonto.cleanodonto.dto.UsuarioDTO;
import lombok.*;
import javax.persistence.*;

import java.util.List;

@Data //CRIA OS GETTER E SETTER
@Getter
@Setter
@Entity


public class Paciente {
    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST)//ele só persiste os dados mas não consegue apagar
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private String rg;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)//campo de referencia na outra tabela ( se deletar um paciente ele já leva todas as consultas juntas)
    private List<Consulta> consultas;

    public Paciente() {
    }

    public Paciente(Integer id, Usuario usuario, String rg, Endereco endereco) {
        this.id = id;
        this.usuario = usuario;
        this.rg = rg;
        this.endereco = endereco;

    }

    public PacienteDTO toDTO() {

        UsuarioDTO usuario = this.usuario.toDTO();
        EnderecoDTO endereco = this.endereco.toDTO();
        PacienteDTO paciente = new PacienteDTO(usuario, this.rg, endereco);
        return paciente;

    }
}
