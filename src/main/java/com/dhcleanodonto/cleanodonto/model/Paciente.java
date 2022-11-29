package com.dh.cleanodonto.cleanodonto.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.dto.PacienteDTO;



@Entity



public class Paciente {
    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;
    
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    
    private String rg;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;


    
    

    public Paciente() {
		super();
	}


	public Paciente(Integer id, Usuario usuario, String rg, Endereco endereco) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.rg = rg;
		this.endereco = endereco;
	}







	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public Endereco getEndereco() {
		return endereco;
	}


	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	


	public PacienteDTO toDTO() {
        ModelMapper mapper = new ModelMapper();

        PacienteDTO dto = mapper.map(this, PacienteDTO.class);

        return dto;
	}
}
