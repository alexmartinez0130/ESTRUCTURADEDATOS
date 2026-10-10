package estructuradatos.mx.edu.uttt;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
       iniciar();
    }   

    public static void iniciar(){
        String opcion;
        do{
            opcion = Menu.menuPrincipal();
            switch (opcion) {
                case "1":
                    arreglosmenu.mostrar();
                    break;
                case "2":
                    submenuPendiente("LISTAS");
                    break;
                case "3":
                    submenuPendiente("PILAS");
                    break;
                case "4":
                    submenuPendiente("COLAS");
                    break;
                case "5":
                    submenuPendiente("ARBOLES");
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Programa terminado");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }while(true);
    }

    private static void submenuPendiente(String titulo){
        String opcion;
        do{
            opcion = Menu.menuPendiente(titulo);
            if (opcion.equals("1")) {
                JOptionPane.showMessageDialog(null, titulo + ": en construccion");
            } else if (!opcion.equals("0")) {
                JOptionPane.showMessageDialog(null, "Opcion no valida");
            }
        }while(!opcion.equals("0"));
    }
}
