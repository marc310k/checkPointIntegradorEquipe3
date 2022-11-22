package com.dhcleanodonto.cleanodonto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dhcleanodonto.cleanodonto.constantes.Messages;
import com.dhcleanodonto.cleanodonto.dto.UsuarioDTO;
import com.dhcleanodonto.cleanodonto.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController 
@RequestMapping("usuario")
public class UsuarioController {
	


	@Autowired
	private UsuarioService usuarioService;
	
	
	@Operation(description = Messages.SWAGGER_GET_ALL)
	@GetMapping("")
	public ResponseEntity<List<UsuarioDTO>> getAll(){	
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAll());
			
		}
	

		@Operation(description = Messages.SWAGGER_GET )
		@GetMapping("{id}")
		public ResponseEntity<UsuarioDTO> getOne(@PathVariable Integer id) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getOne(id));
		}
		
		
		@Operation(description = Messages.SWAGGER_INSERT)
		@PostMapping("")
		public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody  UsuarioDTO usuario)	{
		return ResponseEntity.status(HttpStatus.OK).body(usuarioService.save(usuario.toEntity()));
			
		}

		
		@Operation(description = Messages.SWAGGER_UPDATE)
		@PatchMapping("{id}")
		public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @RequestBody UsuarioDTO usuario){
	    return ResponseEntity.status(HttpStatus.OK).body(usuarioService.update(id, usuario.toEntity()));	
			
		}
		
		@Operation(description = Messages.SWAGGER_DELETE)
		@DeleteMapping("{id}")
		public  void  delete(@PathVariable Integer id) {

			usuarioService.delete(id);
			

		}

}
