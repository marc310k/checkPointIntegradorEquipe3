package com.dh.cleanodonto.cleanodonto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    AutenticacaoService autenticacaoService;
    //Aqui cuidamos da permissão de acesso

    @Autowired
    AutenticacaoViaTokenFilter autenticacaoViaTokenFilter;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs/**",
            "/v3/api-docs/**",
            "/swagger-resources/**",
            "/swagger-ui/**",
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.headers().frameOptions().disable();
        http.csrf().disable()
                //aqui permintido que todo mundo acesse consulta  - SE TIRAR O HTTP METHOD TIDO MUNDO PODE ACESSAR QUALQUER METODO DE CONSULTA
                .authorizeRequests()
                .antMatchers(AUTH_WHITELIST).permitAll()
                .antMatchers(HttpMethod.GET, "/consulta").permitAll()// QUALQUER PESSOA QUE ACESSAR PODE TERÁ ACESO GET CONSULTA, MAS OS OUTROS METODOS ELE DEVERAR SE AUTENTICA
                .antMatchers(HttpMethod.GET, "/paciente").permitAll()
                .antMatchers(HttpMethod.GET, "/dentista").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/auth").permitAll()
                //.anyRequest().authenticated()//BLOQUEANDO ACESSO A QUALQUER ROTA QUE NÃO TENHA SIDO MAPEADO
                .and()
                .headers().frameOptions().disable()
                .and()
                .cors()
                .and()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().addFilterBefore(autenticacaoViaTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //.and().formLogin();//abre um fomulario de ‘login’
    }

    //CUIDAMOS DA PARTE DE AUTENTICAÇÃO DE ACESSO
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(autenticacaoService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

        //libera o swagger
        web.ignoring().antMatchers(AUTH_WHITELIST);
    }

}
