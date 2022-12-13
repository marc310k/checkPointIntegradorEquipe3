package com.dh.cleanodonto.cleanodonto.controller;



import com.dh.cleanodonto.cleanodonto.constante.Messages;
import com.dh.cleanodonto.cleanodonto.dto.UsuarioDTO;
import com.dh.cleanodonto.cleanodonto.service.UsuarioService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name= Messages.SWAGGER_TAG_USUARIO_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController //verbos das requisição https
@RequestMapping("usuario")
@CrossOrigin(origins ="http://localhost:")//não esquecer de preencher
@Hidden
@Validated
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @Operation(description = Messages.SWAGGER_GET_ALL)
    @GetMapping("")
    public ResponseEntity<List<UsuarioDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(usuarioService.getAll());

    }

    @Operation(description = Messages.SWAGGER_GET)
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
