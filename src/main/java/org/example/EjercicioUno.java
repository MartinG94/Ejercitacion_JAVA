package org.example;

public class EjercicioUno {

    private String enunciado = "Crear un programa para que permita ingresar el nombre del alumno, y responda con el mensaje: \"Bienvenido [alumno] a TSB\"";

    public String getEnunciado() {
        return enunciado;
    }

    public void saludar(String nombre) {
        System.out.println("Bienvenido "+nombre+" a TSB!");
    }
}
