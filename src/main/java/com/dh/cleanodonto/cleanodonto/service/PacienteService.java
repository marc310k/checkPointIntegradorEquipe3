package com.dh.cleanodonto.cleanodonto.service;

import com.dh.cleanodonto.cleanodonto.dto.PacienteDTO;
import com.dh.cleanodonto.cleanodonto.model.Paciente;
import com.dh.cleanodonto.cleanodonto.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    //INJEÇÃO DE DEPENDENCIA
    @Autowired
    private PacienteRepository pacienteRespository;

    //METODO LISTAR TUDO
    public List<PacienteDTO> getAll(){

        List<Paciente> lista = pacienteRespository.findAll();
        List<PacienteDTO> listaDTO = new ArrayList<>();
        for (Paciente paciente : lista) {
            listaDTO.add(paciente.toDTO()); //CONVERSOR ARRAY PARA STRING
        }

        return listaDTO;



    }

    public PacienteDTO getOne(int id) {
        Optional<Paciente> optional = pacienteRespository.findById(id);
        Paciente paciente = optional.orElse( new Paciente());
        return paciente.toDTO();
    }


    public PacienteDTO save(Paciente paciente) {
        return pacienteRespository.save(paciente).toDTO();



    }


    public PacienteDTO update(int id, Paciente novoPaciente) {

        //VERIFICAR SE O REGISTRO EXISTE
        Optional<Paciente> optional = pacienteRespository.findById(id);

        //SE EXISTIR
        if(optional.isPresent() == true) {
            //PEGAR O OBJETO DENTRO O OPTIONAL VINDO DO BANCO E SETAR COM O VALOR DE ENTRADA DO PARAMETRO DA METODO
            Paciente pacienteBD = optional.get();
            pacienteBD.setUsuario(novoPaciente.getUsuario());
            pacienteBD.setEndereco(novoPaciente.getEndereco());
            pacienteBD.setRg(novoPaciente.getRg());

            return pacienteRespository.save(pacienteBD).toDTO();
        }

        else {
            return new Paciente().toDTO();
        }
    }



    public void delete(int id) {
        pacienteRespository.deleteById(id);
    }
}
