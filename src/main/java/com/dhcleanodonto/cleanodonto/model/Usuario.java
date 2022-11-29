package com.dh.cleanodonto.cleanodonto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.dto.UsuarioDTO;

@Entity

public class Usuario {
	
    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;
    private String nome;
    private String sobrenome;


     
     
    
    
    
    

    public Usuario() {
		super();
	}





	public Usuario(Integer id, String nome, String sobrenome) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}




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
