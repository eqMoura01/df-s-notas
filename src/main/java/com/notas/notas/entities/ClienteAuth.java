package com.notas.notas.entities;

import java.security.NoSuchAlgorithmException;

import com.notas.notas.util.Hashing;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClienteAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    public void setPassword(String password) throws NoSuchAlgorithmException{
        this.password = Hashing.hashData(password);
    }
}
