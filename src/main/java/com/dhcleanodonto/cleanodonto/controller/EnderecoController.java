package com.dh.cleanodonto.cleanodonto.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dh.cleanodonto.cleanodonto.constante.Messages;
import com.dh.cleanodonto.cleanodonto.dto.EnderecoDTO;
import com.dh.cleanodonto.cleanodonto.service.EnderecoService;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import javax.validation.Valid;


@Hidden//PARA ESCONDER O ENDPOINT
@Tag(name= Messages.SWAGGER_TAG_ENDERECO_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController// VERBOS DAS REQUISICAO HTTPS 
@RequestMapping("endereco")
@CrossOrigin(origins = "")//NÃO ESQUECER DE PREENCHER
public class EnderecoController {
	
	 @Autowired
	    private EnderecoService enderecoService;


	    @Operation(description = Messages.SWAGGER_GET_ALL)
	    @GetMapping("")
	    public ResponseEntity<List<EnderecoDTO>> getAll(){
	        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getAll());

	    }

	    @Operation(description = Messages.SWAGGER_GET)
	    @GetMapping("{id}")
	    public ResponseEntity<EnderecoDTO> getOne(@PathVariable Integer id) {
	        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.getOne(id));
	    }


	    @Operation(description = Messages.SWAGGER_INSERT)
	    @PostMapping("")
	    public ResponseEntity<EnderecoDTO> save(@Valid @RequestBody EnderecoDTO endereco)	{
	        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.save(endereco.toEntity()));

	    }


	    @Operation(description = Messages.SWAGGER_UPDATE)
	    @PatchMapping("{id}")
	    public ResponseEntity<EnderecoDTO> update(@PathVariable Integer id, @RequestBody EnderecoDTO endereco){
	        return ResponseEntity.status(HttpStatus.OK).body(enderecoService.update(id, endereco.toEntity()));

	    }

	    @Operation(description = Messages.SWAGGER_DELETE)
	    @DeleteMapping("{id}")
	    public  void  delete(@PathVariable Integer id) {

	        enderecoService.delete(id);


	    }

}
