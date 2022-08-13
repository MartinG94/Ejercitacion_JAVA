package org.example;

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
