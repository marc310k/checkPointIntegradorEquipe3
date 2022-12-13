package com.dh.cleanodonto.cleanodonto.dto;


import com.dh.cleanodonto.cleanodonto.model.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Data //CRIA OS GETTER E SETTER


public class ConsultaDTO {
    @NotEmpty(message ="O campo não pode ficar em branco")
    @NotNull(message = "É obrigatório informar um data")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dataConsulta;
    @Valid
    private PacienteDTO paciente;
    @Valid
    private DentistaDTO dentista;




    public ConsultaDTO() {

    }


    public ConsultaDTO(LocalDateTime dataConsulta, PacienteDTO paciente, DentistaDTO dentista) {
        this.dataConsulta = dataConsulta;
        this.paciente = paciente;
        this.dentista = dentista;
    }


    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public PacienteDTO getPaciente() {
        return paciente;
    }


    public void setPaciente(PacienteDTO paciente) {
        this.paciente = paciente;
    }


    public DentistaDTO getDentista() {
        return dentista;
    }




    public void setDentista(DentistaDTO dentista) {
        this.dentista = dentista;
    }






    public Consulta toEntity() {

        Paciente paciente = this.paciente.toEntity();
        Dentista dentista = this.dentista.toEntity();
        Consulta consulta = new Consulta( dataConsulta, paciente, dentista);
        return consulta;

    }

}
