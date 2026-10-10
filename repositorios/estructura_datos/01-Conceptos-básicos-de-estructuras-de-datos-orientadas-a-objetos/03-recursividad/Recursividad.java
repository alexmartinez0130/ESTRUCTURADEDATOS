package estructuradatos.mx.edu.uttt.recursividad;

public class Recursividad {

    // Suma de 1 a n
    public static int sumaUnoAN(int n) {
        if (n <= 1) {
            // caso base
            return n;
        } else {
            // caso general
            return n + sumaUnoAN(n - 1);
        }
    }

    // Factorial de un numero
    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            // caso base
            return 1;
        } else {
            // caso general
            return n * factorial(n - 1);
        }
    }

    // Multiplicacion mediante suma (a * b sin usar el operador *)
    public static int multiplicacionMedianteSuma(int a, int b) {
        if (b == 0) {
            // caso base
            return 0;
        } else {
            // caso general
            return a + multiplicacionMedianteSuma(a, b - 1);
        }
    }

    // Potencia mediante multiplicacion (base ^ exponente sin usar Math.pow)
    public static int potenciaMedianteMultiplicacion(int base, int exponente) {
        if (exponente == 0) {
            // caso base
            return 1;
        } else {
            // caso general
            return base * potenciaMedianteMultiplicacion(base, exponente - 1);
        }
    }
}