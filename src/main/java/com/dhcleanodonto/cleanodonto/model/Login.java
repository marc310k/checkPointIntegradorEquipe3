package com.dh.cleanodonto.cleanodonto.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.dto.LoginDTO;




@Entity
public class Login {
	

    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;
    
    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    private String login;
    private String senha;
    private String acesso;


    
  
    
    
    
    public Login() {
		super();
	}



	public Login(Integer id, Usuario usuario, String login, String senha, String acesso) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.login = login;
		this.senha = senha;
		this.acesso = acesso;
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



	public String getAcesso() {
		return acesso;
	}



	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}


	
	

	public LoginDTO toDTO() {
        ModelMapper mapper = new ModelMapper();

        LoginDTO dto = mapper.map(this, LoginDTO.class);

        return dto;
	}
}
