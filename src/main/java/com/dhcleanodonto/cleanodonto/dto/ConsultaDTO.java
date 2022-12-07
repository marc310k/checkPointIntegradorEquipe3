package com.dh.cleanodonto.cleanodonto.dto;



import java.time.LocalDate;
import com.dh.cleanodonto.cleanodonto.model.Consulta;
import com.dh.cleanodonto.cleanodonto.model.Dentista;
import com.dh.cleanodonto.cleanodonto.model.Paciente;






public class ConsultaDTO {

    private LocalDate dataConsulta;
    private PacienteDTO paciente;
    private DentistaDTO dentista;

    

	public ConsultaDTO() {
		super();
	}



    
    public ConsultaDTO(LocalDate dataConsulta, PacienteDTO paciente, DentistaDTO dentista) {
		this.dataConsulta = dataConsulta;
		this.paciente = paciente;
		this.dentista = dentista;
	}


	public LocalDate getDataConsulta() {
		return dataConsulta;
	}




	public void setDataConsulta(LocalDate dataConsulta) {
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
			Consulta consulta = new Consulta( null, dataConsulta,paciente, dentista);
			return consulta;
			
	    }
}
