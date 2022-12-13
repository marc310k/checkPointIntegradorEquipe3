package com.dh.cleanodonto.cleanodonto.controller;



import com.dh.cleanodonto.cleanodonto.constante.Messages;
import com.dh.cleanodonto.cleanodonto.dto.EnderecoDTO;
import com.dh.cleanodonto.cleanodonto.service.EnderecoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name= Messages.SWAGGER_TAG_ENDERECO_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
//@Hidden // esconde o endpoint
@RestController //verbos das requisição https
@RequestMapping("endereco")
@CrossOrigin(origins = "")//não esquecer de preencher
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
