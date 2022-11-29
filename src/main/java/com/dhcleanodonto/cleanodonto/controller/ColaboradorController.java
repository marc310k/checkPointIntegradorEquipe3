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
import com.dh.cleanodonto.cleanodonto.dto.ColaboradorDTO;
import com.dh.cleanodonto.cleanodonto.service.ColaboradorService;

import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


//@Tag(name= Messages.SWAGGER_TAG_USUARIO_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController //verbos das requisição https
@RequestMapping("colaborador")
@CrossOrigin(origins = "")//não esquecer de preencher
public class ColaboradorController {
	
	@Autowired
    private ColaboradorService colaboradorService;


    @Operation(description = Messages.SWAGGER_GET_ALL)
    @GetMapping("")
    public ResponseEntity<List<ColaboradorDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.getAll());

    }

    @Operation(description = Messages.SWAGGER_GET)
    @GetMapping("{id}")
    public ResponseEntity<ColaboradorDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.getOne(id));
    }


    @Operation(description = Messages.SWAGGER_INSERT)
    @PostMapping("")
    public ResponseEntity<ColaboradorDTO> save(@Valid @RequestBody @NotNull ColaboradorDTO usuario)	{
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.save(usuario.toEntity()));

    }


    @Operation(description = Messages.SWAGGER_UPDATE)
    @PatchMapping("{id}")
    public ResponseEntity<ColaboradorDTO> update(@PathVariable Integer id, @RequestBody ColaboradorDTO colaborador){
        return ResponseEntity.status(HttpStatus.OK).body(colaboradorService.update(id, colaborador.toEntity()));

    }

    @Operation(description = Messages.SWAGGER_DELETE)
    @DeleteMapping("{id}")
    public  void  delete(@PathVariable Integer id) {

        colaboradorService.delete(id);


    }

}
