package com.dh.cleanodonto.cleanodonto.controller;



import com.dh.cleanodonto.cleanodonto.constante.Messages;
import com.dh.cleanodonto.cleanodonto.dto.PacienteDTO;
import com.dh.cleanodonto.cleanodonto.exception.ConsultaNaoPodeSerCadastradaException;
import com.dh.cleanodonto.cleanodonto.model.Paciente;
import com.dh.cleanodonto.cleanodonto.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name= Messages.SWAGGER_TAG_PACIENTE_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController //verbos das requisição https
@RequestMapping("paciente")
@CrossOrigin(origins = "")//não esquecer de preencher
@SpringBootApplication
public class PacienteController {

        private static Logger logger = LoggerFactory.getLogger(PacienteController.class);
        @Autowired
        private PacienteService pacienteService;


        @Operation(description = Messages.SWAGGER_GET_ALL)
        @GetMapping("")
        public ResponseEntity<List<PacienteDTO>> getAll(){
                logger.info("Busca Realizada com Sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(pacienteService.getAll());

        }

        @Operation(description = Messages.SWAGGER_GET)
        @GetMapping("{id}")
        public ResponseEntity<PacienteDTO> getOne(@PathVariable Integer id) throws ConsultaNaoPodeSerCadastradaException {
                try {
                        logger.info("Paciente Encontrado com Sucesso!");
                        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.getOne(id));

                }catch(Exception e) {
                        logger.error("Paciente não cadastrado.");
                        throw new ConsultaNaoPodeSerCadastradaException("Paciente não cadastrado.");
                }
        }


        @Operation(description = Messages.SWAGGER_INSERT)
        @PostMapping("")
        public ResponseEntity<PacienteDTO> save(@Valid @RequestBody  PacienteDTO pacienteDTO) throws ConsultaNaoPodeSerCadastradaException {

                try {
                        logger.info("Paciente Cadastrado com Sucesso!");
                        Paciente paciente = pacienteDTO.toEntity();
                        paciente.getUsuario().setTipoPessoa("Paciente");//UNICO DADO SETADO POR DEFAUL
                        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));


                }catch(Exception e) {
                        logger.error("CPF já esta cadastrado.");
                        throw new ConsultaNaoPodeSerCadastradaException("CPF já esta cadastrado.");
                }
        }



        @Operation(description = Messages.SWAGGER_UPDATE)
        @PatchMapping("{id}")
        public ResponseEntity<PacienteDTO> update(@PathVariable Integer id, @RequestBody PacienteDTO paciente){

                return ResponseEntity.status(HttpStatus.OK).body(pacienteService.update(id, paciente.toEntity()));

        }

        @Operation(description = Messages.SWAGGER_DELETE)
        @DeleteMapping("{id}")
        public  void  delete(@PathVariable Integer id) throws ConsultaNaoPodeSerCadastradaException {

                try {
                        logger.info("Paciente Deletado com Sucesso");
                        pacienteService.delete(id);

                }catch(Exception e) {
                        logger.error("Paciente não encontrado");
                        throw new ConsultaNaoPodeSerCadastradaException("Paciente não cadastrado.");
                }
        }

}
