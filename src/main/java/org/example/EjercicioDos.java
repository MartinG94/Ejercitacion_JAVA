package org.example;

import java.util.Random;

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
        System.out.println("Entraste a la funcionalidad 2...");
    }

    public int[] rellenarArrayAleatorio(int tam) {
        this.setArrayDeNumeros(new int[tam]);
        Random rnd = new Random();
        int n;
        for(int i=0; i < this.getArrayDeNumeros().length; i++) {
            this.getArrayDeNumeros()[i] = rnd.nextInt();
        }
        return this.getArrayDeNumeros();
    }

    public boolean comprobarSiContiene(int[] numeros, int indice, int valor) {
        for (int i = 0; i < indice; i++) {
            if( numeros[i] == valor ) {
                return true;
            }
        }
        return false;
    }
}
