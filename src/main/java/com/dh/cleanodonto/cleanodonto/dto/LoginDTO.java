package com.dh.cleanodonto.cleanodonto.dto;


import com.dh.cleanodonto.cleanodonto.model.Login;
import com.dh.cleanodonto.cleanodonto.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data //CRIA OS GETTER E SETTER
@AllArgsConstructor
@NoArgsConstructor

public class LoginDTO {
    private Integer id;

    //@NotBlank
    @NotNull(message = "É obrigatório informar o Usuario")
    @Size(min=2)
    private String username;

   // @NotBlank
    @NotNull(message = "É obrigatório informar o login")
    @Size(min = 2)
    private String password;



    public UsernamePasswordAuthenticationToken convert(){
        return new UsernamePasswordAuthenticationToken(this.username,this.password);
    }

    public Login toEntity() {

        ModelMapper mapper = new ModelMapper();

        return mapper.map(this, Login.class);
    }

}
