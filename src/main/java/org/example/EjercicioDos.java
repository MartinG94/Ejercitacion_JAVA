package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class EjercicioDos {

    private String enunciado = "Desarrollar un programa con menú de opciones que implemente lo siguiente:\n"+
            "Generar en un arreglo n elementos numéricos aleatorios (pueden existir duplicados) y  ordenarlo en forma ascendente\n"+
            "Mostrar el arreglo\n"+
            "Buscar un elemento x dentro del arreglo (x se ingresa por teclado). Si no existe, informarlo. Si existe, cambiar su signo.";

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
                        System.out.println("Ingrese un tamaño para el Array: ");
                        int tam;
                        tam = teclado.nextInt();
                        this.rellenarArrayAleatorio(tam);
                        System.out.println("El array se generó exitosamente.");
                        break;
                    }
                    case 2 -> {
                        this.mostrarNumeros();
                        break;
                    }
                    case 3 -> {
                        System.out.println("Ingrese el valor que desea buscar.");
                        int valor;
                        valor = teclado.nextInt();
                        this.comprobarSiContiene(valor);
                        break;
                    }
                    case 0 -> {
                        salir = true;
                        break;
                    }
                    default -> {
                        System.out.println("Elige una opcion valida");
                    }
                }
            } catch (InputMismatchException e){
                System.out.println("Debes insertar un numero");
                teclado.next();
            }
        }
    }

    public void rellenarArrayAleatorio(int tam) {
        this.setArrayDeNumeros(new int[tam]);
        Random rnd = new Random();
        int n;
        for(int i=0; i < this.getArrayDeNumeros().length; i++) {
            this.getArrayDeNumeros()[i] = rnd.nextInt(20 - 1 + 1) + 1;
        }
        Arrays.sort(this.getArrayDeNumeros());
    }

    public void mostrarNumeros() {
        System.out.println(Arrays.toString(this.getArrayDeNumeros()));
    }

    public void comprobarSiContiene(int valor) {
        for (int i = 0; i < this.getArrayDeNumeros().length; i++) {
            if( this.getArrayDeNumeros()[i] == valor ) {
                int aux = this.getArrayDeNumeros()[i];
                aux *= -1;
                this.getArrayDeNumeros()[i] = aux;
                System.out.println("El valor "+valor+" existe y se cambio su signo");;
                return;
            }
        }
        System.out.println("El numero "+valor+" no existe en el array");;
    }
}
