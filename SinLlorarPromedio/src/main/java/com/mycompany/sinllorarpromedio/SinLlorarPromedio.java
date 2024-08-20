/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sinllorarpromedio;

import java.util.Vector;


/**
 * 
 * @author USUARIO
 * 
 * Funcionamiento del proyecto:
 * 
 * 1. Mostrar nombre de la calculadora
 * 2. Preguntar al usuario cantidad de materias
 * 3. Preguntar al usuario la primer materia
 * 4. Preguntar al usuario primer nota 
 * 5. Preguntar al usuario el promedio de la primer nota
 * 6. Repetir el proceso para n materias, notas y promedios
 * 7. Mostrar resultados de calificacion en pantalla
 * 
 */
public class SinLlorarPromedio {

    // Funcion principal
    public static void main(String[] args) {

        // Inicio del programa
        System.out.println(" ------------------------------------------ ");
        System.out.println(" Sin llorar promedio (Calculadora de notas) ");
        System.out.println(" ------------------------------------------ ");
        System.out.println(" Empecemos con el proceso !!!! ");
        
        // Llamar metodos de la clase "Metodos"
        Vector<String> nombresMaterias = Metodos.nombresMaterias();
        
        Vector<Float> notasFinales = Metodos.calcularNotaPorMateria(nombresMaterias);
        
        // Mostrar resultados de la calculadora
        Metodos.imprimirNotas(nombresMaterias, notasFinales);
        
    }
}
