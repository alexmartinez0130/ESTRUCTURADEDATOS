package estructuradatos.mx.edu.uttt.vectores;
public  class Empleado{

    private String numeroNomina;
    private String Nombre;
    private String sexo;
    private double sueldo;
    private boolean activo;
    private static int contarObjetos;

    public Empleado (String numeroNomina,
                     String Nombre,
                     String sexo, double sueldo, 
                     boolean activo){
        this.numeroNomina=numeroNomina;
        this.Nombre=Nombre;
        this.sexo=sexo;
        this.sueldo=sueldo;
        this.activo=activo;
        Empleado.contarObjetos++;
    }

    public String getNumeroNomina() {
        return numeroNomina;
    }
    public String getNombre() {
        return Nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setNumeroNomina(String numeroNomina) {
        this.numeroNomina = numeroNomina;
    }

    public void setNombre(String Nombre) {
        this.Nombre=Nombre;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public static int getContarobjetos (){
        return Empleado.contarObjetos;
    }

    @Override
    public String toString() {
        return "empleado [numeroNomina=" +  numeroNomina + "Nombre=" +  Nombre +", sexo=" + sexo + ", sueldo=" + sueldo + ", activo=" + (activo?"activo":"inactivo")
                + "]";
    }
    public Empleado(){
        Empleado.contarObjetos++;
    }
}