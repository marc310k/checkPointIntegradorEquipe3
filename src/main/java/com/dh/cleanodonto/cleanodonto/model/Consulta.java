package com.dh.cleanodonto.cleanodonto.model;

import com.dh.cleanodonto.cleanodonto.dto.*;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDateTime;


@Data //CRIA OS GETTER E SETTER

@Entity

public class Consulta {

    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GERA ID AUTOMATICAMENTE
    private Integer id;


    @FutureOrPresent(message = "Não é permitido agendamentos em datas anteriores")
    @Column(unique=true, nullable = false )
    private LocalDateTime dataConsulta;


    //MUITAS CONSULTAS PARA UM PACIENTE EM RELAÇÃO A ESSA CONSULTA (UM OBJETO OU SEJA, SÓ UMA CONSULTA POR VEZ)
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;



    //MUITAS CONSULTAS PARA UM DENTISTA EM RELAÇÃO A ESSA CONSULTA, OU SEJA(SÓ UMA CONSULTA POR VEZ)
    @ManyToOne
    @JoinColumn(name = "dentista_id")
    private Dentista dentista;





    public Consulta() {

    }

    public Consulta(LocalDateTime dataConsulta, Paciente paciente, Dentista dentista) {
        this.dataConsulta = dataConsulta;
        this.paciente = paciente;
        this.dentista = dentista;
    }




    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Dentista getDentista() {
        return dentista;
    }

    public void setDentista(Dentista dentista) {
        this.dentista = dentista;
    }




    public ConsultaDTO toDTO() {

        PacienteDTO paciente = this.paciente.toDTO();
        DentistaDTO dentista = this.dentista.toDTO();
        ConsultaDTO consulta = new ConsultaDTO( dataConsulta, paciente, dentista);
        return consulta;

    }



    //SEGUNDO METODO DE CONVERSÃO  RETORNO DO CADASTRO PARA ConfirmaConsultaDTO
    public ConfirmaConsultaDTO toConfirmaDTO() {
        return new ConfirmaConsultaDTO(this.dataConsulta, this.dentista.getId(), this.dentista.getUsuario().getNome(),  this.paciente.getId(),this.paciente.getUsuario().getNome());

    }

}
