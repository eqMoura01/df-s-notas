package com.notas.notas.util;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValidaEmailTests {

    @Test
    public void testaExistenciaArroba() {
        String emailValido = "victorlvmora@gmail.com";
        String emailInvalido = "victorlvmoragmail.com";
        String emailNulo = null;

        assertTrue(ValidaEmail.validaCaracterArroba(emailValido), "O e-mail deve conter o caractere '@'");
        assertFalse(ValidaEmail.validaCaracterArroba(emailInvalido), "O e-mail invalido não deve conter o caractere '@'");
        assertFalse(ValidaEmail.validaCaracterArroba(emailNulo), "O e-mail nulo não deve conter o caractere '@'");
    }
}
