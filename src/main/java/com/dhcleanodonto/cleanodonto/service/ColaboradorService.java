package com.dh.cleanodonto.cleanodonto.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.dh.cleanodonto.cleanodonto.dto.ColaboradorDTO;
import com.dh.cleanodonto.cleanodonto.model.Colaborador;
import com.dh.cleanodonto.cleanodonto.repository.ColaboradorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ColaboradorService {
	
	//INJEÇÃO DE DEPENDENCIA
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    //METODO LISTAR TUDO
    		public List<ColaboradorDTO> getAll(){

        List<Colaborador> lista = colaboradorRepository.findAll();
        List<ColaboradorDTO> listaDTO = new ArrayList<>();
        for (Colaborador colaborador : lista) {
            listaDTO.add(colaborador.toDTO()); //CONVERSOR ARRAY PARA STRING
        }

        return listaDTO;

    }

    public ColaboradorDTO getOne(int id) {
        Optional<Colaborador> optional = colaboradorRepository.findById(id);
        Colaborador colaborador = optional.orElse( new Colaborador());
        return colaborador.toDTO();
    }


    public ColaboradorDTO save(Colaborador usuario) {
        return colaboradorRepository.save(usuario).toDTO();

    }


    public ColaboradorDTO update(int id, Colaborador novoColaborar) {

        //VERIFICAR SE O REGISTRO EXISTE
        Optional<Colaborador> optional = colaboradorRepository.findById(id);

        //SE EXISTIR
        if(optional.isPresent() == true) {
            //PEGAR O OBJETO DENTRO O OPTIONAL VINDO DO BANCO E SETAR COM O VALOR DE ENTRADA DO PARAMETRO DA METODO
            Colaborador colaboradorBD = optional.get();
            colaboradorBD.setUsuario(novoColaborar.getUsuario());
            colaboradorBD.setSetor(novoColaborar.getSetor());


            return colaboradorRepository.save(colaboradorBD).toDTO();
        }

        else {
            return new Colaborador().toDTO();
        }
    }

    public void delete(int id) {
        colaboradorRepository.deleteById(id);
    }


}


