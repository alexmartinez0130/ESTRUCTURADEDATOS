package estructuradatos.mx.edu.uttt.vectores;
import javax.swing.JOptionPane;

public class TestEmpleado {
    String valor;
    private  static Empleado empl;
    public static void main(String[] args) {
        iniciar();
    }
    public static void iniciar (){
        String numeroNomina = solicitarTexto("Numero Nomina");
        String Nombre = solicitarTexto("Nombre Completo");

        empl = new Empleado(numeroNomina,Nombre,"Masculino", 34000.56,true);

        imprimir();
    }


    public static String solicitarTexto(String valor){
        return JOptionPane.showInputDialog("Introduce el " + valor );
    }

    public static void imprimir (){
        String salida = "datos del empleado " +
                        empl.toString()+
                        "numero de objetos creados "+
                        Empleado.getContarobjetos();
                        JOptionPane.showMessageDialog(null, salida);

    }
}
