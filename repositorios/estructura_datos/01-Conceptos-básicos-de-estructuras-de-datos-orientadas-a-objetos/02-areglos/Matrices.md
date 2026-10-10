## Ejercicios con Matrices

1. aplica la logica unibinecncional (matrices) utilizando la poo implementando validaciones de dimenciones recorridos de indices y encapsulacion
    - sistema de reserva de asientos 
        - diseña un metood que se llame reserva asiento debe recibir la fila y la columna
        ' reservaAsiento(int fila , int columna ) '
        - que controle el mapa de ocupacion de un cine la la matriz iniciara en 0  y eso significa libre 
        - si el asiento solicitado contontiene 0 cambialo a 1 (* ocupado y muestra un mensaje de exito )
        - si el asiento ya contiene 1 notifica que esta ocupado 
        - validar que las cordenadas ingresads no exedan los limites de la matriz 
        m*n rectangular 
        n*n cuadrada 

    ##

2. acumulado de ventas por sucursal y mes (m*n)
    - una empresa registra las ventas enteras de m sucursales en n meses 
        - implementar un metodo que calcule la suma por cada fila (total por sucursal) filas completas cuanto son 
        - calcular la suma por cada columna (total por mes  )  columnas completas suma una por una 
        - genera un reporte formateado que muestre ambos totales en un solo panel de texto  (imprime la matriz y ponla bonita )

    ##

3. diagnostico de matriz identidad y diagonal principal n*n debe ser cuadrada 
    - implementa un modulo para analisis algebraico
        - validacion previa  comprueba si la matriz es cuadrada si no lo es calcela la operacion y muestra un mensaje de advertencia 
        - si es cuadrada , evalua si es una matriz identidad    
        - 1 en la diagonal principal y 0 en el resto de la matriz 
        - calcula e imprime la suma de los elementos de la diagonal principal 

    ##

4. transpocicion dimamica de matriz (m*n -> n*n)
    - crea un metodo obtener transpuerta que invierta la orientacion de los datos 
    - la funcion debe retornar una nueva instancia de la clase matriz con dimenciones invertidas n*n
    - copia cada elemento sigiendo la regla de transpuesta [j][i] = [i][j]

    ## 

5. rotacion de la matriz a 90 grados en sentido horario n*n  
    - simula el giro de una matriz cuadrada en pixeles y mapa 
        - verifica que la matriz es exactamente cuadrada 
        - retorna una nueva instancia de matriz rotada 90 grados a la dere4cha 

    ##