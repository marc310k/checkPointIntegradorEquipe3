package com.dh.cleanodonto.cleanodonto.controller;


import com.dh.cleanodonto.cleanodonto.constante.Messages;
import com.dh.cleanodonto.cleanodonto.dto.PacienteDTO;
import com.dh.cleanodonto.cleanodonto.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@Tag(name= Messages.SWAGGER_TAG_USUARIO_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController //verbos das requisição https
@RequestMapping("paciente")
@CrossOrigin(origins = "http://localhost:")//não esquecer de preencher
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
        public ResponseEntity<PacienteDTO> save(@Valid @RequestBody  PacienteDTO paciente)	{
            return ResponseEntity.status(HttpStatus.OK).body(pacienteService.save(paciente.toEntity()));

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
