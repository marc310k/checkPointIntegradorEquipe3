package com.dh.cleanodonto.cleanodonto.dto;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;



//ESTE DTO É PARA ENTRADA DE DADOS NO CADASTRO DE CONSULTA
@JsonPropertyOrder({"idPaciente", "idDentista","dataConsulta"} )//PARA COLOCAR AS PROPRIEDADES NA ORDEM QUE VC DESEJA QUE APAREÇA

public class ConsultaCadastroDTO {

    @NotEmpty(message = "Necessário preencher todos os campos.")
    @NotNull(message = "Necessário preencher campo idDentista.")
    private LocalDateTime dataConsulta;

    @Valid
    @NotEmpty(message = "Necessário preencher todos os campos.")
    @NotNull(message = "Necessário preencher campo idDentista.")
    private Integer idDentista;

    @Valid
    @NotEmpty(message = "Necessário preencher todos os campos.")
    @NotNull(message = "Necessário preencher campo idPaciente.")
    private Integer idPaciente;


    public ConsultaCadastroDTO() {
    }


    public ConsultaCadastroDTO(LocalDateTime dataConsulta,Integer idDentista, Integer idPaciente) {
        this.dataConsulta = dataConsulta;
        this.idDentista = idDentista;
        this.idPaciente = idPaciente;
    }


    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }



    public Integer getIdDentista() {
        return idDentista;
    }

    public void setIdDentista(Integer idDentista) {
        this.idDentista = idDentista;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }
}