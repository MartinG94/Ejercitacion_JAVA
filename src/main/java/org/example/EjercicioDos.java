package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
import java.util.Comparator;

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
                        if (this.getArrayDeNumeros() != null) {
                            System.out.println("Ingrese el valor que desea buscar.");
                            int valor;
                            valor = teclado.nextInt();
                            this.cambiarSignoSiExiste(valor);
                        } else {
                            System.out.println("Todavia no creaste el Array");
                        }
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

    public void ordenarDescendente(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int max = i;

            for (int j = i + 1; j < array.length; j++) {
                if(array[j] > array[max]) {
                    max = j;
                }
            }
            if (i != max) {
                int aux = array[i];
                array[i] = array[max];
                array[max] = aux;
            }
        }
    }

    public void generarArrayAleatorio(int tam, int desde, int hasta) {
        this.setArrayDeNumeros(new int[tam]);
        Random rnd = new Random();
        for(int i=0; i < this.getArrayDeNumeros().length; i++) {
            this.getArrayDeNumeros()[i] = rnd.nextInt(hasta - desde + 1) + desde;
        }
        this.ordenarAscendente();this.getArrayDeNumeros());
    }

    public void mostrarNumeros() {
        int[] numeros = this.getArrayDeNumeros();
        if (numeros != null) {
            System.out.println(Arrays.toString(numeros));
        } else {
            System.out.println("Todavía no creaste un Array.");
        }
    }

    public void cambiarSignoSiExiste(int valor) {
        int[] numeros = this.getArrayDeNumeros();
        int longitud = numeros.length;
        for (int i = 0; i < longitud; i++) {
            if (valor == numeros[i]) {
                numeros[i] *= -1;
                int siguiente = i + 1;
                while ( (siguiente < longitud) && (valor == numeros[siguiente])) {
                    numeros[siguiente] *= -1;
                    siguiente++;
                }
                System.out.println("El valor "+valor+" existe y se cambio su signo");
                this.setArrayDeNumeros(numeros);
                return;
            }
        }
        System.out.println("El numero "+valor+" no existe en el array");
    }
}
