package com.dh.cleanodonto.cleanodonto.controller;




import com.dh.cleanodonto.cleanodonto.constante.Messages;
import com.dh.cleanodonto.cleanodonto.dto.LoginDTO;
import com.dh.cleanodonto.cleanodonto.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name= Messages.SWAGGER_TAG_LOGIN_ENDPOINT ) //RECURSO DO SWAGGER PARA MODIFICAÇÕES NOS NOMES DA API
@RestController //verbos das requisição https
@RequestMapping("login")
@CrossOrigin(origins = "http://localhost:")//não esquecer de preencher
public class LoginController {

    @Autowired
    private LoginService loginService;


    @Operation(description = Messages.SWAGGER_GET_ALL)
    @GetMapping("")
    public ResponseEntity<List<LoginDTO>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.getAll());

    }

    @Operation(description = Messages.SWAGGER_GET)
    @GetMapping("{id}")
    public ResponseEntity<LoginDTO> getOne(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(loginService.getOne(id));
    }


    @Operation(description = Messages.SWAGGER_INSERT)
    @PostMapping("")
    public ResponseEntity<LoginDTO> save(@Valid @RequestBody LoginDTO login)	{
        return ResponseEntity.status(HttpStatus.OK).body(loginService.save(login.toEntity()));

    }


    @Operation(description = Messages.SWAGGER_UPDATE)
    @PatchMapping("{id}")
    public ResponseEntity<LoginDTO> update(@PathVariable Integer id, @RequestBody LoginDTO login){
        return ResponseEntity.status(HttpStatus.OK).body(loginService.update(id, login.toEntity()));

    }

    @Operation(description = Messages.SWAGGER_DELETE)
    @DeleteMapping("{id}")
    public  void  delete(@PathVariable Integer id) {

        loginService.delete(id);


    }
}
