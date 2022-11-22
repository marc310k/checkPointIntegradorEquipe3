package com.dhcleanodonto.cleanodonto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.modelmapper.ModelMapper;
import com.dhcleanodonto.cleanodonto.dto.UsuarioDTO;





@Entity
public class Usuario {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Integer id;
	private String nome;
	private String sobrenome;
	
	
	
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	
	
	




	public UsuarioDTO toDTO() {
		ModelMapper mapper = new ModelMapper();
		
		UsuarioDTO dto = mapper.map(this, UsuarioDTO.class);
		
		return dto;
	
	
	}
	

}
