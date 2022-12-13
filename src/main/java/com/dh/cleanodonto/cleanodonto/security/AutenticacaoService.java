package com.dh.cleanodonto.cleanodonto.security;

import com.dh.cleanodonto.cleanodonto.model.Login;
import com.dh.cleanodonto.cleanodonto.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
//autenticação do usuario
@Service
public class AutenticacaoService implements UserDetailsService {
    @Autowired
    LoginRepository respository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Login> login = respository.findByUsername(username);
        if (login.isEmpty()){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return login.get();
    }
}
