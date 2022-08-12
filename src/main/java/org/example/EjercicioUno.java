package org.example;
import java.util.Scanner;

public class EjercicioUno {
    public void saludar(){
        String nombre;
        Scanner teclado = new Scanner(System.in);
        nombre = teclado.next();
        System.out.println("Bienvenido "+nombre+" a TSB!");
    }
}
