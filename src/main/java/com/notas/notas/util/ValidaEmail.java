package com.notas.notas.util;

public class ValidaEmail {

    public static boolean validaEmail(String email) {
        return email.matches("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
    }

    public static boolean validaCaracterArroba(String input) {
        return input != null && input.contains("@");
    }
}
