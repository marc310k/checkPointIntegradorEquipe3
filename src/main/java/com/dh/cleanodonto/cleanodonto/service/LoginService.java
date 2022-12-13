package com.dh.cleanodonto.cleanodonto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.dh.cleanodonto.cleanodonto.dto.LoginDTO;
import com.dh.cleanodonto.cleanodonto.model.Login;
import com.dh.cleanodonto.cleanodonto.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    //METODO LISTAR TUDO
    public List<LoginDTO> getAll(){

        List<Login> lista = loginRepository.findAll();
        List<LoginDTO> listaDTO = new ArrayList<>();
        for (Login login : lista) {
            listaDTO.add(login.toDTO()); //CONVERSOR ARRAY PARA STRING
        }

        return listaDTO;

    }

    public LoginDTO getOne(int id) {
        Optional<Login> optional = loginRepository.findById(id);
        Login login = optional.orElse( new Login());
        return login.toDTO();
    }


    public LoginDTO save(Login login) {
        return loginRepository.save(login).toDTO();

    }


    public LoginDTO update(int id, Login novoLogin) {

        //VERIFICAR SE O REGISTRO EXISTE
        Optional<Login> optional = loginRepository.findById(id);

        //SE EXISTIR
        if(optional.isPresent() == true) {
            //PEGAR O OBJETO DENTRO O OPTIONAL VINDO DO BANCO E SETAR COM O VALOR DE ENTRADA DO PARAMETRO DA METODO
            Login loginBD = optional.get();
            loginBD.setUsername(novoLogin.getUsername());
            loginBD.setPassword(novoLogin.getPassword());


            return loginRepository.save(loginBD).toDTO();
        }

        else {
            return new Login().toDTO();
        }
    }

    public void delete(int id) {
        loginRepository.deleteById(id);
    }

}
