package org.example;

import org.example.ejercicio2.EjercicioDos;
import org.example.ejercicio1.EjercicioUno;
import org.example.ejercicio3.EjercicioTres;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {

    public void ejecutar() {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardamos la opción que elige el usuario

        while(!salir) {
            System.out.println("--- MENU DE OPCIONES ---");
            System.out.println("1. Bienvenido");
            System.out.println("2. Ordenar y Buscar");
            System.out.println("3. Sala de Reuniones");
            System.out.println("0. Salir");
            try{
                System.out.println("Escribe una de las opciones");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> {
                        EjercicioUno ej1 = new EjercicioUno();
                        ej1.mostrarEnunciado(); // Refactorizar para leer desde un archivo el enunciado
                        ej1.funcionalidad();
                    }
                    case 2 -> {
                        EjercicioDos ej2 = new EjercicioDos();
                        ej2.mostrarEnunciado();
                        ej2.funcionalidad();
                    }
                    case 3 -> {
                        EjercicioTres ej3 = new EjercicioTres();
                        ej3.mostrarEnunciado();
                        ej3.funcionalidad();
                    }
                    case 0 -> salir = true;
                    default -> System.out.println("Solo puedes elegir el 1 o el 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                teclado.next();
            }
        }
    }
}
