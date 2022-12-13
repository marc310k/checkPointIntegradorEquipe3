package com.dh.cleanodonto.cleanodonto.service;

import com.dh.cleanodonto.cleanodonto.dto.DentistaDTO;
import com.dh.cleanodonto.cleanodonto.model.Dentista;
import com.dh.cleanodonto.cleanodonto.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistaService {
    //INJEÇÃO DE DEPENDENCIA
    @Autowired
    private DentistaRepository dentistaRepository;

    //METODO LISTAR TUDO
    public List<DentistaDTO> getAll(){

        List<Dentista> lista = dentistaRepository.findAll();
        List<DentistaDTO> listaDTO = new ArrayList<>();
        for (Dentista dentista : lista) {
            listaDTO.add(dentista.toDTO()); //CONVERSOR ARRAY PARA STRING
        }

        return listaDTO;

    }

    public DentistaDTO getOne(int id) {
        Optional<Dentista> optional = dentistaRepository.findById(id);
        Dentista dentista = optional.orElse( new Dentista());
        return dentista.toDTO();
    }

    public DentistaDTO save(Dentista dentista) {
        return dentistaRepository.save(dentista).toDTO();

    }


    public DentistaDTO update(int id, Dentista novoDentista) {

        //VERIFICAR SE O REGISTRO EXISTE
        Optional<Dentista> optional = dentistaRepository.findById(id);

        //SE EXISTIR
        if(optional.isPresent() == true) {
            //PEGAR O OBJETO DENTRO O OPTIONAL VINDO DO BANCO E SETAR COM O VALOR DE ENTRADA DO PARAMETRO DA METODO
            Dentista dentistaBD = optional.get();
            dentistaBD.setUsuario(novoDentista.getUsuario());
            dentistaBD.setCro(novoDentista.getCro());
            return dentistaRepository.save(dentistaBD).toDTO();
        }

        else {
            return new Dentista().toDTO();
        }
    }



    public void delete(int id) {
        dentistaRepository.deleteById(id);
    }
}
