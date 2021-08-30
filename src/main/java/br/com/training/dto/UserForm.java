package br.com.training.dto;

import br.com.training.model.User;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class UserForm {

    private String name;

    @Email(message = "Email é inválido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    @CPF(message = "CPF é invalido")
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    private LocalDate birthDate;

    public User toObj(){
        return new User(name, email, cpf, birthDate);
    }

    public UserForm(String name, String email, String cpf, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public UserForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
