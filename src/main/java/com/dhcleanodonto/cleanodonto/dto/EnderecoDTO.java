package com.dh.cleanodonto.cleanodonto.dto;

import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.model.Endereco;

public class EnderecoDTO {
    private Integer id;
  
    private String logradouro;
    private String numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;


    
    
    
    
    
    
    public EnderecoDTO() {
		super();
	}



	public EnderecoDTO(Integer id,String logradouro, String numero, String bairro, String cidade, String estado, String cep) {
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



	public String getLougradouro() {
		return logradouro;
	}



	public void setLougradouro(String lougradouro) {
		this.logradouro = lougradouro;
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


	
	

	public Endereco toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Endereco.class);
    }
}
