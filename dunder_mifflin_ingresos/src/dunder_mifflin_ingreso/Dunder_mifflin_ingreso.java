package dunder_mifflin_ingreso;

import javax.swing.JOptionPane;

public class Dunder_mifflin_ingreso {

    static Empleado empleado;
    static ListaSimpleLink list = new ListaSimpleLink();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int op = 0;
        JOptionPane.showMessageDialog(null, "Bienvenido a Dunder Mifflin, INC - Paper Company");
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog("ingrese la opcion que desea:"
                    + "\n1.-Nuevo empleado"
                    + "\n2.-Ingreso del empleado"
                    + "\n3.-Salida del empleado"
                    + "\n4.-Mostrar empleados"
                    + "\n5.-Calcular salario"
                    + "\n6.-Eliminar empleado"
                    + "\n7.-Número de Empleados"
                    + "\n8.-Salir del programa"
            ));
            switch (op) {
                case 1:
                    ingresarEmpleado();
                    break;
                case 2:
                    ingresoEmpleado();
                    break;
                case 3:
                    salidaEmpleado();
                    break;
                case 4:
                    mostrarEmpleado();
                    break;
                case 5:
                    salarioEmpleado();
                    break;
                case 6:
                    eliminarEmpleado();
                    break;
                case 7:
                    contEmpleados();
                    break;
                case 8:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "opcion no disponible");
            }
        } while (op != 8);
    }

    private static void ingresarEmpleado() {
        String nombre = JOptionPane.showInputDialog("ingrese el nombre del empleado");
        String funcion = JOptionPane.showInputDialog("ingrese la funcion del empleado");
        empleado = new Empleado(nombre, "aun no ha entrado", "aun no ha salido", 0, funcion, 0);
        list.insertInicio(empleado);
    }

    private static void ingresoEmpleado() {
        if (list.ListaVacia() == false) {
            try {
                String nombre = JOptionPane.showInputDialog("ingrese el nombre del empleado");
                String ingreso = JOptionPane.showInputDialog("ingrese la hora de ingreso del empleado");
                String[] ingresar = ingreso.split(":");
                int hora = Integer.parseInt(ingresar[0]);
                int hora1 = Integer.parseInt(ingresar[1]);
                if (!list.buscarEmpleado(nombre).equals(true)) {
                    if (hora >= 8 && hora1 >= 15) {
                        JOptionPane.showMessageDialog(null, "has llegado tarde " + nombre);
                        list.buscarEmpleado(nombre).llegadasTarde();
                        list.buscarEmpleado(nombre).setEntrada(ingreso);
                    } else {
                        list.buscarEmpleado(nombre).setEntrada(ingreso);
                        JOptionPane.showMessageDialog(null, "registro exitoso");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "empleado no encontrado");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ingrese bien su nombre");
            }
        } else {
            JOptionPane.showMessageDialog(null, "la lista esta vacia");
        }
    }

    private static void salidaEmpleado() {
        String nombre = JOptionPane.showInputDialog("ingrese el nombre del empleado");
        String salida = JOptionPane.showInputDialog("ingrese la hora de salida del empleado");
        list.buscarEmpleado(nombre).setEntrada(salida);
        JOptionPane.showMessageDialog(null, "registro exitoso");
    }

    private static void mostrarEmpleado() {
        list.MostarLista();
    }

    private static void salarioEmpleado() {
        //salario por hora==20$
        //Horas extra no son pagas
        //Descuento de 10$Por cada llegada tarde
        if (list.ListaVacia() == false) {
            String nombre = JOptionPane.showInputDialog("ingrese el nombre del empleado");
            int horasTrabajadas = Integer.parseInt(JOptionPane.showInputDialog("ingrese las horas trabajadas"));
            int llegadasTarde = list.buscarEmpleado(nombre).getLlegadasTarde();
            int salarioPorHora = 20;
            int horasEmpleado = horasTrabajadas;
            if (horasTrabajadas > 240) {
                int horasExtra = horasTrabajadas - 240;
                horasEmpleado = 240;
                JOptionPane.showMessageDialog(null, "Tienes horas extras " + nombre);
            }
            int salario = salarioPorHora * horasEmpleado;
            int salarioSinHorasExtras = llegadasTarde * 10;
            int total = salario - salarioSinHorasExtras;
            JOptionPane.showMessageDialog(null, "Tú salario de este mes " + nombre + " es de: $" + total + "dolares");

        } else if (list.ListaVacia()) {
            JOptionPane.showMessageDialog(null, "la lista esta vacia");
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese las horas en números enteros");
        }
    }

    private static void eliminarEmpleado() {
        String nombre1 = JOptionPane.showInputDialog("ingrese el nombre del empleado");
        if (!list.buscarEmpleado(nombre1).equals(false)) {
            JOptionPane.showMessageDialog(null, "Se ha elimminado el Empleado " + nombre1 + " del sistema correctamente");
        } else {
            JOptionPane.showMessageDialog(null, "El Empleado " + nombre1 + " no existe, verifique que este bien escrito");
        }
    }

    private static void contEmpleados() {
        if (list.ListaVacia()) {
            JOptionPane.showMessageDialog(null, "Lista vacía");
        } else {
            JOptionPane.showMessageDialog(null, "Empleados Actuales : " + list.ContarElementos());
        }
    }
}
