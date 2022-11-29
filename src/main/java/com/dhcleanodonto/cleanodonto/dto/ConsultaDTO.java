package com.dh.cleanodonto.cleanodonto.dto;

import java.time.LocalDate;
import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.model.Consulta;
import com.dh.cleanodonto.cleanodonto.model.Dentista;
import com.dh.cleanodonto.cleanodonto.model.Paciente;





public class ConsultaDTO {
    private Integer id;
    private LocalDate dataConsulta;
    private Paciente paciente;
    private Dentista dentista;

    
    
    




	public ConsultaDTO() {
		super();
	}



    
    public ConsultaDTO(Integer id, LocalDate dataConsulta,
			Paciente paciente, Dentista dentista) {
		super();
		this.id = id;
		this.dataConsulta = dataConsulta;
		this.paciente = paciente;
		this.dentista = dentista;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}




	public LocalDate getDataConsulta() {
		return dataConsulta;
	}




	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
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











	public Consulta toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Consulta.class);
    }


}
