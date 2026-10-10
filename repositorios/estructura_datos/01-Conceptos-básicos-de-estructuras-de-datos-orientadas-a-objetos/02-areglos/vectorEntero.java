package estructuradatos.mx.edu.uttt.vectores;

public class vectorEntero {
    private int [] vector ;

    
    public vectorEntero() {
        vector=new int [2];
    }

    public vectorEntero(int tamanio) {
        if (validarTamanio(tamanio)){
            vector =new int [tamanio];
        }else {
            vector =new int [2];
        }
    }
    private boolean validarTamanio(int tamanio){
        return tamanio>1;
    }

    public int obtenertamanio(){
        return vector.length;
    }

    public int [] obtenerVector(){
        return copiarVector();
    }

    private int [] copiarVector (){
        int [] copiarVector=new int [this.obtenertamanio()];
        int i=0;
        for (int valor : this.vector) {
            copiarVector[i] =valor;
            i++;

        }
        return copiarVector;
    }

    //realizar un metodo que regrese el numeor de pares e impares del vector 
    public int contarPares(){
        int pares=0;

        for (int valor : this.vector) {
            if(valor %2==0){
                pares++;
            }
        }
        return pares;
    }

    public int contarImpares(){
        int impares=0;

        for (int valor : this.vector) {
            if(valor %2 !=0){
                impares++;
            }
        }
        return impares;
    }

    //realizar un metodo que obtenga el numero mayor del arreglo

    public int obtenerMayor() {
        int mayor = this.vector[0];

        for (int valor : this.vector) {
            if (valor > mayor) {
            mayor = valor;
            }
        }
        return mayor;
    }

    //realizar un metodo que sume dos vectores 
    public int[] sumarVectores(int[] vector2) {
        if (this.vector.length != vector2.length) {
            return null;
        }

        int[] resultado = new int[this.vector.length];

        for (int i = 0; i < this.vector.length; i++) {
            resultado[i] = this.vector[i] + vector2[i];
            }

        return resultado;
    }

    //llenarVector
    public void llenarVector() {
        for (int i = 0; i < vector.length; i++) {
        vector[i] = DeclaracionVectores.solicitarEnteros();
        }
    }

    //Mostrar vector
    public String mostrarVector() {
        String resultado = "[";

    for (int i = 0; i < vector.length; i++) {
        resultado += vector[i];

        if (i < vector.length - 1) {
            resultado += ", ";
            }
        }
        resultado += "]";
        return resultado;
    }

    //Agregar al vector
    public boolean agregar(int posicion, int valor) {

        if (posicion < 0 || posicion >= vector.length) {
            return false;
        }

        vector[posicion] = valor;

        return true;
    }

    //Imprimir 
    public String imprimir() {
        String resultado = "[";

        for (int i = 0; i < vector.length; i++) {
            resultado += vector[i];

        if (i < vector.length - 1) {
            resultado += ", ";
            }
        }

        resultado += "]";

        return resultado;
    }

    //sumarValores
    public int sumarValores() {
        int suma = 0;

    for (int valor : vector) {
        suma += valor;
    }

        return suma;
    }

    //obtenerPares
    public int[] obtenerPares() {
        int cantidad = contarPares();
        int[] pares = new int[cantidad];

        int i = 0;

        for (int valor : vector) {
            if (valor % 2 == 0) {
                pares[i] = valor;
                i++;
            }
        }
        return pares;
    }

    //obtenerImpares
    public int[] obtenerImpares() {
        int cantidad = contarImpares();
        int[] impares = new int[cantidad];

        int i = 0;

        for (int valor : vector) {
            if (valor % 2 != 0) {
                impares[i] = valor;
                i++;
            }
        }
        return impares;
    }

    //esPrimo
    public boolean esPrimo(int numero) {
        if (numero < 2) {
            return false;
        }

    for (int i = 2; i < numero; i++) {
        if (numero % i == 0) {
            return false;
        }
    }

    return true;
}

    //obtenerPrimos
    public int[] obtenerPrimos() {
        int cantidad = 0;

    for (int valor : vector) {
        if (esPrimo(valor)) {
            cantidad++;
        }
    }

    int[] primos = new int[cantidad];

    int i = 0;

    for (int valor : vector) {
        if (esPrimo(valor)) {
            primos[i] = valor;
            i++;
            }
        }
        return primos;
    }

    //obtenerPromedio
    public double obtenerPromedio() {
        double promedio;

        promedio = (double) sumarValores() / vector.length;

        return promedio;
    }

    //obtenerMenor
    public int obtenerMenor() {
        int menor = this.vector[0];

        for (int valor : this.vector) {
            if (valor < menor) {
                menor = valor;
            }
        }
        return menor;
    }
}

