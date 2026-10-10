package estructuradatos.mx.edu.uttt;

import javax.swing.JOptionPane;

public class Menu {

    // "0" Salir
    private static String leer(String texto){
        String r = JOptionPane.showInputDialog(texto);
        return r == null ? "0" : r.trim();
    }

    public static String menuPrincipal(){
        return leer(
        "==================== ESTRUCTURA DE DATOS =======================\n\n"+
        "1)Arreglos\n"+
        "2)Listas\n"+
        "3)Pilas\n"+
        "4)Colas\n"+
        "5)Arboles\n"+
        "0)Salir\n"+
        "Seleccione una opcion:");
    }

    public static String menuArreglos(){
        return leer(
        "==================== ARREGLOS =======================\n\n"+
        "1)Vectores\n"+
        "2)Matrices\n"+
        "3)Recursividad\n"+
        "0)Regresar\n"+
        "Seleccione una opcion:");
    }

    public static String menuRecursividad(){
        return leer(
        "==================== RECURSIVIDAD =======================\n\n"+
        "1)Suma de 1 a n\n"+
        "2)Factorial de un numero\n"+
        "3)Multiplicacion mediante suma\n"+
        "4)Potencia mediante multiplicacion\n"+
        "0)Regresar\n"+
        "Seleccione una opcion:");
    }

    public static String menuMatrices(){
        return leer(
        "==================== MATRICES =======================\n\n"+
        "1)Crear y llenar matriz\n"+
        "2)Imprimir matriz\n"+
        "3)Ver tamaño\n"+
        "4)Reserva de asientos\n"+
        "5)Acumulado de ventas\n"+
        "6)Matriz identidad\n"+
        "7)Diagonal principal\n"+
        "8)Transposicion\n"+
        "9)Rotacion 90\n"+
        "10)Sumar dos matrices\n"+
        "11)Multiplicar matrices\n"+
        "12)Buscar un valor\n"+
        "13)Es simetrica\n"+
        "14)Repetidos, conteo, unicos, moda y ordenar (ejercicio a-f)\n"+
        "0)Regresar\n"+
        "Seleccione una opcion:");
    }

    public static String menuEmpleados(){
        return leer(
        "==================== EMPLEADOS =======================\n\n"+
        "1)Llenar arreglo de empleados\n"+
        "2)Imprimir empleados\n"+
        "3)Probar un empleado (TestEmpleado)\n"+
        "0)Regresar\n"+
        "Seleccione una opcion:");
    }

    // Listas, Pilas, Colas y Arboles 
    public static String menuPendiente(String titulo){
        return leer(
        "==================== " + titulo + " =======================\n\n"+
        "1)Proximamente\n"+
        "0)Regresar\n"+
        "Seleccione una opcion:");
    }
}