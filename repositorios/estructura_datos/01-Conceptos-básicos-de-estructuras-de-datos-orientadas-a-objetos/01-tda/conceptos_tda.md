# tipos de datos abstractos 

la idea central es que no se memorice TDA como una definincion 

la seciuencia paar entenderlo 

**problema**=>**datos**=>**operaciones**=>**reglas**=>**abstraccion**=>**TDA**=>**implementacion**=>**clase java**=>**estructura de datos**

para despues entrar a lo que desppues es una *pila*,una *cola* ,*lista* y *arboles* 

1. problema:

>supongamos que tenemos un sistema escolar y queremos manejar estudiantes 

cada estudiante :

- matricula
- nombre
- carrera
- promedio

hasta ahora estamos hablando de  *datos*

pero el programa no solamente necesita almacenar esos datos 
tambien necesita hacer cosas con ellos 

- registrar un cliente 
- consultar sus datos 
- cambiar su promedio 
- verificar si esta aprovaodo 
- mostrar informacion 

en programacion no solamnete importa **que datos tenemos**, si no tambien **que operaciones podemos realizar sobre esos datos**

nota: primer paso hacia un tda


2. dato simple vs algop mas complejo 

ya conocemos 

```java
int edad;
double promedio;
String nombre;


```
estos tipos de datos ya los conoce java.

`int edad =20;`

java sabe:

- que tipo de valor puede almacenar
- cuanto espacio require,
- que operaciones se pueden realizar

con un int: 

```edad +1
edad-1
edad mayor 18
edad++
++edad
```

Pero si pensamos en:

`Estudiante`

Jva originalmente no tiene un tipo llamado **Estuadiante**

Necesitamos construirlo

Aqui comienza a aparecer la idea de **crear nuestros propios tipos de datos**

3. ¿ que seria un tipo de dato ?

Se puede definir inicualmente asi:
 Un tipo de dato define que valores pueden existir y que 
 opreciones pueden realizarse con esos valores

 Por ejemplo:

 *int*
 valores posibles:

 -10
 0
 5
 100
 2500

 operaciones: Aritmeticas y Relacionales

**boolean**

 valores:

 ```
 true
 false

 ```
 Operaciones:

