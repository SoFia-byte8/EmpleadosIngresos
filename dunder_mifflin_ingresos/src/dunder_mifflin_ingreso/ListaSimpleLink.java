package dunder_mifflin_ingreso;

import javax.swing.JOptionPane;

public class ListaSimpleLink {
   
    private Nodo primero;
   
     public ListaSimpleLink(){ 
        primero = null;
    }
     
    public void insertInicio (Empleado empleado){
        Nodo nuevo = new Nodo (empleado, primero);
        primero = nuevo;
    } 
    
     public void insertFinal (Empleado empleado){ 
        Nodo nuevo = new Nodo(empleado, null);
        if (primero == null){
        primero = nuevo;
        }
        else {
            Nodo actual = primero;
            while (actual.getNext()!= null){
                actual = actual.getNext();

            }
            actual.setNext(nuevo);
        }
    }
    
    public int ContarElementos(){
        int Cant=0;
        Nodo actual = primero;
        while (actual!= null){
            Cant++;
            actual = actual.getNext();
        }
        return Cant;
    } 
    
    public void borrar (String Nombre){
        if (primero == null) 
            System.out.println("lista vacía");
        else
            if (primero.getEmpleado().getNombre()== Nombre){
            primero = primero.getNext();
            }
            else {
                Nodo actual = primero;
                while (actual.getNext()!=null && actual.getNext().getEmpleado().getNombre()!= Nombre)
                 {
                   actual = actual.getNext(); 
                 }
                if (actual.getNext()== null )
                        System.out.println ("elemento "+Nombre+" no esta en la lista");
                    else{
                        actual.setNext(actual.getNext().getNext());
                    }
            }
    }
    
    public Empleado buscarEmpleado(String nombre) {
        Nodo nodoActual = primero;
        while (nodoActual != null) {
            Empleado empleado = nodoActual.getEmpleado();
            if (empleado.getNombre().equalsIgnoreCase(nombre)) {
                return empleado;
            }
            nodoActual = nodoActual.getNext();
        }
        return null;
    }
    
     public boolean ListaVacia(){
       
        if (primero==null)
              return true;
         else
              return false;   
    } 
     
    public void MostarLista(){

        Nodo actual = primero;
        while (actual!= null){
            JOptionPane.showMessageDialog(null,actual.getEmpleado().toString());
            actual = actual.getNext();
        }
     } 
    
}
