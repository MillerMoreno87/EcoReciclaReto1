package com.example.ecorecicla.Modelos;

public class User {
    private final String ID;
    private String nombreCom,correo,password;

    public User(String id, String name, String email, String password) {
        this.ID = id;
        this.nombreCom = name;
        this.correo = email;
        this.password = password;
    }

    public String getId() {
        return ID;
    }

    public String getName() {
        return nombreCom;
    }

    public void setName(String name) {
        this.nombreCom = name;
    }

    public String getEmail() {
        return correo;
    }

    public void setEmail(String email) {
        this.correo = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
