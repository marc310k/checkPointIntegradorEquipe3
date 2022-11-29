package com.dh.cleanodonto.cleanodonto.dto;


import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.model.Colaborador;
import com.dh.cleanodonto.cleanodonto.model.Usuario;




public class ColaboradorDTO {

    private Integer id;

    
    private Usuario usuario;
    

    private String setor;
    
    
    
    
    
    
    
    
    
    

    public ColaboradorDTO() {
		super();
	}







	public ColaboradorDTO(Integer id, Usuario usuario, String setor) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.setor = setor;
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




	public String getSetor() {
		return setor;
	}




	public void setSetor(String setor) {
		this.setor = setor;
	}







	public Colaborador toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Colaborador.class);
    }

}
