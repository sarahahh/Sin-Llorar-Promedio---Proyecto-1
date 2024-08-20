/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sinllorarpromedio;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author USUARIO
 */
public class Metodos {
 
    // Crear objetos
    public static Scanner numMaterias = new Scanner(System.in);
    public static Scanner materia = new Scanner(System.in);
    public static Scanner teclado = new Scanner(System.in);
    
    
    
      // Metodo imprimir un mensaje en la consola
    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }
    
    // Metodo para guardar nombres de materias
    public static Vector<String> nombresMaterias(){
        
       int num;
        
       Vector<String> vector = new Vector<>();
       
       // Ciclo de validaciones para los valores ingresados por el usuario
       while(true) {
           
           imprimir(" Ingrese el numero de materias para las cuales desea saber la nota: ");
           
           try {
             
            num = Integer.parseInt(numMaterias.next());

            // Validar que sea un numero entero positivo
            if (num <= 0) {
                
                imprimir(" El numero de materias debe ser mayor que cero, intentelo de nuevo. ");
               
            }else{
                
                break;
            } 
            // Captura y manejo de excepción 
            } catch (NumberFormatException e) {
                
                imprimir(" Verifique que esta ingresando un numero entero, intentelo de nuevo: ");
            }
        }
            
        // Ciclo para asignar nombres de materias a un vector
        for (int i = 0; i < num; i++) {

            imprimir(" Ingrese el nombre de la materia " + (i + 1) + ": ");
            String nombreMateria = materia.nextLine().toUpperCase(); // Leer el nombre de la materia
            vector.add(nombreMateria); // Agregar el nombre de la materia al vector
        }   
        return vector;  
    }

    // Metodo para convertir nota (0-5)
    public static float convertirDatoANota(int i) {

        String dato;
        float nota = -1;

        // Ciclo de validaciones para los valores ingresados por el usuario
        while (true) {
            imprimir("\nIngrese la nota " + (i + 1) + "\nNumero entre 0 y 5, o una de las siguientes opciones: \nA, A-, B+, B, B-, C+, C, C-, D+, D, F \nSUPERIOR, ALTO, BASICO, BAJO, APROBADO, NO APROBADO \n(si desea ingresar un numero con decimales, por favor ingreselo con punto): ");
            dato = teclado.nextLine().toUpperCase();

            // Switch-case para validar la entrada del usuario y asignar el valor numérico correspondiente
            switch (dato) {
                case "A":
                    nota = 4.65f;
                    break;
                case "A-":
                    nota = 4.50f;
                    break;
                case "B+":
                    nota = 4.35f;
                    break;
                case "B":
                    nota = 4.15f;
                    break;
                case "B-":
                    nota = 4f;
                    break;
                case "C+":
                    nota = 3.85f;
                    break;
                case "C":
                    nota = 3.65f;
                    break;
                case "C-":
                    nota = 3.5f;
                    break;
                case "D+":
                    nota = 3.35f;
                    break;
                case "D":
                    nota = 3f;
                    break;
                case "F":
                    nota = 0f;
                    break;
                case "SUPERIOR":
                    nota = 4.6f;
                    break;
                case "ALTO":
                    nota = 4f;
                    break;
                case "BASICO":
                    nota = 3f;
                    break;
                case "BAJO":
                    nota = 0f;
                    break;
                case "APROBADO":
                    nota = 5f;
                    break;
                case "NO APROBADO":
                    nota = 0f;
                    break;
                    
                default:
                    
                    // Si la entrada no coincide, intenta convertirla en número
                    try {
                        float numero = Float.parseFloat(dato);  // Convierte la entrada en float
                        // Verifica si el número está dentro del rango permitido
                        if (numero >= 0 && numero <= 5) {
                            nota = numero;  // Si es válido, lo asigna a la variable nota
                            break;  // Sale del switch-case
                        } else {
                            // Si el número está fuera de rango, muestra un mensaje de error
                            imprimir("\n El numero de materias debe estar entre cero y cinco, intentelo de nuevo. ");
                        }
                    } catch (NumberFormatException e) {
                        // Si la entrada no es un número, muestra un mensaje de error
                        imprimir("\nVerifique que esta ingresando la nota en un formato adecuado, intentelo de nuevo. ");
                    }
            }

            if (nota != -1) {
                break;
            }
        }

        return nota;
    }

    // Metodo para calcular la nota final de una materia
    public static float calcularNotaFinal() {
        float notafinal = 0;
        int numeroNotas;
        float sumaPorcentajes = 0;

        // Ciclo de validaciones para los valores ingresados por el usuario
        while (true) {
            imprimir("\nIngrese el numero de notas de la materia: ");
            try {
                numeroNotas = Integer.parseInt(teclado.nextLine());  // Intenta convertir la entrada a un número entero
                if (numeroNotas <= 0) {
                    imprimir("\nEl numero de materias debe ser mayor que cero, intentelo de nuevo.");  // Valida que sea mayor que 0
                } else {
                    break;  // Si es válido, sale del bucle
                }
            } catch (NumberFormatException e) {
                imprimir("\nVerifique que esta ingresando un numero entero, intentelo de nuevo. ");  // Muestra un error si la conversión falla
            }
        }

        // Ciclo para preguntar las notas y porcentajes
        for (int i = 0; i < numeroNotas; i++) {
            float nota;
            float porcentaje;

            // Preguntar la nota
            nota = Metodos.convertirDatoANota(i);

            // Ciclo de validaciones para los valores ingresados por el usuario
            while (true) {
                imprimir("\nIngrese el porcentaje de la nota " + (i + 1) + ": ");
                try {
                    porcentaje = Float.parseFloat(teclado.nextLine());  // Convierte la entrada a float
                    // Verifica si el porcentaje está dentro del rango permitido (0-100)
                    if (porcentaje < 0 || porcentaje > 100) {
                        imprimir("\nEl porcentaje debe estar entre cero y cien, intentelo de nuevo. ");
                    } else if (sumaPorcentajes + porcentaje > 100) {
                        imprimir("\nEl valor de la suma de los porcentajes no puede exceder 100, intentelo de nuevo. ");
                    } else if(sumaPorcentajes + porcentaje < 100 && i + 1 == numeroNotas){
                        imprimir("\nLa suma de los porcentajes debe ser igual a 100. ");
                    } else {
                        sumaPorcentajes += porcentaje;  // Acumula el porcentaje si es válido
                        break;  // Sale del bucle
                    }
                } catch (NumberFormatException e) {
                    imprimir("\nDebe ingresar un numero, intentelo de nuevo. ");  // Muestra un error si la conversión falla
                }
            }

            // Calcular la nota final usando la variable estática notafinal
            notafinal += nota * (porcentaje / 100);
        }

        // Verificar que la suma de los porcentajes sea 100
        if (sumaPorcentajes != 100) {
            imprimir("\nLa suma de los porcentajes no es 100, intentelo de nuevo. ");
            notafinal = 0;
        }

        return notafinal;
    }

    // Método para calcular la nota final de cada materia y almacenarla en un vector
    public static Vector<Float> calcularNotaPorMateria(Vector<String> nombresMaterias) {
        Vector<Float> notasFinales = new Vector<>();

        // Ciclo para calcular la nota final para cada materia
        for (String materiaNombre : nombresMaterias) {
            imprimir("\nVamos a ingresar las notas para la materia " + materiaNombre);
            float nota = calcularNotaFinal();
            notasFinales.add(nota); // Agrega la nota final al vector de notas finales
        }

        return notasFinales;
    }
    
    // Metodo imprimir resultados de notas
    public static void imprimirNotas(Vector<String> nombresMaterias, Vector<Float> notasFinales) {
        
        int opcion = 0;

        // Ciclo de validaciones para los valores ingresados por el usuario
        while (true) {
            try {
                imprimir("\nSelecciona el formato en el que deseas ver las notas: ");
                imprimir("1. Numericas");
                imprimir("2. Letras");
                imprimir("3. Palabras");

                opcion = Integer.parseInt(teclado.nextLine()); 
                
                // Verifica si la opción ingresada es válida (1, 2 o 3)
                if (opcion < 1 || opcion > 3) {
                    imprimir("Opcion no valida. Por favor, seleccione una opcion entre 1 y 3.");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                imprimir("Entrada no valida, intentelo de nuevo. .");
            }
        }

        // Proceso de impresión de notas según la opción seleccionada por el usuario
        switch (opcion) {
            case 1:
                // Imprimir las notas en formato numérico
                for (int i = 0; i < nombresMaterias.size(); i++) {
                    String status = notasFinales.get(i) >= 3 ? "APROBADO" : "NO APROBADO";
                    imprimir(nombresMaterias.get(i) + " : " + notasFinales.get(i) + " : " + status);
                }
                break;

            case 2:
                // Imprimir las notas en formato de letras
                for (int i = 0; i < notasFinales.size(); i++) {
                    float nota = notasFinales.get(i);
                    String letra;

                    // Asigna la letra correspondiente según el rango de la nota
                    if (nota <= 2.9) {
                        letra = "F";
                    } else if (nota <= 3.3) {
                        letra = "D";
                    } else if (nota <= 3.49) {
                        letra = "D+";
                    } else if (nota <= 3.6) {
                        letra = "C-";
                    } else if (nota <= 3.8) {
                        letra = "C";
                    } else if (nota <= 3.99) {
                        letra = "C+";
                    } else if (nota <= 4.1) {
                        letra = "B-";
                    } else if (nota <= 4.3) {
                        letra = "B";
                    } else if (nota <= 4.49) {
                        letra = "B+";
                    } else if (nota <= 4.6) {
                        letra = "A-";
                    } else {
                        letra = "A";
                    }

                    String status = nota >= 3 ? "APROBADO" : "NO APROBADO";
                    imprimir(nombresMaterias.get(i) + " : " + letra + " : " + status);
                }
                break;

            case 3:
                // Imprimir las notas en formato de palabras
                for (int i = 0; i < notasFinales.size(); i++) {
                    float nota = notasFinales.get(i);
                    String palabra;

                    // Asigna la palabra correspondiente según el rango de la nota
                    if (nota <= 2.9) {
                        palabra = "BAJO";
                    } else if (nota <= 3.9) {
                        palabra = "BASICO";
                    } else if (nota <= 4.5) {
                        palabra = "ALTO";
                    } else {
                        palabra = "SUPERIOR";
                    }

                    String status = nota >= 3 ? "APROBADO" : "NO APROBADO";
                    imprimir(nombresMaterias.get(i) + " : " + palabra + " : " + status);
                }
                break;

            default:
                imprimir("Opcion no valida.");
                break;
        }
    }
}