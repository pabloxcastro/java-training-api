package br.com.training.dto;

import br.com.training.model.User;

import java.time.LocalDate;

public class UserResponse {
    private String name;

    private String email;

    private String cpf;

    private LocalDate birthDate;

    public UserResponse(String name, String email, String cpf, LocalDate birthDate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }

    public static UserResponse toDto(User user){
        return new UserResponse(user.getName(), user.getEmail(), user.getCpf(), user.getBirthDate());
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
