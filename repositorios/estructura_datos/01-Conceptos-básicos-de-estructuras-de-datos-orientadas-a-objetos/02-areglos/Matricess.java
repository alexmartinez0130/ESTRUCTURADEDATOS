package estructuradatos.mx.edu.uttt.matrices;
public class Matricess {
  
    private int[][] m;

    public Matricess() {
        m = new int[2][2];
    }

    public Matricess(int fila, int column) {
        if (validar(fila, column)) {
            this.m = new int[fila][column];
        } else {
            this.m = new int[2][2];
        }
    }

    private boolean validar(int fila, int column) {
        boolean valido = true;
        if (fila <= 0 || column <= 0) {
            valido = false;
        }
        return valido;
    }

    private boolean validartamanos(int[][] m) {
        return this.m.length == m.length
                && this.m[0].length == m[0].length;
    }

    public void llenar(int[][] m) {
        if (validartamanos(m)) {
            for (int i = 0; i < this.m.length; i++) {
                for (int j = 0; j < this.m[i].length; j++) {
                    this.m[i][j]=m[i][j];
                }
            }
        }else{
            System.out.println("las matrices no son el mismo tamaño");
        }
    }

    public void imprimir (){
        for (int[] fila : this.m) {
            for (int valor : fila) {
                System.out.print(valor + "  ");
            }
            System.out.println();
        }
    }

    public String obtenertamaño(){
        return "tamaño:(" + this.m.length +"," + this.m[0].length + ")";
    }

    public int filas(){
        return this.m.length;
    }

    public int columnas(){
        return this.m[0].length;
    }

    public String obtenerTexto(){
        String salida = "";
        for (int[] fila : this.m) {
            for (int valor : fila) {
                salida += valor + "  ";
            }
            salida += "\n";
        }
        return salida;
    }

    public int[][] obtenerMatriz(){
        return this.m;
    }

    public boolean esCuadrada(){
        return this.m.length == this.m[0].length;
    }

    //Reserva de asientos
    // 0 = libre, 1 = ocupado
    public String reservarAsiento(int fila, int columna){
        if (fila < 0 || fila >= this.m.length || columna < 0 || columna >= this.m[0].length) {
            return "Coordenadas fuera de los limites de la matriz";
        }
        if (this.m[fila][columna] == 0) {
            this.m[fila][columna] = 1;
            return "Asiento reservado con exito";
        } else {
            return "El asiento ya esta ocupado";
        }
    }

    // Acumulado de ventas por sucursal y mes 
    public String obtenerReporteVentas(){
        StringBuilder salida = new StringBuilder();

        salida.append("Matriz de ventas:\n").append(obtenerTexto()).append("\n");

        salida.append("Total por sucursal (filas):\n");
        for (int i = 0; i < this.m.length; i++) {
            int suma = 0;
            for (int j = 0; j < this.m[i].length; j++) {
                suma += this.m[i][j];
            }
            salida.append("  Sucursal ").append(i).append(": ").append(suma).append("\n");
        }

        salida.append("\nTotal por mes (columnas):\n");
        for (int j = 0; j < this.m[0].length; j++) {
            int suma = 0;
            for (int i = 0; i < this.m.length; i++) {
                suma += this.m[i][j];
            }
            salida.append("  Mes ").append(j).append(": ").append(suma).append("\n");
        }

        return salida.toString();
    }

    //Matriz identidad y diagonal principal 
    public boolean esIdentidad(){
        if (!esCuadrada()) {
            return false;
        }
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                if (i == j && this.m[i][j] != 1) {
                    return false;
                }
                if (i != j && this.m[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public int sumaDiagonal(){
        int suma = 0;
        for (int i = 0; i < this.m.length; i++) {
            suma += this.m[i][i];
        }
        return suma;
    }

    //Transposicion 
    public Matricess obtenerTranspuesta(){
        Matricess transpuesta = new Matricess(this.m[0].length, this.m.length);

        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                transpuesta.m[j][i] = this.m[i][j];
            }
        }
        return transpuesta;
    }

    // Rotacion 90 grados en sentido horario 
    public Matricess rotar90(){
        int n = this.m.length;
        Matricess rotada = new Matricess(n, n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotada.m[j][n - 1 - i] = this.m[i][j];
            }
        }
        return rotada;
    }

    //Suma de matrices 
    public Matricess sumar(Matricess otra){
        if (this.m.length != otra.m.length || this.m[0].length != otra.m[0].length) {
            return null;
        }
        Matricess resultado = new Matricess(this.m.length, this.m[0].length);
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                resultado.m[i][j] = this.m[i][j] + otra.m[i][j];
            }
        }
        return resultado;
    }

    // Multiplicacion de matrices 
    public Matricess multiplicar(Matricess otra){
        if (this.m[0].length != otra.m.length) {
            return null;
        }
        Matricess resultado = new Matricess(this.m.length, otra.m[0].length);
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < otra.m[0].length; j++) {
                int suma = 0;
                for (int k = 0; k < this.m[0].length; k++) {
                    suma += this.m[i][k] * otra.m[k][j];
                }
                resultado.m[i][j] = suma;
            }
        }
        return resultado;
    }

    //Buscar un valor
    public int[] buscarValor(int valor){
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                if (this.m[i][j] == valor) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    //Matriz simetrica 
    public boolean esSimetrica(){
        if (!esCuadrada()) {
            return false;
        }
        for (int i = 0; i < this.m.length; i++) {
            for (int j = 0; j < this.m[i].length; j++) {
                if (this.m[i][j] != this.m[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
}