package com.dh.cleanodonto.cleanodonto.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.cleanodonto.cleanodonto.dto.ConsultaDTO;
import com.dh.cleanodonto.cleanodonto.model.Consulta;
import com.dh.cleanodonto.cleanodonto.repository.ConsultaRepository;

@Service
public class ConsultaService {
	
	  //INJEÇÃO DE DEPENDENCIA
    @Autowired
    private ConsultaRepository consultaRepository;

    //METODO LISTAR TUDO
    public List<ConsultaDTO> getAll(){

        List<Consulta> lista = consultaRepository.findAll();
        List<ConsultaDTO> listaDTO = new ArrayList<>();
        for (Consulta consulta : lista) {
            listaDTO.add(consulta.toDTO()); //CONVERSOR ARRAY PARA STRING
        }

        return listaDTO;
    }

    public ConsultaDTO getOne(int id) {
        Optional<Consulta> optional = consultaRepository.findById(id);
        Consulta consulta = optional.orElse( new Consulta());
        return consulta.toDTO();
    }

    public ConsultaDTO save(Consulta consulta) {
        return consultaRepository.save(consulta).toDTO();
    }


    public ConsultaDTO update(int id, Consulta novoConsulta) {

        //VERIFICAR SE O REGISTRO EXISTE
        Optional<Consulta> optional = consultaRepository.findById(id);

        //SE EXISTIR
        if(optional.isPresent() == true) {
            //PEGAR O OBJETO DENTRO O OPTIONAL VINDO DO BANCO E SETAR COM O VALOR DE ENTRADA DO PARAMETRO DA METODO
            Consulta consultaBD = optional.get();
            consultaBD.setDataConsulta(novoConsulta.getDataConsulta());
            consultaBD.setPaciente(novoConsulta.getPaciente());
            consultaBD.setDentista(novoConsulta.getDentista());

            return consultaRepository.save(consultaBD).toDTO();
        }

        else {
            return new Consulta().toDTO();
        }
    }

    public void delete(int id) {
    	consultaRepository.deleteById(id);
    }


}
