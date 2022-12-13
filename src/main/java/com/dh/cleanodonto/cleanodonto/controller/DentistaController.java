package com.dh.cleanodonto.cleanodonto.controller;



import com.dh.cleanodonto.cleanodonto.constante.Messages;
import com.dh.cleanodonto.cleanodonto.dto.DentistaDTO;
import com.dh.cleanodonto.cleanodonto.exception.ConsultaNaoPodeSerCadastradaException;
import com.dh.cleanodonto.cleanodonto.model.Dentista;
import com.dh.cleanodonto.cleanodonto.service.DentistaService;
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

@Tag(name= Messages.SWAGGER_TAG_DENTISTA_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController //verbos das requisição https
@RequestMapping("dentista")
@CrossOrigin(origins = "")//não esquecer de preencher
@SpringBootApplication
public class DentistaController {

    private static Logger logger = LoggerFactory.getLogger(DentistaController.class);
    @Autowired
    private DentistaService dentistaService;


    @Operation(description = Messages.SWAGGER_GET_ALL)
    @GetMapping("")
    public ResponseEntity<List<DentistaDTO>> getAll(){
        logger.info("Busca Realizada com Sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(dentistaService.getAll());

    }

    @Operation(description = Messages.SWAGGER_GET)
    @GetMapping("{id}")
    public ResponseEntity<DentistaDTO> getOne(@PathVariable Integer id) throws ConsultaNaoPodeSerCadastradaException {
        try {
            logger.info("Dentista Encontrado com Sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(dentistaService.getOne(id));
        }catch(Exception e) {
            logger.error("Dentista não encontrado");
            throw new ConsultaNaoPodeSerCadastradaException("Dentista não cadastrado.");
        }
    }


    @Operation(description = Messages.SWAGGER_INSERT)
    @PostMapping("")
    public ResponseEntity<DentistaDTO> save(@RequestBody @Valid DentistaDTO dentistaDTO) throws ConsultaNaoPodeSerCadastradaException {
        logger.info("Dentista Cadastrado com Sucesso!");
        try {
            logger.info("Dentista Cadastrado com Sucesso!");
            Dentista dentista = dentistaDTO.toEntity();
            dentista.getUsuario().setTipoPessoa("Dentista");
            return ResponseEntity.status(HttpStatus.CREATED).body(dentistaService.save(dentista));

        }catch (Exception e) {
            logger.error("CPF já esta cadastrado.");
            throw new ConsultaNaoPodeSerCadastradaException("CPF já esta cadastrado.");
        }
    }

    @Operation(description = Messages.SWAGGER_UPDATE)
    @PatchMapping("{id}")
    public ResponseEntity<DentistaDTO> update(@PathVariable Integer id, @RequestBody @Valid DentistaDTO dentista){
        return ResponseEntity.status(HttpStatus.OK).body(dentistaService.update(id, dentista.toEntity()));

    }

    @Operation(description = Messages.SWAGGER_DELETE)
    @DeleteMapping("{id}")
    public  void  delete(@PathVariable Integer id) throws ConsultaNaoPodeSerCadastradaException {
        try {
            logger.info("Dentista Deletado com Sucesso");
            dentistaService.delete(id);

        }catch(Exception e) {
            logger.error("Dentista não encontrado");
            throw new ConsultaNaoPodeSerCadastradaException("Dentista não cadastrado.");
        }
    }

}
