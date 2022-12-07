package com.dh.cleanodonto.cleanodonto.controller;



import javax.validation.Valid;

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
import com.dh.cleanodonto.cleanodonto.dto.PacienteDTO;
import com.dh.cleanodonto.cleanodonto.exception.CadastroInvalidoException;
import com.dh.cleanodonto.cleanodonto.model.Paciente;
import com.dh.cleanodonto.cleanodonto.service.PacienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;


@Tag(name = Messages.SWAGGER_TAG_PACIENTE_ENDPOINT )//RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController // VERBOS DAS REQUISICAO HTTPS 
@RequestMapping("paciente")
@CrossOrigin(origins ="http://localhost:")/// NÃO ESQUECER DE PREENCHER 
public class PacienteController {

	
	 @Autowired
     private PacienteService pacienteService;


     @Operation(description = Messages.SWAGGER_GET_ALL)
     @GetMapping("")
     public ResponseEntity<List<PacienteDTO>> getAll(){
         return ResponseEntity.status(HttpStatus.OK).body(pacienteService.getAll());

     }

     @Operation(description = Messages.SWAGGER_GET)
     @GetMapping("{id}")
     public ResponseEntity<PacienteDTO> getOne(@PathVariable Integer id) {
         return ResponseEntity.status(HttpStatus.OK).body(pacienteService.getOne(id));
     }


     @Operation(description = Messages.SWAGGER_INSERT)
     @PostMapping("")
     public ResponseEntity<PacienteDTO> save(@Valid @RequestBody PacienteDTO pacienteDTO) throws  CadastroInvalidoException{
    	try {
    	 Paciente paciente = pacienteDTO.toEntity();
    	 paciente.getUsuario().setTipoPessoa("Paciente");//unico dado setado por default
         return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));

     }catch(Exception e) {
    	 throw new CadastroInvalidoException("Paciente não existente!");
     }
   }

     @Operation(description = Messages.SWAGGER_UPDATE)
     @PatchMapping("{id}")
     public ResponseEntity<PacienteDTO> update(@PathVariable Integer id, @RequestBody PacienteDTO paciente){
         return ResponseEntity.status(HttpStatus.OK).body(pacienteService.update(id, paciente.toEntity()));

     }

     @Operation(description = Messages.SWAGGER_DELETE)
     @DeleteMapping("{id}")
     public  void  delete(@PathVariable Integer id) {

         pacienteService.delete(id);


     }
}
