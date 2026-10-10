package estructuradatos.mx.edu.uttt.matrices;
public class matrices {
    public static void main(String[] args) {
        

        //declarar y definir matrices 
        int m[][]={{1,3,9},{3,5,10}};

        //imprimir con ciclo (for, while, do-while, foreach)

        for (int row = 0; row<m.length; row++){
	
            System.out.println("|");

	    for (int columna = 0; columna<m[row].length; columna++){

	        System.out.print(m[row][columna] + "|");
	        }
            System.out.println("");
        }
         //con while 
    int column =0;
    int row=0;

    while(row <m.length){
        System.out.println("|");
        while(column<m[row].length){
            System.out.println(m[row][column]+"|");
            column++;
        }
        System.out.println();
        row++;
        column=0;
        }

        //do while 

    row=0;
    column=0;

    do{
        System.out.println("|");
        column=0;
        do{
            System.out.println(m[row][column]);
            column++;
        }while(column<m[row].length);
        System.out.println();
        row++;
    }while(row<m.length);

    //for y while 

    //int column=0;
    for ( row=0; row<m.length;row++){
        column=0;
        System.out.println("|");
        while  (column<m[row].length){
            System.out.println(m[row][column]+"|");
            column++;
        }
        System.out.println();
    }

        //foreach
        // para un vector 
        int x[]={1,3,9};
        for (int valor : x){

        }

        /*foreach
        // para una matriz
        for (int row[]:m){
            System.out.println("|");
            for (int valor :row){
                System.out.println(valor + "|");
                }
                System.out.println();
            }    */
        }
    }