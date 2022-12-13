package com.dh.cleanodonto.cleanodonto.service;


import com.dh.cleanodonto.cleanodonto.dto.DentistaDTO;
import com.dh.cleanodonto.cleanodonto.model.*;
import com.dh.cleanodonto.cleanodonto.repository.DentistaRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
class DentistaServiceTest {

    @InjectMocks //ELE MONTA A CLASSE DA SERVICE COM TODOS OS MOCKS ABAIXO
    private DentistaService dentistaService;

    @Mock
    private DentistaRepository dentistaRepository;






  @Test
  void getAll(){

      //VAMOS CRIAR UMA LISTA DE ENTIDADE  COM O OBJETO
      //DE RETORNAR A MEMA QUANDO O ENDERECOREPOSITORY.FINDALL() FOR ACIONADO

          List<Dentista> listaMockada = new ArrayList<Dentista>();

             Dentista dentistas = createValidDentista();

          listaMockada.add(dentistas);
          //QUANDO O REPOSITORY FOR ACIONADO, RETORNO A LISTA MOCKADA
          when( dentistaRepository.findAll() ).thenReturn( listaMockada );

          List<DentistaDTO> retorno = dentistaService.getAll();

             Assertions.assertEquals (retorno.getClass(), listaMockada.getClass());

      }



    @Test
    void getOne() {

      //DADOS PARA FACILITAR A COMPARAÇÃO ( SENDO ESSA A EXPECTATIVA)
        String cro = "REFS-1114544";
        Usuario usuario1 = new Usuario(2, "Carlos","Souza","2124455411","Dentista");
        Dentista  dentista = new Dentista (usuario1, "REFS-1114544") ; //DENTISTAENTITY

        Dentista dentista1  = createValidDentista();

        Optional<Dentista> optional = Optional.of(dentista1);

        when ( dentistaRepository.findById(1) ).thenReturn( optional );

        // EXECUÇÃO
        DentistaDTO dentistaDTO = dentistaService.getOne(1);

        //COMPARAÇÃO DE UMA PROPRIEDADE POR VEZ
        // EXPECTATIVA : VALOR ESPERADO vs VALOR QUE REALMENTE FOI SALVO
        Assertions.assertEquals(cro,dentistaDTO.getCro());
        Assertions.assertEquals(usuario1.getNome(),dentistaDTO.getUsuario().getNome());
        Assertions.assertEquals(usuario1.getCpf(),dentistaDTO.getUsuario().getCpf());


    }




    @Test
    void save() {



       String cro = "REFS-1114544";
        Usuario usuario1 = new Usuario(2, "Carlos","Souza","2124455411","Dentista");
        Dentista dentista = createValidDentista();

        // QUANDO A REPOSITORY FOR CHAMADA (WHEN) COM AS CHAMADAS CONFORME O METODO,
        // O MESMO DEVE REALIZAR A AÇÃO E RETORNOAR UM OBJETO

        when( dentistaRepository.save(any()) ).thenReturn(dentista);
         DentistaDTO dentistaDTO = dentistaService.save(dentista);

        //COMPARAÇÃO DE UMA PROPRIEDADE POR VEZ
        // EXPECTATIVA : VALOR ESPERADO vs VALOR QUE REALMENTE FOI SALVO
        Assertions.assertEquals(cro,dentistaDTO.getCro());
        Assertions.assertEquals(usuario1.getNome(),dentistaDTO.getUsuario().getNome());


    }




    @Test
    void update() {


        when( dentistaRepository.findById(1 ) ).thenReturn(Optional.of(createValidDentista()));
        when( dentistaRepository.save(any()) ).thenReturn(createValidDentista2());


        DentistaDTO dentistaDTO = dentistaService.update(1,createValidDentista2());

        //primeiro é o esperado, segundo o que recebeu da service
        Assertions.assertEquals("PDD-512124",dentistaDTO.getCro() );
        Assertions.assertEquals("Bianca",dentistaDTO.getUsuario().getNome());



    }

    @Test
    void delete() {

        // EXECUÇÃO
        // assertDoesNotThrow ESPERA UMA LAMBDA  (METODO SEM NOME) E VERIFICAR SE A LAMBIDA EXECUTA SEM ERRO
        Assertions.assertDoesNotThrow( () -> dentistaService.delete(1) );

        // VERIFICA SE O professorRepository.deleteById FOI EXECUTADO SOMENTE UMA VEZ
        verify( dentistaRepository, times(1) ).deleteById(1);
    }




    //========================================METODOS ADICIONAIS==========================================


    //METODO PARA POPULAR DADOS

    private Dentista createValidDentista() {


        Usuario usuario1 = new Usuario(2, "Carlos","Souza","2124455411","Dentista");
        Dentista  dentista = new Dentista (usuario1, "REFS-1114544") ; //DENTISTAENTITY
        return dentista;


    }


    //METODO DE NOVOS DADOS PARA O UPDATE
    private Dentista createValidDentista2() {



        Usuario usuario1 = new Usuario(1, "Bianca","Moreira","95421142","Dentista");
        Dentista  dentista = new Dentista(usuario1,"PDD-512124") ; //DENTISTAENTITY

        return dentista;



    }


}
