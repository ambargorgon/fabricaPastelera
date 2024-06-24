package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Ambar
 */
public class Producto {

    private String nombre;
    private int id;
    private String ingrediente1;
    private String ingrediente2;
    private String ingrediente3;
    private int cantidad1;
    private int cantidad2;
    private int cantidad3;
    private static ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<String> ingredientes;
    private ArrayList<Double> cantidad;

    public Producto(int id, String nombre, String ingrediente1, int cantidad1, String ingrediente2, int cantidad2, String ingrediente3, int cantidad3) {
        this.id = id;
        this.nombre = nombre;
        this.ingrediente1 = ingrediente1;
        this.cantidad1 = cantidad1;
        this.ingrediente2 = ingrediente2;
        this.cantidad2 = cantidad2;
        this.ingrediente3 = ingrediente3;
        this.cantidad3 = cantidad3;
    }

    public static Producto setProducto(String nombre) {
        for (Producto pr : productos) {
            if (pr.getNombre().equalsIgnoreCase(nombre)) {
                return pr;
            }
        }
        return null;
    }

    public static void setProductos(ArrayList<Producto> productos) {
        Producto.productos = productos;
    }

    public static ArrayList<Producto> getProductos() {
        return productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIngrediente1() {
        return ingrediente1;
    }

    public void setIngrediente1(String ingrediente1) {
        this.ingrediente1 = ingrediente1;
    }

    public String getIngrediente2() {
        return ingrediente2;
    }

    public void setIngrediente2(String ingrediente2) {
        this.ingrediente2 = ingrediente2;
    }

    public String getIngrediente3() {
        return ingrediente3;
    }

    public void setIngrediente3(String ingrediente3) {
        this.ingrediente3 = ingrediente3;
    }

    public int getCantidad1() {
        return cantidad1;
    }

    public void setCantidad1(int cantidad1) {
        this.cantidad1 = cantidad1;
    }

    public int getCantidad2() {
        return cantidad2;
    }

    public void setCantidad2(int cantidad2) {
        this.cantidad2 = cantidad2;
    }

    public int getCantidad3() {
        return cantidad3;
    }

    public void setCantidad3(int cantidad3) {
        this.cantidad3 = cantidad3;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public ArrayList<Double> getCantidad() {
        return cantidad;
    }

    public void setCantidad(ArrayList<Double> cantidad) {
        this.cantidad = cantidad;
    }

}
