package com.dh.cleanodonto.cleanodonto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.dto.EnderecoDTO;




@Entity
public class Endereco {
	
    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    
    
    
    
    
    public Endereco() {
		super();
	}

    


	public Endereco(Integer id, String logradouro, String numero, String bairro, String cidade, String estado,
			String cep) {
		super();
		this.id = id;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}


	




	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getCidade() {
		return cidade;
	}



	public void setCidade(String cidade) {
		this.cidade = cidade;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public EnderecoDTO toDTO() {
        ModelMapper mapper = new ModelMapper();

        EnderecoDTO dto = mapper.map(this, EnderecoDTO.class);

        return dto;
	}
}
