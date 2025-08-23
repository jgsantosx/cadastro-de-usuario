package com.backend.demo.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Indexed;

import jakarta.persistence.*;
import jakarta.validation.constraints

@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Nome é Obrigatório")
    private String nome;


    @Email(message = "Email é obrigatório")
    private String email;


    @NotBlank (message = "CPF é obrigatório")
    @Size(min = 11, max = 11, message = "CPF deve ter 11 dígitos")
    @Column(unique = true)
    private String cpf;

    // Getters e Setters

    public Long getId(){ return id; }
    public void setId(Long id) { this.id = id; }


    public String getNome(){ return nome; }
    public void setNome(String nome) { this.nome = nome; }


    public String getEmail() { return email; }
    public void setEmail(String email) {this.email = email;}


    public String getCpf() { return cpf; }
    public void setCpf() { this.cpf = cpf; }

    
}
