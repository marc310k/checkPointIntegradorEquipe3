package com.dhcleanodonto.cleanodonto.dto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import com.dhcleanodonto.cleanodonto.model.Usuario;



public class UsuarioDTO {
	
	
	private Integer id;
	
	@NotEmpty(message ="O campo não pode ficar em branco ")
	@NotNull (message ="É obrigatório informar o nome")
	private String nome;
	
	@NotEmpty(message ="O campo não pode ficar em branco ")
	@NotNull (message ="É obrigatório informar o sobrenome")
	private String sobrenome;
	
	@NotEmpty(message ="O campo não pode ficar em branco ")
	@NotNull (message ="É obrigatório informar o setor")

	
	
	
	
	
	public UsuarioDTO() {
		super();
	}

	
	
	
	

	public UsuarioDTO(Integer id,
			@NotEmpty(message = "O campo não pode ficar em branco ") @NotNull(message = "É obrigatório informar o nome") String nome,
			@NotEmpty(message = "O campo não pode ficar em branco ") @NotNull(message = "É obrigatório informar o sobrenome") String sobrenome) {
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


	
	



	public Usuario toEntity() {
		
		ModelMapper mapper = new ModelMapper();
		
		return mapper.map(this, Usuario.class);
 }

	

}
