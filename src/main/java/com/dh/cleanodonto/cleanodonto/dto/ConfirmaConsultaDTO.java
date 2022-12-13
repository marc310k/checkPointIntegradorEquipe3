package com.dh.cleanodonto.cleanodonto.dto;



import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;


//ESTE DTO É PARA SAIDA DE DADOS APÓS O SALVAMENTO DA CONSULTA

@JsonPropertyOrder({"idPaciente", "nomePaciente", "idDentista", "nomeDentista", "dataConsulta" } )//PARA COLOCAR AS PROPRIEDADES NA ORDEM QUE VC DESEJA QUE APAREÇA
public class ConfirmaConsultaDTO {

    private LocalDateTime dataConsulta;

    private Integer idDentista;
    private String nomeDentista;
    private Integer idPaciente;
    private String nomePaciente;


    public ConfirmaConsultaDTO() {
    }


    public ConfirmaConsultaDTO(LocalDateTime dataConsulta, Integer idDentista, String nomeDentista, Integer idPaciente, String nomePaciente) {
        this.dataConsulta = dataConsulta;
        this.idDentista = idDentista;
        this.nomeDentista = nomeDentista;
        this.idPaciente = idPaciente;
        this.nomePaciente = nomePaciente;
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

    public String getNomeDentista() {
        return nomeDentista;
    }

    public void setNomeDentista(String nomeDentista) {
        this.nomeDentista = nomeDentista;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
}
