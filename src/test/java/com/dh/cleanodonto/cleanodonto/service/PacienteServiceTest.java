package com.dh.cleanodonto.cleanodonto.service;

import com.dh.cleanodonto.cleanodonto.dto.PacienteDTO;
import com.dh.cleanodonto.cleanodonto.model.Endereco;
import com.dh.cleanodonto.cleanodonto.model.Paciente;
import com.dh.cleanodonto.cleanodonto.model.Usuario;
import com.dh.cleanodonto.cleanodonto.repository.PacienteRepository;
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
class PacienteServiceTest {

    @InjectMocks //ELE MONTA A CLASSE DA SERVICE COM TODOS OS MOCKS ABAIXO
    private PacienteService pacienteService;

    @Mock
    private PacienteRepository pacienteRepository;




    @Test
    void getAll(){

        //VAMOS CRIAR UMA LISTA DE ENTIDADE  COM O OBJETO
        //DE RETORNAR A MEMA QUANDO O ENDERECOREPOSITORY.FINDALL() FOR ACIONADO

        List<Paciente> listaMockada = new ArrayList<>();

        Paciente paciente = createValidPaciente();

        listaMockada.add(paciente);
        //QUANDO O REPOSITORY FOR ACIONADO, RETORNO A LISTA MOCKADA
        when( pacienteRepository.findAll() ).thenReturn( listaMockada );

        List<PacienteDTO> retorno = pacienteService.getAll();
        ;
        Assertions.assertEquals (retorno.getClass(), listaMockada.getClass());

    }



    @Test
    void getOne() {

        //DADOS PARA FACILITAR A COMPARAÇÃO ( SENDO ESSA A EXPECTATIVA)
        String cro = "REFS-1114544";
        Usuario usuario1 = new Usuario(2, "Carlos","Souza","2124455411","Paciente");
        Endereco endereco = new Endereco(1,"Avenida Nova", "2121", "Parada Inglesa","São Paulo", "SP","0212124");

        Paciente paciente = createValidPaciente();

        Optional<Paciente> optional = Optional.of(paciente);

        when ( pacienteRepository.findById(1) ).thenReturn( optional );

        // EXECUÇÃO
        PacienteDTO pacienteDTO = pacienteService.getOne(1);

        //COMPARAÇÃO DE UMA PROPRIEDADE POR VEZ
        // EXPECTATIVA : VALOR ESPERADO vs VALOR QUE REALMENTE FOI SALVO
        Assertions.assertEquals("Carlos",pacienteDTO.getUsuario().getNome());
        Assertions.assertEquals("Souza",pacienteDTO.getUsuario().getSobrenome() );
        Assertions.assertEquals("r5142142",pacienteDTO.getRg());
        Assertions.assertEquals(endereco.getCidade(),pacienteDTO.getEndereco().getCidade());


    }




    @Test
    void save() {



        String cro = "REFS-1114544";
        Usuario usuario1 = new Usuario(1, "Carlos","Souza","2124455411","Paciente");
        Endereco endereco = new Endereco(1,"Avenida Nova", "2121", "Parada Inglesa","São Paulo", "SP","0212124");
        Paciente paciente = createValidPaciente();

        // QUANDO A REPOSITORY FOR CHAMADA (WHEN) COM AS CHAMADAS CONFORME O METODO,
        // O MESMO DEVE REALIZAR A AÇÃO E RETORNOAR UM OBJETO

        when( pacienteRepository.save(any()) ).thenReturn(paciente);
        PacienteDTO pacienteDTO = pacienteService.save(paciente);

        //COMPARAÇÃO DE UMA PROPRIEDADE POR VEZ
        // EXPECTATIVA : VALOR ESPERADO vs VALOR QUE REALMENTE FOI SALVO
        Assertions.assertEquals("Carlos",pacienteDTO.getUsuario().getNome());
        Assertions.assertEquals("Souza",pacienteDTO.getUsuario().getSobrenome() );
        Assertions.assertEquals("r5142142",pacienteDTO.getRg());
        Assertions.assertEquals(endereco.getCidade(),pacienteDTO.getEndereco().getCidade());


    }







    @Test
    void update() {


        when( pacienteRepository.findById(1 ) ).thenReturn(Optional.of(createValidPaciente()));
        when( pacienteRepository.save(any()) ).thenReturn(createValidPaciente2());


        PacienteDTO pacienteDTO = pacienteService.update(1,createValidPaciente2());

        //primeiro é o esperado, segundo o que recebeu da service
        Assertions.assertEquals("Pereira",pacienteDTO.getUsuario().getSobrenome() );
        Assertions.assertEquals("514214214",pacienteDTO.getRg());



    }

    @Test
    void delete() {

        // EXECUÇÃO
        // assertDoesNotThrow ESPERA UMA LAMBDA  (METODO SEM NOME) E VERIFICAR SE A LAMBIDA EXECUTA SEM ERRO
        Assertions.assertDoesNotThrow( () -> pacienteService.delete(1) );

        // VERIFICA SE O professorRepository.deleteById FOI EXECUTADO SOMENTE UMA VEZ
        verify( pacienteRepository, times(1) ).deleteById(1);
    }




    //========================================METODOS ADICIONAIS==========================================


    //METODO PARA POPULAR DADOS

    private Paciente createValidPaciente() {


        Usuario usuario1 = new Usuario(1, "Carlos","Souza","2124455411","Paciente");
        Endereco endereco = new Endereco(1,"Avenida Nova", "2121", "Parada Inglesa","São Paulo", "SP","0212124");
        Paciente paciente = new Paciente (1,usuario1, "r5142142",endereco) ; //DENTISTAENTITY
        return paciente;


    }


    //METODO DE NOVOS DADOS PARA O UPDATE
    private Paciente createValidPaciente2() {

            Usuario usuario1 = new Usuario(1, "Carlos","Pereira","2124455411","Paciente");
            Endereco endereco = new Endereco(1,"Avenida Nova", "2121", "Parada Inglesa","São Paulo", "SP","0212124");
            Paciente paciente = new Paciente (1,usuario1, "514214214",endereco) ; //DENTISTAENTITY
            return paciente;


        }


}
