package com.dh.cleanodonto.cleanodonto.dto;




import org.modelmapper.ModelMapper;

import com.dh.cleanodonto.cleanodonto.model.Dentista;
import com.dh.cleanodonto.cleanodonto.model.Usuario;


public class DentistaDTO {


    
    private Usuario usuario;
   
  
    private String CRO;
    
    


    

    public DentistaDTO() {
		super();
	}




	public DentistaDTO( Usuario usuario, String cRO) {
		super();
		this.usuario = usuario;
		CRO = cRO;
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



	
	

	public Dentista toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Dentista.class);
    }

}
