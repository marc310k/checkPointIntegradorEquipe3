package com.dh.cleanodonto.cleanodonto.service;

import com.dh.cleanodonto.cleanodonto.dto.*;
import com.dh.cleanodonto.cleanodonto.model.*;
import com.dh.cleanodonto.cleanodonto.repository.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.*;


@SpringBootTest
class ConsultaServiceTest {




    @InjectMocks //ELE MONTA A CLASSE DA SERVICE COM TODOS OS MOCKS ABAIXO
    private ConsultaService consultaService ;
    @Mock //SERVE PARA SINALIZAR QUE IREMOS MOCKAR(SIMULAR) A CAMADA REPOSITORY
    private ConsultaRepository consultaRepository;
    @Mock
    private DentistaRepository dentistaRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PacienteRepository pacienteRepository;

    @Mock
    private EnderecoRepository enderecoRepository;






    @Test
    void getAll(){

        //VAMOS CRIAR UMA LISTA DE ENTIDADE  COM O OBJETO
        //DE RETORNAR A MEMA QUANDO O ENDERECOREPOSITORY.FINDALL() FOR ACIONADO

        List<Consulta> listaMockada = new ArrayList<>();

        Consulta consulta = createValidConsulta();

        listaMockada.add(consulta);
        //QUANDO O REPOSITORY FOR ACIONADO, RETORNO A LISTA MOCKADA
        when( consultaRepository.findAll() ).thenReturn( listaMockada );

        List<ConsultaDTO> retorno = consultaService.getAll();

        Assertions.assertEquals (retorno.getClass(), listaMockada.getClass());


    }

    @Test
    void getOne() {

        //DADOS PARA FACILITAR A COMPARAÇÃO ( SENDO ESSA A EXPECTATIVA)
        String cro = "REFS-1114544";
        LocalDateTime dataConsulta = LocalDateTime.of(2023,01,01,12,23,003);
        Dentista dentista1 = new Dentista(new Usuario(2, "Carlos","Souza","2124455411","Paciente") ,"2121455");
        Paciente paciente = new Paciente(1, new Usuario(1,"pedro","carvalho","02132215","Dentista"),"21545245",new Endereco(1,"Avendida","141","tucuruvi","São Paulo","SP","02121212"));


        Consulta consulta = createValidConsulta();

        Optional<Consulta> optional = Optional.of(consulta);

        when ( consultaRepository.findById(1) ).thenReturn( optional );

        // EXECUÇÃO
        ConsultaDTO consultaDTO = consultaService.getOne(1);

        ///COMPARAÇÃO DE UMA PROPRIEDADE POR VEZ
        // EXPECTATIVA : VALOR ESPERADO vs VALOR QUE REALMENTE FOI SALVO
        Assertions.assertEquals(dataConsulta,consultaDTO.getDataConsulta());
        Assertions.assertEquals(paciente.getUsuario().getNome(),consultaDTO.getPaciente().getUsuario().getNome());
        Assertions.assertEquals("Carlos",consultaDTO.getDentista().getUsuario().getNome());


    }



    @Test
    void save() {



        //DADOS PARA FACILITAR A COMPARAÇÃO ( SENDO ESSA A EXPECTATIVA)
        Integer idDentista = 1;
        Integer idPaciente = 1;
        LocalDateTime dataConsulta = LocalDateTime.of(2023,01,01,12,23,003);

        Dentista dentista1 = new Dentista(new Usuario(2, "Carlos","Souza","2124455411","Paciente") ,"2121455");
        Paciente paciente = new Paciente(1, new Usuario(1,"pedro","carvalho","02132215","Dentista"),"21545245",new Endereco(1,"Avendida","141","tucuruvi","São Paulo","SP","02121212"));

         Consulta consulta = createValidConsulta();

         //FERRAMENTA DO MOCKIT PARA CAPTURAR O QUE SERÁ PASSADO PARA ARQUIMENTOS
       // ArgumentCaptor<Consulta> consultaArgumentCaptor = ArgumentCaptor.forClass(Consulta.class);


        // QUANDO A REPOSITORY FOR CHAMADA (WHEN) COM AS CHAMADAS CONFORME O METODO,
        // O MESMO DEVE REALIZAR A AÇÃO E RETORNOAR O NECESSÁRIO CONFORME A NECESSIDADE
        when( consultaRepository.save(any()) ).thenReturn(consulta);
        when( dentistaRepository.getReferenceById(idDentista) ).thenReturn(dentista1);
        when( pacienteRepository.getReferenceById(idPaciente) ).thenReturn(paciente);

        ConfirmaConsultaDTO consultaSalva = consultaService.save(dataConsulta, 1, 1);

        ///COMPARAÇÃO DE UMA PROPRIEDADE POR VEZ
        // EXPECTATIVA : VALOR ESPERADO vs VALOR QUE REALMENTE FOI SALVO
        Assertions.assertEquals(dataConsulta,consultaSalva.getDataConsulta());
        Assertions.assertEquals(paciente.getUsuario().getNome(),consultaSalva.getNomePaciente());





    }

    @Test
    void update() {


        when( consultaRepository.findById(1 ) ).thenReturn(Optional.of(createValidConsulta()));
        when( consultaRepository.save(any()) ).thenReturn(createValidConsulta2());

        ConsultaDTO consultaDTO = consultaService.update(1,createValidConsulta2());

        LocalDateTime novaDataConsulta = LocalDateTime.of(2022,12,01,11,23,003);

        //primeiro é o esperado, segundo o que recebeu da service
        Assertions.assertEquals(novaDataConsulta,consultaDTO.getDataConsulta());
        Assertions.assertEquals("São Pedro",consultaDTO.getPaciente().getUsuario().getNome());



    }



    @Test
    void delete() {

        // EXECUÇÃO
        // assertDoesNotThrow ESPERA UMA LAMBDA  (METODO SEM NOME) E VERIFICAR SE A LAMBIDA EXECUTA SEM ERRO
        Assertions.assertDoesNotThrow( () -> consultaService.delete(1) );

        // VERIFICA SE O professorRepository.deleteById FOI EXECUTADO SOMENTE UMA VEZ
        verify( consultaRepository, times(1) ).deleteById(1);
    }



//========================================METODOS ADICIONAIS==========================================


    //METODO PARA POPULAR DAS TABELAS NECESSÁRIAS
    private Consulta createValidConsulta() {


        Dentista dentista1 = new Dentista(new Usuario(2, "Carlos","Souza","2124455411","Paciente") ,"2121455");
        Paciente paciente = new Paciente(1, new Usuario(1,"pedro","carvalho","02132215","Dentista"),"21545245",new Endereco(1,"Avendida","141","tucuruvi","São Paulo","SP","02121212"));
        Consulta  consulta = new Consulta ( ); //CONSULTAENTITY
        LocalDateTime dataConsulta = LocalDateTime.of(2023,01,01,12,23,003);
        consulta.setDentista(dentista1);
        consulta.setPaciente(paciente);
        consulta.setDataConsulta(dataConsulta);
         return consulta;


    }


    //METODO DE NOVOS DADOS PARA O UPDATE
    private Consulta createValidConsulta2() {


        Dentista dentista1 = new Dentista(new Usuario(2, "Vitor","Souza","2124455411","Paciente") ,"2121455");
        Paciente paciente = new Paciente(1, new Usuario(1,"São Pedro","carvalho","02132215","Dentista"),"21545245",new Endereco(1,"Avendida","141","tucuruvi","São Paulo","SP","02121212"));
        Consulta  consulta = new Consulta ( ); //CONSULTAENTITY
        LocalDateTime novaDataConsulta = LocalDateTime.of(2022,12,01,11,23,003);
        consulta.setDentista(dentista1);
        consulta.setPaciente(paciente);
        consulta.setDataConsulta(novaDataConsulta);
        return consulta;


    }





  }
