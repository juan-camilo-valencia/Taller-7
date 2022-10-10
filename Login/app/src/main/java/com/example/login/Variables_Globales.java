package com.example.login;

public class Variables_Globales {
    private static Variables_Globales instance;

    private static int _codigousuario = 0;
    private static String _nombre = "";
    private static String _direccion = "";
    private static String _telefono = "";
    private static String _email = "";

    public int get_codigousuario() {
        return _codigousuario;
    }

    public void set_codigousuario(int _codigousuario) {
        Variables_Globales._codigousuario = _codigousuario;
    }

    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        Variables_Globales._nombre = _nombre;
    }

    public String get_direccion() {
        return _direccion;
    }

    public void set_direccion(String _direccion) {
        Variables_Globales._direccion = _direccion;
    }

    public String get_telefono() {
        return _telefono;
    }

    public void set_telefono(String _telefono) {
        Variables_Globales._telefono = _telefono;
    }

    public String get_email() {
        return _email;
    }

    public void set_email(String _email) {
        Variables_Globales._email = _email;
    }


    public static synchronized Variables_Globales getInstance() {
        if (instance == null) {
            instance = new Variables_Globales();
        }
        return instance;
    }
}

