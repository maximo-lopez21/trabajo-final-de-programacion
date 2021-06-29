package tienda;

import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
	 
    String nombrePr;
    int Almacen;
    double precio;
 
    public Tienda() {
        solicitarNombrePro();
        solicitarAlmacenPro();
        solicitarPrecioPro();
    }
 
    public static int solicitarProductos() {
        int numeroPro;
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("¿Cuantos productos desea comprar?");
 
        numeroPro = teclado.nextInt();
        return numeroPro;
    }
    public void solicitarNombrePro(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("------Producto--------");
        System.out.println("Introduce el nombre del producto: ");
        nombrePr = teclado.nextLine();
    }
 
    public void solicitarAlmacenPro(){
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("Introduce el Almacen de: " + devolverNombre() + " : ");
        Almacen = teclado.nextInt();
    }
 
    public void solicitarPrecioPro(){
        Scanner teclado = new Scanner(System.in);
 
        System.out.println("Introduce el precio de: " + devolverNombre() + " : ");
        precio = teclado.nextInt();
    }
 
    public String devolverNombre(){
        return nombrePr;
    }
    public double devolverPrecio(){
        return precio;
    }
    public int devolverAlmacen(){
        return Almacen;
    }
    public void modificarAlmacen(int sto){
    	Almacen = Almacen -sto;
        System.out.println("Venta realizada.");
    }
    public boolean quedaAlmacen(int sto){
 
        if (Almacen >= sto) {
 
            return true;
 
        } else {
 
            System.err.println("Error. Quedan " + Almacen + " unidades");
 
            return false;
        }
    }
    public static void menuEntrada (ArrayList <Tienda> productos) {
        int opcion;
 
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("+++ Supermecado +++++");
            System.out.println("");
            System.out.println("Pulse 1 para acceso al Menu de compras de productos");
            System.out.println("Pulse 2 para acceder al Menu de Ventas");
            System.out.println("Pulse 3 para salir ");
            opcion = teclado.nextInt();
 
            switch (opcion) {
                case 1: {
                    menuProductos(productos);
                    break;
                }
                case 2: {
                    menuVentas(productos);
                    break;
                }
                case 3: {
                    System.out.println("Gracias!!! por usar el programa");
                    break;
                }
                default: {
                    System.out.println("Error");
                    break;
                }
            }
 
        } while (opcion != 3);
 
 
    }
 
    public static void menuProductos(ArrayList<Tienda> productos) {
        String respuesta = "no";
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("- Menu de compras de Productos -");
 
            productos.add(new Tienda());
 
            System.out.println("¿Desea compra Otro Producto?");
            respuesta = teclado.nextLine();
        } while (respuesta.equalsIgnoreCase("si"));
 
    }
 
    public static void menuVentas(ArrayList<Tienda> productos) {
        Scanner teclado = new Scanner(System.in);
        int opcion;
        int unidades=0;
        String respuesta;
        double factura = 0;
        do {
            System.out.println("--Menu de venta de productos--");
            System.out.println("");
 
            for (int i = 0; i < productos.size(); i++) {
                System.out.println("Puse " + i + " Para comprar " + productos.get(i).devolverNombre() + " cuyo precio es de " + productos.get(i).devolverPrecio() + " y el Almacen es de " + productos.get(i).devolverAlmacen() + " unidades");
            }
 
            opcion = teclado.nextInt();
 
            System.out.println("Ha elegido comprar " + productos.get(opcion).devolverNombre());
 
            for (int i = opcion; i < productos.size(); i++) {
 
                unidades = unidades(productos);
 
                if (productos.get(i).quedaAlmacen(unidades) == true) {
                    productos.get(i).modificarAlmacen(unidades);
                     unidades = (int) (unidades * productos.get(i).devolverPrecio());
                }
                break;
            }
 
            factura = factura + unidades;
 
            System.out.println("¿Desea comprar otro producto?(si/no)");
            respuesta = teclado.next();
 
        } while (respuesta.equalsIgnoreCase("si"));
 
        System.out.println("El total de su compra es: " + factura + "€");
 
    }
 
    public static int unidades(ArrayList<Tienda> productos) {
        Scanner teclado = new Scanner(System.in);
        int unidades;
 
        System.out.println("¿Cuantas unidades quieres?");
        unidades = teclado.nextInt();
 
        return unidades;
    }
 
 
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
 
        ArrayList<Tienda> productos = new ArrayList<>();
 
        menuEntrada(productos);
 
    }
 
}