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
import com.dh.cleanodonto.cleanodonto.dto.ConsultaDTO;
import com.dh.cleanodonto.cleanodonto.service.ConsultaService;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import javax.validation.Valid;


//@Tag(name= Messages.SWAGGER_TAG_USUARIO_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController //verbos das requisição https
@RequestMapping("consulta")
@CrossOrigin(origins = "")//não esquecer de preencher
public class ConsultaController {

	
	 @Autowired
	    private ConsultaService consultaService;


	    @Operation(description = Messages.SWAGGER_GET_ALL)
	    @GetMapping("")
	    public ResponseEntity<List<ConsultaDTO>> getAll(){
	        return ResponseEntity.status(HttpStatus.OK).body(consultaService.getAll());

	    }

	    @Operation(description = Messages.SWAGGER_GET)
	    @GetMapping("{id}")
	    public ResponseEntity<ConsultaDTO> getOne(@PathVariable Integer id) {
	        return ResponseEntity.status(HttpStatus.OK).body(consultaService.getOne(id));
	    }


	    @Operation(description = Messages.SWAGGER_INSERT)
	    @PostMapping("")
	    public ResponseEntity<ConsultaDTO> save(@Valid @RequestBody ConsultaDTO consulta)	{
	        return ResponseEntity.status(HttpStatus.OK).body(consultaService.save(consulta.toEntity()));

	    }


	    @Operation(description = Messages.SWAGGER_UPDATE)
	    @PatchMapping("{id}")
	    public ResponseEntity<ConsultaDTO> update(@PathVariable Integer id, @RequestBody ConsultaDTO consulta){
	        return ResponseEntity.status(HttpStatus.OK).body(consultaService.update(id, consulta.toEntity()));

	    }

	    @Operation(description = Messages.SWAGGER_DELETE)
	    @DeleteMapping("{id}")
	    public  void  delete(@PathVariable Integer id) {

	        consultaService.delete(id);


	    }
	
}
