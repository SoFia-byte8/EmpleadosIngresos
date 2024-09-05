
package dunder_mifflin_ingreso;

public class Nodo {
    
    private Empleado empleado;
    private Nodo next;

    public Nodo(Empleado emplea, Nodo next1) {
        empleado = emplea;
        next = next1;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    
    
    
}
