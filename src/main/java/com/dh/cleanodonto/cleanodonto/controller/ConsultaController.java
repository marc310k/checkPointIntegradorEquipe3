package com.dh.cleanodonto.cleanodonto.controller;
import com.dh.cleanodonto.cleanodonto.exception.ConsultaNaoPodeSerCadastradaException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
import com.dh.cleanodonto.cleanodonto.dto.ConfirmaConsultaDTO;
import com.dh.cleanodonto.cleanodonto.dto.ConsultaCadastroDTO;
import com.dh.cleanodonto.cleanodonto.dto.ConsultaDTO;
import com.dh.cleanodonto.cleanodonto.service.ConsultaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import javax.validation.Valid;

@Tag(name = Messages.SWAGGER_TAG_CONSULTA_ENDEPOINT) // RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController // VERBOS DAS REQUISICAO HTTPS
@RequestMapping("consulta")
@CrossOrigin(origins = "") // NÃO ESQUECER DE PREENCHER
@SpringBootApplication
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @Autowired
    private static Logger logger = LoggerFactory.getLogger(ConsultaController.class);

    @Operation(description = Messages.SWAGGER_GET_ALL)
    @GetMapping("")

    public ResponseEntity<List<ConsultaDTO>> getAll() {
        logger.info("Busca realizada com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(consultaService.getAll());

    }

    @Operation(description = Messages.SWAGGER_GET)
    @GetMapping("{id}")
    public ResponseEntity<ConsultaDTO> getOne(@PathVariable Integer id) throws ConsultaNaoPodeSerCadastradaException {
        try {
            logger.info("Busca realizada com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(consultaService.getOne(id));
        } catch (Exception e) {
            logger.error("Consulta não encontrada!");
            throw new ConsultaNaoPodeSerCadastradaException("Consulta não cadastrado.");
        }
    }

    @Operation(description = Messages.SWAGGER_INSERT)
    @PostMapping("")
    public ResponseEntity<ConfirmaConsultaDTO> save(@RequestBody @Valid ConsultaCadastroDTO consulta)
            throws ConsultaNaoPodeSerCadastradaException {
        try {
            logger.info("Consuta agendada com sucesso!");
            return ResponseEntity.status(HttpStatus.CREATED).body(consultaService.save(consulta.getDataConsulta(),
                    consulta.getIdPaciente(), consulta.getIdDentista()));
        } catch (Exception e) {
            logger.error("Erro ao agendar a consulta.");
            throw new ConsultaNaoPodeSerCadastradaException("Consta uma consulta agendada neste mesmo dia e horario.");
        }
    }

    @Operation(description = Messages.SWAGGER_UPDATE)
    @PatchMapping("{id}")
    public ResponseEntity<ConsultaDTO> update(@PathVariable Integer id, @RequestBody @Valid ConsultaDTO consulta)
            throws ConsultaNaoPodeSerCadastradaException {
        try {
            logger.info("Consulta alterada com sucesso!");
            return ResponseEntity.status(HttpStatus.OK).body(consultaService.update(id, consulta.toEntity()));
        } catch (Exception e) {
            logger.error("Erro ao alterar a consulta.");
            throw new ConsultaNaoPodeSerCadastradaException("Consulta não pode ser agendada.");
        }
    }

    @Operation(description = Messages.SWAGGER_DELETE)
    @DeleteMapping("{id}")
    public void delete(@PathVariable Integer id) {
        logger.info("Consulta deletada com sucesso!");
        consultaService.delete(id);

    }
}

