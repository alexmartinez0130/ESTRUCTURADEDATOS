package estructuradatos.mx.edu.uttt.vectores;

import javax.swing.JOptionPane;
import java.util.Arrays;

public class menuPrincipal {

    public static void main(String[] args) {
        mostrar();
    }

    public static void mostrar() {

        vectorEntero vector = solicitarVector();

        int opcion;

        do {

            opcion = solicitarOpcion();

            switch (opcion) {

                case 1:
                    int posicion = solicitarPosicion(vector.obtenertamanio());
                    int valor = solicitarEntero();

                    if (vector.agregar(posicion, valor)) {
                        JOptionPane.showMessageDialog(null,
                                "Valor agregado correctamente");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Posición inválida");
                    }
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Vector:\n" + vector.imprimir());
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,
                            "La suma de los valores es: "
                            + vector.sumarValores());
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null,
                            "Cantidad de pares: "
                            + vector.contarPares());
                    break;

                case 5:
                    JOptionPane.showMessageDialog(null,
                            "Cantidad de impares: "
                            + vector.contarImpares());
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null,
                            "Números pares:\n"
                            + Arrays.toString(vector.obtenerPares()));
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null,
                            "Números impares:\n"
                            + Arrays.toString(vector.obtenerImpares()));
                    break;

                case 8:
                    JOptionPane.showMessageDialog(null,
                            "Números primos:\n"
                            + Arrays.toString(vector.obtenerPrimos()));
                    break;

                case 9:
                    JOptionPane.showMessageDialog(null,
                            "Promedio: "
                            + vector.obtenerPromedio());
                    break;

                case 10:
                    JOptionPane.showMessageDialog(null,
                            "Valor mayor: " + vector.obtenerMayor()
                            + "\nValor menor: " + vector.obtenerMenor());
                    break;

                case 11:
                    vectorEntero vector2 = solicitarVector();

                    int[] resultado = vector.sumarVectores(
                            vector2.obtenerVector());

                    if (resultado == null) {
                        JOptionPane.showMessageDialog(null,
                                "Los vectores deben tener el mismo tamaño");
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Vector 1: " + vector.imprimir()
                                + "\nVector 2: " + vector2.imprimir()
                                + "\nResultado: "
                                + Arrays.toString(resultado));
                    }
                    break;

                case 0:
                    JOptionPane.showMessageDialog(null,
                            "Programa terminado");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Opción inválida");
            }

        } while (opcion != 0);
    }

    private static vectorEntero solicitarVector() {

        int tamanio;

        do {
            tamanio = solicitarEntero();

            if (tamanio <= 1) {
                JOptionPane.showMessageDialog(null,
                        "El tamaño debe ser mayor a 1");
            }

        } while (tamanio <= 1);

        return new vectorEntero(tamanio);
    }

    private static int solicitarOpcion() {

        do {
            try {

                String entrada = JOptionPane.showInputDialog(
                        null,
                        "MENÚ DE VECTORES\n\n"
                        + "1. Agregar al vector\n"
                        + "2. Imprimir vector\n"
                        + "3. Sumar valores\n"
                        + "4. Contar pares\n"
                        + "5. Contar impares\n"
                        + "6. Mostrar pares\n"
                        + "7. Mostrar impares\n"
                        + "8. Mostrar primos\n"
                        + "9. Promedio\n"
                        + "10. Mayor y menor\n"
                        + "11. Sumar dos vectores\n"
                        + "0. Salir\n\n"
                        + "Selecciona una opción:",
                        "MENÚ",
                        JOptionPane.QUESTION_MESSAGE);

                if (entrada == null) {
                    return 0;
                }

                if (entrada.trim().isEmpty()) {
                    throw new Exception();
                }

                int opcion = Integer.parseInt(entrada);

                if (opcion >= 0 && opcion <= 11) {
                    return opcion;
                }

                JOptionPane.showMessageDialog(null,
                        "Selecciona una opción del 0 al 11");

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null,
                        "Debes introducir un número válido");
            }

        } while (true);
    }

    private static int solicitarEntero() {

        do {
            try {

                String entrada = JOptionPane.showInputDialog(
                        null,
                        "Introduce un número entero:",
                        "Dato",
                        JOptionPane.QUESTION_MESSAGE);

                if (entrada == null) {
                    return 2;
                }

                if (entrada.trim().isEmpty()) {
                    throw new Exception();
                }

                return Integer.parseInt(entrada);

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null,
                        "Debes introducir un número entero válido");
            }
        } while (true);
    }

    private static int solicitarPosicion(int tamanio) {

        do {
            int posicion = solicitarEntero();

            if (posicion >= 0 && posicion < tamanio) {
                return posicion;
            }

            JOptionPane.showMessageDialog(null,
                    "La posición debe estar entre 0 y "
                    + (tamanio - 1));

        } while (true);
    }
}