package org.example;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardamos la opción que elige el usuario

        while(!salir) {

            System.out.println("--- MENU DE OPCIONES ---");
            System.out.println("1. Ejercicio (1)");
            System.out.println("2. Ejercicio (2)");
            System.out.println("0. Salir");
            try{

                System.out.println("Escribe una de las opciones");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1 -> {
                        EjercicioUno ej1 = new EjercicioUno();
                        System.out.println(ej1.getEnunciado());
                        ej1.funcionalidad();
                        break;
                    }
                    case 2 -> {
                        EjercicioDos ej2 = new EjercicioDos();
                        System.out.println(ej2.getEnunciado());
                        ej2.funcionalidad();
                        break;
                    }
                    case 0 -> {
                        salir = true;
                        break;
                    }
                    default -> System.out.println("Solo puedes elegir el 1 o el 2");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un numero");
                teclado.next();
            }
        }
    }
}