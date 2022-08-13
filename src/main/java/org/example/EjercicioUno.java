package org.example;
import java.util.Scanner;

public class EjercicioUno {

    private final String enunciado = "Crear un programa para que permita ingresar el nombre del alumno, y responda con el mensaje: \"Bienvenido [alumno] a TSB\"";

    public String getEnunciado() {
        return enunciado;
    }

    public void mostrarEnunciado() {
        System.out.println(this.getEnunciado());
    }
    public void funcionalidad() {
        Scanner teclado = new Scanner(System.in);
        String alumno;
        System.out.println("Ingrese el nombre del alumno para saludarlo!");
        alumno = teclado.next();
        this.saludar(alumno);
    }
    public void saludar(String nombre) {
        System.out.println("Bienvenido "+nombre+" a TSB!");
    }
}
