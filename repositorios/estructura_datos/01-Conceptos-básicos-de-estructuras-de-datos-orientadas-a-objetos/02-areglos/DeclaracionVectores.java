package estructuradatos.mx.edu.uttt.vectores;

import javax.swing.JOptionPane;

public class DeclaracionVectores {
    public static void main(String[] args) {
  
        int []arr1;
        boolean arr2 [];

        arr1= new int [5];
        arr2 =new boolean [6];

        Empleado [] e1 =new Empleado[4];

        String [] nombres= {"rafel","simon","ricarda","toribio"};

        llenarEmpleado(e1);

    }
    public static void llenarEnteros(int [] vector){
        for (int i = 0; i < vector.length; i++) {
            vector[i]=solicitarEnteros();
        }

    }   
    public static void llenarEmpleado(Empleado [] emp){
        int i =0;
        while (i<emp.length){
            emp[i] = solicitarEmpleado();
            i++;
        }
        
    }
    public static Empleado solicitarEmpleado(){
    do{
        try {
            Empleado emp=new Empleado();
            String nombre,numeroNomina,sexo;
            double sueldo;
            boolean activo= false;

            nombre =JOptionPane.showInputDialog("introduce el nombre");
            numeroNomina =JOptionPane.showInputDialog("introduce el numero de nomina");
            sueldo =Double.parseDouble(JOptionPane.showInputDialog("introduce el sueldo"));
            sexo =JOptionPane.showInputDialog("introduce el sexo");

            emp.setNombre(nombre);
            emp.setNumeroNomina(numeroNomina);
            emp.setSexo(sexo);
            emp.setSueldo(sueldo);
            emp.setActivo(activo);

            return emp;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "dato invalido");
            }
        }while(true);
    }


    public static int solicitarEnteros(){
    do{
        try {
        return 
        Integer.parseInt
            (JOptionPane.showInputDialog
                ("introducde el entero"));
            
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Debe ser un entero");
        }
    }while(true);
    }
    public static void imprimir (int[] arr , int tipociclo) {
        String resultado="";        
        if (tipociclo==1){
            //ciclo for 
            resultado="[";
            for (int i = 0; i < arr.length; i++) {
                resultado+="["+arr[i]+",";
            }
            resultado+= "]";

        }else if (tipociclo==2){
            //ciclo while 
            resultado="[";
            int i=0;
            while(i < arr.length){
                resultado+=arr[i] + ",";
                i++;
            }
            resultado+= "]";

        }else if (tipociclo==3){
            //ciclo do while 
            int i=0;
            resultado="[";
            do{
                resultado+=arr[i]+",";
                i++;
            }while (i < arr.length);
            resultado+="]";
            
        }else if (tipociclo==4){
            //foreach
            resultado="[";
            for (int valor : arr) {
                resultado+=valor+",";
            }
            resultado+="]";

        }else {
            resultado="no es ciclo valido";
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    public static void imprimir(Empleado[] arr,int tipociclo) {
        String resultado="";
        int i =0;

        switch (tipociclo) {
            case 1:// for
                for (i = 0; i < arr.length; i++) {
                    resultado+="[" +
                            arr[i].getNombre()+"|" +
                            arr[i].getNumeroNomina()+" | " +
                            arr[i].getSexo()+" | " +
                            arr[i].getSueldo() + "]\n";
                }
                break;

            case 2:// while
                i = 0;
                while (i < arr.length) {
                    resultado+="[" +
                            arr[i].getNombre()+"|" +
                            arr[i].getNumeroNomina()+" | " +
                            arr[i].getSexo()+" | " +
                            arr[i].getSueldo() + "]\n";
                    i++;
                }
                break;

            case 3:// do while
                i = 0;
                do {
                    resultado+="[" +
                            arr[i].getNombre()+"|" +
                            arr[i].getNumeroNomina()+" | " +
                            arr[i].getSexo()+" | " +
                            arr[i].getSueldo() + "]\n";
                    i++;
                } while (i < arr.length);
                break;

            case 4:// foreach
                for (Empleado emp : arr) {
                    resultado+="[" +
                            emp.getNombre()+"|" +
                            emp.getNumeroNomina()+" | " +
                            emp.getSexo()+" | " +
                            emp.getSueldo() + "]\n";
                }
                break;

            default:
                resultado="no es ciclo valido";
                break;
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
}