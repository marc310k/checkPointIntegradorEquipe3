package com.dh.cleanodonto.cleanodonto.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.dto.ColaboradorDTO;


@Entity
public class Colaborador {
	

	    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
	    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
	    private Integer id;
	    
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "usuario_id")
	    private Usuario usuario;
	    
	    private String setor;
	
	    
	    
	    
	
	
	    public Colaborador() {
			super();
		}
	
	
	
	
		public Colaborador(Integer id, Usuario usuario, String setor) {
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
	
	
	
		
		
	
		public ColaboradorDTO toDTO() {
	        ModelMapper mapper = new ModelMapper();
	
	        ColaboradorDTO dto = mapper.map(this, ColaboradorDTO.class);
	
	        return dto;
		}
}
