package com.dh.cleanodonto.cleanodonto.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.cleanodonto.cleanodonto.dto.UsuarioDTO;
import com.dh.cleanodonto.cleanodonto.model.Usuario;
import com.dh.cleanodonto.cleanodonto.repository.UsuarioRepository;


@Service
public class UsuarioService {
	
    //INJEÇÃO DE DEPENDENCIA
    @Autowired
    private UsuarioRepository usuarioRepository;

    //METODO LISTAR TUDO
    public List<UsuarioDTO> getAll(){

        List<Usuario> lista = usuarioRepository.findAll();
        List<UsuarioDTO> listaDTO = new ArrayList<>();
        for (Usuario usuario : lista) {
            listaDTO.add(usuario.toDTO()); //CONVERSOR ARRAY PARA STRING
        }

        return listaDTO;

    }


    public UsuarioDTO getOne(int id) {
        Optional<Usuario> optional = usuarioRepository.findById(id);
        Usuario usuario = optional.orElse( new Usuario());
        return usuario.toDTO();
    }


    public UsuarioDTO save(Usuario usuario) {
         return usuarioRepository.save(usuario).toDTO();

    }


    public UsuarioDTO update(int id, Usuario novoUsuario) {

        //VERIFICAR SE O REGISTRO EXISTE
        Optional<Usuario> optional = usuarioRepository.findById(id);

        //SE EXISTIR
        if(optional.isPresent() == true) {
            //PEGAR O OBJETO DENTRO O OPTIONAL VINDO DO BANCO E SETAR COM O VALOR DE ENTRADA DO PARAMETRO DA METODO
            Usuario usuarioBD = optional.get();
           usuarioBD.setNome(novoUsuario.getNome());
           usuarioBD.setSobrenome(novoUsuario.getSobrenome());


            return usuarioRepository.save(usuarioBD).toDTO();
        }

        else {
            return new Usuario().toDTO();
        }
    }

    public void delete(int id) {
    	usuarioRepository.deleteById(id);
	}
}
