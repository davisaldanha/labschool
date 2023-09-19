
package com.example.labschool.Dtos;

import com.example.labschool.models.PedagogoModel;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Date;

public record PedagogoDto(
        @NotEmpty(message = "O campo Nome é obrigatório.") 
        String nome,
        
        @NotBlank(message = "O campo Telefone é obrigatório.") 
        @Size(min=16, max=16) 
        String telefone,
        
        @NotNull(message = "O campo Data de nascimento é obrigatorio.")
        @Temporal(TemporalType.DATE) 
        Date dataNascimento,
        
        @NotBlank(message = "O campo é CPF obrigatorio") 
        @Size(min=14, max=14) 
        String cpf,        
  
        @NotBlank(message = "O campo E-mail é obrigatorio") 
        @Email 
        String email,
        
        @NotBlank(message = "O campo Senha deve ter pelo menos 8 caracteres.") 
        @Size(min=8) 
        String senha       
        ) {
    
    public PedagogoDto(PedagogoModel pedagogo){
        this(pedagogo.getNome(), pedagogo.getTelefone(), pedagogo.getDataNascimento(), pedagogo.getCpf(), pedagogo.getEmail(), pedagogo.getSenha());
    }
}
