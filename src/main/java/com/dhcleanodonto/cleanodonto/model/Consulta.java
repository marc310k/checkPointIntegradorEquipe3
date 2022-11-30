package com.dh.cleanodonto.cleanodonto.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.dto.ConsultaDTO;



@Entity
public class Consulta {
	
	@Id // ISSO MONSTRA PARA JPA QUE É UM ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // GERA ID AUTOMATICAMENTE
	private Integer id;
	
	
	private LocalDate dataConsulta;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "dentista_id")
	private Dentista dentista;
	
	
	
	

	public Consulta() {
		super();
	}

	
	
	public Consulta(Integer id, LocalDate dataConsulta, Paciente paciente, Dentista dentista) {
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

	public ConsultaDTO toDTO() {
		ModelMapper mapper = new ModelMapper();

		ConsultaDTO dto = mapper.map(this, ConsultaDTO.class);

		return dto;

	}
}