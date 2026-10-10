package estructuradatos.mx.edu.uttt;

import javax.swing.JOptionPane;

import estructuradatos.mx.edu.uttt.matrices.Matricess;
import estructuradatos.mx.edu.uttt.recursividad.Recursividad;
import estructuradatos.mx.edu.uttt.vectores.DeclaracionVectores;
import estructuradatos.mx.edu.uttt.vectores.Empleado;
import estructuradatos.mx.edu.uttt.vectores.TestEmpleado;
import estructuradatos.mx.edu.uttt.vectores.menuPrincipal;

public class arreglosmenu {

    private static Matricess objMatriz;
    private static Matricess objAsientos;
    private static Empleado[] empleados;

    public static void mostrar(){
        String opcion;
        do {
            opcion = Menu.menuArreglos();
            switch (opcion) {
                case "1":
                    menuPrincipal.mostrar();
                    break;
                case "2":
                    menuMatrices();
                    break;
                case "3":
                    menuRecursividad();
                    break;
                case "0":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (true);
    }

    public static void menuMatrices(){
        String opcion;
        do {
            opcion = Menu.menuMatrices();
            switch (opcion) {
                case "1":
                    crearYLlenarMatriz();
                    break;
                case "2":
                    if (hayMatriz()) {
                        JOptionPane.showMessageDialog(null, objMatriz.obtenerTexto());
                    }
                    break;
                case "3":
                    if (hayMatriz()) {
                        JOptionPane.showMessageDialog(null, objMatriz.obtenertamaño());
                    }
                    break;
                case "4":
                    reservaDeAsientos();
                    break;
                case "5":
                    acumuladoDeVentas();
                    break;
                case "6":
                    diagnosticoIdentidad();
                    break;
                case "7":
                    diagnosticoDiagonal();
                    break;
                case "8":
                    transposicion();
                    break;
                case "9":
                    rotacion();
                    break;
                case "10":
                    if (!hayMatriz()) break;
                    Matricess matB = pedirMatricess("Matriz B (mismo tamaño)");
                    Matricess suma = objMatriz.sumar(matB);
                    if (suma == null) {
                        JOptionPane.showMessageDialog(null, "No se pueden sumar, tamaños distintos");
                    } else {
                        JOptionPane.showMessageDialog(null, suma.obtenerTexto());
                    }
                    break;
                case "11":
                    if (!hayMatriz()) break;
                    Matricess matC = pedirMatricess("Matriz B (filas de B = columnas de A)");
                    Matricess producto = objMatriz.multiplicar(matC);
                    if (producto == null) {
                        JOptionPane.showMessageDialog(null, "No se pueden multiplicar");
                    } else {
                        JOptionPane.showMessageDialog(null, producto.obtenerTexto());
                    }
                    break;
                case "12":
                    if (!hayMatriz()) break;
                    int valor = pedirEntero("Valor a buscar");
                    int[] pos = objMatriz.buscarValor(valor);
                    if (pos == null) {
                        JOptionPane.showMessageDialog(null, "No se encontro");
                    } else {
                        JOptionPane.showMessageDialog(null, "Fila " + pos[0] + ", columna " + pos[1]);
                    }
                    break;
                case "13":
                    if (!hayMatriz()) break;
                    JOptionPane.showMessageDialog(null, "Es simetrica: " + objMatriz.esSimetrica());
                    break;
                case "14":
                    ejercicioRepetidos();
                    break;
                case "0":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (true);
    }

    private static void crearYLlenarMatriz(){
        int filas = pedirEntero("Numero de filas");
        int columnas = pedirEntero("Numero de columnas");
        objMatriz = new Matricess(filas, columnas);   // si son invalidas crea 2x2

        int f = objMatriz.filas();
        int c = objMatriz.columnas();
        int[][] datos = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                datos[i][j] = pedirEntero("Valor para [" + i + "][" + j + "]");
            }
        }
        objMatriz.llenar(datos);
        JOptionPane.showMessageDialog(null, "Matriz creada:\n" + objMatriz.obtenerTexto());
    }

    private static boolean hayMatriz(){
        if (objMatriz == null) {
            JOptionPane.showMessageDialog(null, "Primero crea y llena una matriz (opcion 1)");
            return false;
        }
        return true;
    }

    // Reserva de asientos
    private static void reservaDeAsientos(){
        if (objAsientos == null) {
            int filas = pedirEntero("Filas del cine");
            int columnas = pedirEntero("Columnas del cine");
            objAsientos = new Matricess(filas, columnas);
        }

        int fila = pedirEntero("Fila del asiento (0 a " + (objAsientos.filas() - 1) + ")");
        int columna = pedirEntero("Columna del asiento (0 a " + (objAsientos.columnas() - 1) + ")");

        String resultado = objAsientos.reservarAsiento(fila, columna);
        JOptionPane.showMessageDialog(null, resultado + "\n\n" + objAsientos.obtenerTexto());
    }

    // Acumulado de ventas 
    private static void acumuladoDeVentas(){
        int sucursales = pedirEntero("Numero de sucursales");
        int meses = pedirEntero("Numero de meses");

        Matricess ventas = new Matricess(sucursales, meses);
        int[][] datos = new int[ventas.filas()][ventas.columnas()];
        for (int i = 0; i < datos.length; i++) {
            for (int j = 0; j < datos[i].length; j++) {
                datos[i][j] = pedirEntero("Ventas sucursal " + i + ", mes " + j);
            }
        }
        ventas.llenar(datos);

        JOptionPane.showMessageDialog(null, ventas.obtenerReporteVentas());
    }

    // Matriz identidad
    private static void diagnosticoIdentidad(){
        if (!hayMatriz()) {
            return;
        }
        if (!objMatriz.esCuadrada()) {
            JOptionPane.showMessageDialog(null, "La matriz no es cuadrada, no se puede evaluar");
            return;
        }
        String resultado = objMatriz.esIdentidad()
                ? "La matriz SI es identidad"
                : "La matriz NO es identidad";
        JOptionPane.showMessageDialog(null, resultado);
    }

    // Diagonal principal 
    private static void diagnosticoDiagonal(){
        if (!hayMatriz()) {
            return;
        }
        if (!objMatriz.esCuadrada()) {
            JOptionPane.showMessageDialog(null, "La matriz no es cuadrada, no se puede calcular la diagonal");
            return;
        }
        JOptionPane.showMessageDialog(null, "Suma de la diagonal principal: " + objMatriz.sumaDiagonal());
    }

    // Transposicion 
    private static void transposicion(){
        if (!hayMatriz()) {
            return;
        }
        Matricess transpuesta = objMatriz.obtenerTranspuesta();
        JOptionPane.showMessageDialog(null, "Matriz transpuesta:\n" + transpuesta.obtenerTexto());
    }

    // Rotacion 90 grados
    private static void rotacion(){
        if (!hayMatriz()) {
            return;
        }
        if (!objMatriz.esCuadrada()) {
            JOptionPane.showMessageDialog(null, "La matriz debe ser cuadrada para rotarla");
            return;
        }
        Matricess rotada = objMatriz.rotar90();
        JOptionPane.showMessageDialog(null, "Matriz rotada 90 grados:\n" + rotada.obtenerTexto());
    }

    // Ejercicios de Examen a-f: repetidos, conteo, unicos, moda y ordenar 
    private static void ejercicioRepetidos(){
        if (!hayMatriz()) {
            return;
        }
        int[][] m = objMatriz.obtenerMatriz();

        // b) identificar los numeros repetidos (sin repetir el mismo en la lista)
        int[] mostrados = new int[m.length * m[0].length];
        int cantMostrados = 0;
        StringBuilder sbRepetidos = new StringBuilder();
        for (int[] fila : m) {
            for (int v : fila) {
                if (esRepetido(m, v) && !yaExiste(mostrados, cantMostrados, v)) {
                    sbRepetidos.append(v).append(" ");
                    mostrados[cantMostrados] = v;
                    cantMostrados++;
                }
            }
        }
        JOptionPane.showMessageDialog(null,
                "b) Numeros repetidos: " + (cantMostrados == 0 ? "ninguno" : sbRepetidos.toString()));

        // c) cuantas veces aparece cada numero
        int[] unicos = obtenerValoresUnicos(m);
        StringBuilder sbConteo = new StringBuilder();
        for (int v : unicos) {
            sbConteo.append(v).append(": ").append(contarApariciones(m, v)).append(" veces\n");
        }
        JOptionPane.showMessageDialog(null, "c) Conteo de apariciones:\n" + sbConteo.toString());

        // d) segundo arreglo sin duplicados
        JOptionPane.showMessageDialog(null, "d) Arreglo sin duplicados: " + imprimirArreglo(unicos));

        // e) el numero que mas aparecio
        int masFrecuente = valorMasFrecuente(m);
        JOptionPane.showMessageDialog(null, "e) El numero que mas aparecio: " + masFrecuente);

        // f) ordenar el arreglo resultante de menor a mayor
        int[] ordenado = unicos.clone();
        ordenar(ordenado);
        JOptionPane.showMessageDialog(null, "f) Arreglo ordenado: " + imprimirArreglo(ordenado));
    }

    private static int contarApariciones(int[][] m, int valor){
        int contador = 0;
        for (int[] fila : m) {
            for (int v : fila) {
                if (v == valor) contador++;
            }
        }
        return contador;
    }

    private static boolean esRepetido(int[][] m, int valor){
        return contarApariciones(m, valor) > 1;
    }

    private static boolean yaExiste(int[] arr, int cantidad, int valor){
        for (int i = 0; i < cantidad; i++) {
            if (arr[i] == valor) return true;
        }
        return false;
    }

    private static int[] obtenerValoresUnicos(int[][] m){
        int[] temporal = new int[m.length * m[0].length];
        int cantidad = 0;
        for (int[] fila : m) {
            for (int v : fila) {
                if (!yaExiste(temporal, cantidad, v)) {
                    temporal[cantidad] = v;
                    cantidad++;
                }
            }
        }
        int[] unicos = new int[cantidad];
        for (int i = 0; i < cantidad; i++) {
            unicos[i] = temporal[i];
        }
        return unicos;
    }

    private static int valorMasFrecuente(int[][] m){
        int mayorValor = m[0][0];
        int mayorConteo = 0;
        for (int[] fila : m) {
            for (int v : fila) {
                int conteo = contarApariciones(m, v);
                if (conteo > mayorConteo) {
                    mayorConteo = conteo;
                    mayorValor = v;
                }
            }
        }
        return mayorValor;
    }

    private static void ordenar(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    private static String imprimirArreglo(int[] arr){
        String r = "[";
        for (int i = 0; i < arr.length; i++) {
            r += arr[i] + (i < arr.length - 1 ? ", " : "");
        }
        return r + "]";
    }

    // Capturar una segunda matriz (para sumar/multiplicar)
    private static Matricess pedirMatricess(String titulo){
        JOptionPane.showMessageDialog(null, titulo);
        int filas = pedirEntero("Filas");
        int columnas = pedirEntero("Columnas");
        Matricess m = new Matricess(filas, columnas);
        int[][] datos = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                datos[i][j] = pedirEntero("Valor [" + i + "][" + j + "]");
            }
        }
        m.llenar(datos);
        return m;
    }

    public static void menuRecursividad(){
        String opcion;
        do {
            opcion = Menu.menuRecursividad();
            switch (opcion) {
                case "1":
                    int n1 = pedirEntero("Suma de 1 a n: dame n");
                    JOptionPane.showMessageDialog(null,
                            "Suma de 1 a " + n1 + " = " + Recursividad.sumaUnoAN(n1));
                    break;
                case "2":
                    int n2 = pedirEntero("Factorial: dame n");
                    JOptionPane.showMessageDialog(null,
                            "Factorial de " + n2 + " = " + Recursividad.factorial(n2));
                    break;
                case "3":
                    int a = pedirEntero("Multiplicacion mediante suma: dame a");
                    int b = pedirEntero("Multiplicacion mediante suma: dame b");
                    JOptionPane.showMessageDialog(null,
                            a + " x " + b + " = " + Recursividad.multiplicacionMedianteSuma(a, b));
                    break;
                case "4":
                    int base = pedirEntero("Potencia: dame la base");
                    int exponente = pedirEntero("Potencia: dame el exponente");
                    JOptionPane.showMessageDialog(null,
                            base + " ^ " + exponente + " = "
                            + Recursividad.potenciaMedianteMultiplicacion(base, exponente));
                    break;
                case "0":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (true);
    }

    public static void menuEmpleados(){
        String opcion;
        do {
            opcion = Menu.menuEmpleados();
            switch (opcion) {
                case "1":
                    int n = pedirEntero("Cuantos empleados");
                    if (n <= 0) {
                        JOptionPane.showMessageDialog(null, "Debe ser mayor a 0");
                    } else {
                        empleados = new Empleado[n];
                        DeclaracionVectores.llenarEmpleado(empleados);
                    }
                    break;
                case "2":
                    if (empleados == null) {
                        JOptionPane.showMessageDialog(null, "Primero llena el arreglo (opcion 1)");
                    } else {
                        int ciclo = pedirEntero("Tipo de ciclo: 1)for 2)while 3)do-while 4)foreach");
                        DeclaracionVectores.imprimir(empleados, ciclo);
                    }
                    break;
                case "3":
                    TestEmpleado.iniciar();
                    break;
                case "0":
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        } while (true);
    }

    private static int pedirEntero(String mensaje){
        do {
            try {
                String entrada = JOptionPane.showInputDialog(mensaje);
                if (entrada == null) {
                    return 0;
                }
                return Integer.parseInt(entrada.trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Debe ser un numero entero");
            }
        } while (true);
    }
}