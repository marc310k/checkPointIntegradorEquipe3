package com.dh.cleanodonto.cleanodonto;

import com.dh.cleanodonto.cleanodonto.model.Login;
import com.dh.cleanodonto.cleanodonto.model.Usuario;

import com.dh.cleanodonto.cleanodonto.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class CreatUserRun implements ApplicationRunner {

    @Autowired
    com.dh.cleanodonto.cleanodonto.repository.UsuarioRepository UsuarioRepository;
    @Autowired
    LoginRepository respository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        Usuario usuario = new Usuario(null,"Vitoria", "Vitoriosa","2121211111111","dentista");

        Login login = new Login();
        login.setPassword(encoder.encode("654321"));
        login.setUsername("Admin");
        login.setUsuario(usuario);
        respository.save(login);
    }
}


