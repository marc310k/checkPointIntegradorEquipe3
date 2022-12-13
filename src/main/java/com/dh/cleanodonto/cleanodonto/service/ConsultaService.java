package com.dh.cleanodonto.cleanodonto.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.dh.cleanodonto.cleanodonto.repository.ConsultaRepository;
import com.dh.cleanodonto.cleanodonto.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.cleanodonto.cleanodonto.dto.ConfirmaConsultaDTO;
import com.dh.cleanodonto.cleanodonto.dto.ConsultaDTO;
import com.dh.cleanodonto.cleanodonto.model.Consulta;
import com.dh.cleanodonto.cleanodonto.model.Dentista;
import com.dh.cleanodonto.cleanodonto.model.Paciente;

import com.dh.cleanodonto.cleanodonto.repository.DentistaRepository;


import javax.annotation.Resource;

@Service
public class ConsultaService {

    //INJEÇÃO DE DEPENDENCIA
    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private DentistaRepository dentistaRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    //METODO LISTAR TUDO
    public List<ConsultaDTO> getAll() {

        List<Consulta> lista = consultaRepository.findAll();
        List<ConsultaDTO> listaDTO = new ArrayList<>();
        for (Consulta consulta : lista) {
            listaDTO.add(consulta.toDTO()); //CONVERSOR ARRAY PARA STRING
        }

        return listaDTO;
    }

    public ConsultaDTO getOne(int id) {
        Optional<Consulta> optional = consultaRepository.findById(id);
        Consulta consulta = optional.orElse(new Consulta());
        return consulta.toDTO();
    }


    public ConfirmaConsultaDTO save(LocalDateTime dataConsulta, Integer idPaciente, Integer idDentista) {
        Dentista dentista = dentistaRepository.getReferenceById(idDentista);
        Paciente paciente = pacienteRepository.getReferenceById(idPaciente);

        Consulta consulta = new Consulta(dataConsulta, paciente, dentista);
        consulta = consultaRepository.save(consulta);
        return consulta.toConfirmaDTO();
    }





    public ConsultaDTO update(int id, Consulta novoConsulta) {

        //VERIFICAR SE O REGISTRO EXISTE
        Optional<Consulta> optional = consultaRepository.findById(id);

        //SE EXISTIR
        if(optional.isPresent()) {
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
