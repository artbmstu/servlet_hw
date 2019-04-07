package ru.artbmstu.util;

public class AuthHelper {
    public static boolean isAllowed(String username, String password) {
        return username.contentEquals("admin") && password.contentEquals("password");
    }
}