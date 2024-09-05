package dunder_mifflin_ingreso;

public class Empleado {
    
    private String Nombre;
    private String entrada;
    private String salida;
    private int llegadasTarde;
    private String funcion;
    private long salario;

    public Empleado() {
    }

    public Empleado(String Nombre, String entrada, String salida, int llegadasTarde, String funcion, long salario) {
        this.Nombre = Nombre;
        this.entrada = entrada;
        this.salida = salida;
        this.llegadasTarde = llegadasTarde;
        this.funcion = funcion;
        this.salario = salario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }    

    public int getLlegadasTarde() {
        return llegadasTarde;
    }

    public void setLlegadasTarde(int llegadasTarde) {
        this.llegadasTarde = llegadasTarde;
    }

    public void llegadasTarde(){
        llegadasTarde++;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }

    public long getSalario() {
        return salario;
    }

    public void setSalario(long salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Empleado{" + "Nombre=" + Nombre + ", entrada=" + entrada + ", salida=" + salida + ", llegadasTarde=" + llegadasTarde + ", funcion=" + funcion + ", salario=" + salario + '}';
    }  
    
}
