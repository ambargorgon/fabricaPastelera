package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Ambar
 */
public class MateriaPrima {

    private int id;
    private String nombre;
    private String unidad;
    private int cantidad;
    private String productoMasUsado;

    public MateriaPrima(int id, String nombre, String unidad, int cantidad, String producto) {
        this.id = id;
        this.nombre = nombre;
        this.unidad = unidad;
        this.cantidad = cantidad;
        this.productoMasUsado = producto;
    }
  
    public String getProductoMasUsado() {
        return productoMasUsado;
    }

    public void setProductoMasUsado(String productoMasUsado) {
        this.productoMasUsado = productoMasUsado;
    }
    static private ArrayList<MateriaPrima> materiasPrimas = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public static ArrayList<MateriaPrima> getMateriasPrimas() {
        return materiasPrimas;
    }

    public static void setMateriasPrimas(ArrayList<MateriaPrima> materiasPrimas) {
        MateriaPrima.materiasPrimas = materiasPrimas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

}
