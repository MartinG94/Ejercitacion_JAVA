package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class EjercicioDos {

    private final String enunciado = """
            Desarrollar un programa con menú de opciones que implemente lo siguiente:
            Generar en un arreglo n elementos numéricos aleatorios (pueden existir duplicados) y  ordenarlo en forma ascendente
            Mostrar el arreglo
            Buscar un elemento x dentro del arreglo (x se ingresa por teclado). Si no existe, informarlo. Si existe, cambiar su signo.""";

    private int[] arrayDeNumeros;

    public String getEnunciado() {
        return enunciado;
    }

    public int[] getArrayDeNumeros() {
        return arrayDeNumeros;
    }

    public void setArrayDeNumeros(int[] arrayDeNumeros) {
        this.arrayDeNumeros = arrayDeNumeros;
    }

    public void mostrarEnunciado() {
        System.out.println(this.getEnunciado());
    }
    public void funcionalidad() {
        Scanner teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while(!salir) {
            System.out.println("1. Generar Array con numeros aleatorios.");
            System.out.println("2. Mostrar Array.");
            System.out.println("3. Buscar un valor en el array y cambiar su signo.");
            System.out.println("0. Salir.");
            try {
                opcion = teclado.nextInt();
                switch (opcion) {
                    case 1 -> {
                        int tam, desde, hasta;
                        System.out.println("Ingrese un tamaño para el Array: ");
                        tam = teclado.nextInt();
                        System.out.println("Desde: ");
                        desde = teclado.nextInt();
                        System.out.println("Hasta ");
                        hasta = teclado.nextInt();
                        this.generarArrayAleatorio(tam, desde, hasta);
                        System.out.println("El array se generó exitosamente.");
                    }
                    case 2 -> this.mostrarNumeros();
                    case 3 -> {
                        System.out.println("Ingrese el valor que desea buscar.");
                        int valor;
                        valor = teclado.nextInt();
                        this.cambiarSignoSiExiste(valor);
                    }
                    case 0 -> salir = true;
                    default -> System.out.println("Elige una opcion valida");
                }
            } catch (InputMismatchException e){
                System.out.println("Debes insertar un numero");
                teclado.next();
            }
        }
    }

    public void ordenarAscendente(int[] array) {
        Arrays.sort(array);
    }
    public void generarArrayAleatorio(int tam, int desde, int hasta) {
        this.setArrayDeNumeros(new int[tam]);
        Random rnd = new Random();
        for(int i=0; i < this.getArrayDeNumeros().length; i++) {
            this.getArrayDeNumeros()[i] = rnd.nextInt(hasta - desde + 1) + desde;
        }
        this.ordenarAscendente(this.getArrayDeNumeros());
    }

    public void mostrarNumeros() {
        System.out.println(Arrays.toString(this.getArrayDeNumeros()));
    }

    public void cambiarSignoSiExiste(int valor) {
        for (int i = 0; i <= this.getArrayDeNumeros().length; i++) {
            if (this.getArrayDeNumeros()[i] == valor) {
                this.getArrayDeNumeros()[i] *= -1;
                while ( ((i+1) <= this.getArrayDeNumeros().length) && (valor == this.getArrayDeNumeros()[i+1])) {
                    this.getArrayDeNumeros()[i+1] *= -1;
                }
                System.out.println("El valor "+valor+" existe y se cambio su signo");
                return;
            }
        }
        System.out.println("El numero "+valor+" no existe en el array");
    }
}
