package com.dh.cleanodonto.cleanodonto.service;

import com.dh.cleanodonto.cleanodonto.dto.EnderecoDTO;
import com.dh.cleanodonto.cleanodonto.model.Endereco;
import com.dh.cleanodonto.cleanodonto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    //INJEÇÃO DE DEPENDENCIA
    @Autowired
    private EnderecoRepository enderecoRepository;

    //METODO LISTAR TUDO
    public List<EnderecoDTO> getAll() {

        List<Endereco> lista = enderecoRepository.findAll();
        List<EnderecoDTO> listaDTO = new ArrayList<>();
        for (Endereco endereco : lista) {
            listaDTO.add(endereco.toDTO()); //CONVERSOR ARRAY PARA STRING
        }

        return listaDTO;

    }

    public EnderecoDTO getOne(int id) {
        Optional<Endereco> optional = enderecoRepository.findById(id);
        Endereco endereco = optional.orElse(new Endereco());
        return endereco.toDTO();
    }


    public EnderecoDTO save(Endereco endereco) {
        return enderecoRepository.save(endereco).toDTO();

    }


    public EnderecoDTO update(int id, Endereco novoEndereco) {

        //VERIFICAR SE O REGISTRO EXISTE
        Optional<Endereco> optional = enderecoRepository.findById(id);

        //SE EXISTIR
        if (optional.isPresent() == true) {
            //PEGAR O OBJETO DENTRO O OPTIONAL VINDO DO BANCO E SETAR COM O VALOR DE ENTRADA DO PARAMETRO DA METODO
            Endereco enderecoBD = optional.get();
            enderecoBD.setLogradouro(novoEndereco.getLogradouro());
            enderecoBD.setNumero(novoEndereco.getNumero());
            enderecoBD.setBairro(novoEndereco.getBairro());
            enderecoBD.setCidade(novoEndereco.getCidade());
            enderecoBD.setEstado(novoEndereco.getEstado());
            enderecoBD.setCep(novoEndereco.getCep());

            return enderecoRepository.save(enderecoBD).toDTO();
        } else {
            return new Endereco().toDTO();
        }
    }
        public void delete(int id) {
            enderecoRepository.deleteById(id);
        }
    }
