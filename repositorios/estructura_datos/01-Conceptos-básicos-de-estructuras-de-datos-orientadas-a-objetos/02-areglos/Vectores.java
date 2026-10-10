package estructuradatos.mx.edu.uttt.vectores;

public class Vectores {
    private int [] vector;
    private int tamanio;

    public Vectores(){
        this.vector=new int [2];
        this.tamanio = vector.length;

    }

    public Vectores(int tamanio){
        this.vector =   validarTamanio(tamanio)?
                        new int [tamanio]: 
                        new int [2];

        this.tamanio = this.vector.length;

    }

    public int obtenerTamanio(){
        return this.tamanio;
    }

    private boolean validarTamanio(int tamanio){
        return tamanio>0;
    }

    private boolean sonIguales (int [] vector){
        return this.vector.length== vector.length;
    }

    public  void llenarVector(int [] vector){
        if (sonIguales(vector)){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] = vector[i];
            }
        }else{
            System.out.println("los vectores no son del mismo tamaño");
        }
    }

    public int sumarVectores (){
        int suma=0;

        for (int i = 0; i < this.vector.length; i++) {
            suma+=this.vector[i];
        }
        return suma;
    }

    public String imprimir(){
        String salida="";
        for (int valor : this.vector) {
            salida+=valor+ " ";
        }
        return salida;
    }

    
}   
