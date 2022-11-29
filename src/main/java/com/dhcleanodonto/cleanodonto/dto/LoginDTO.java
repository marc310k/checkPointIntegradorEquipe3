package com.dh.cleanodonto.cleanodonto.dto;

import com.dh.cleanodonto.cleanodonto.model.Login;
import com.dh.cleanodonto.cleanodonto.model.Usuario;
import org.modelmapper.ModelMapper;





public class LoginDTO {
    private Integer id;

    private Usuario usuario;

    private String login;
   

    private String senha;

    
    
    
    public LoginDTO() {
		super();
	}





	public LoginDTO(Integer id, Usuario usuario,String login, String senha) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.login = login;
		this.senha = senha;
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





	public String getLogin() {
		return login;
	}





	public void setLogin(String login) {
		this.login = login;
	}





	public String getSenha() {
		return senha;
	}





	public void setSenha(String senha) {
		this.senha = senha;
	}





	public Login toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Login.class);
    }
}
