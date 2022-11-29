package com.dh.cleanodonto.cleanodonto.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.dto.DentistaDTO;


@Entity
public class Dentista {

	
	
	  @Id // ISSO MONSTRA PARA JPA QUE É UM ID
	    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
	    private Integer id;
	  
	  	@OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "usuario_id")
	    private Usuario usuario;
	    private String CRO;



	    
	    
	    public Dentista() {
			super();
		}



		public Dentista(Integer id, Usuario usuario, String cRO) {
			super();
			this.id = id;
			this.usuario = usuario;
			CRO = cRO;
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



		public String getCRO() {
			return CRO;
		}



		public void setCRO(String cRO) {
			CRO = cRO;
		}


		
		

		public DentistaDTO toDTO() {
	        ModelMapper mapper = new ModelMapper();

	        DentistaDTO dto = mapper.map(this, DentistaDTO.class);

	        return dto;
		}
}
