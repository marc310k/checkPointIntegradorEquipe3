package com.dh.cleanodonto.cleanodonto.model;

import com.dh.cleanodonto.cleanodonto.dto.LoginDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Data //CRIA OS GETTER E SETTER
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Login implements UserDetails {

    @Id // ISSO MONSTRA PARA JPA QUE É UM ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//GERA ID AUTOMATICAMENTE
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Column(unique = true, nullable = false, length = 50)
    private String username;

    @Column(unique = true, nullable = false, length = 90)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Perfil> perfis;




    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public LoginDTO toDTO() {
        ModelMapper mapper = new ModelMapper();

        LoginDTO dto = mapper.map(this, LoginDTO.class);

        return dto;


    }
}
