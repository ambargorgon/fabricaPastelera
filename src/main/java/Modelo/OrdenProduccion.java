package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Ambar
 */
public class OrdenProduccion {

    private int id;
    private String nombreProducto;
    private Producto producto;
    private int cantidad;
    private boolean cumplida;
    private static ArrayList<OrdenProduccion> ordenesCumplidas = new ArrayList<>();
    private static ArrayList<OrdenProduccion> ordenesPendientes = new ArrayList<>();

    public OrdenProduccion(int id, String nombreProducto, int cantidad, boolean cumplida) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.cumplida = false;
    }
    
  
    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void cumplirOrden(OrdenProduccion op) {
        op.setCumplida(true);
        ordenesCumplidas.add(op);
    }

    public static ArrayList<OrdenProduccion> getOrdenesCumplidas() {
        return ordenesCumplidas;
    }

    public static void setOrdenesCumplidas(ArrayList<OrdenProduccion> ordenesCumplidas) {
        OrdenProduccion.ordenesCumplidas = ordenesCumplidas;
    }

    public static ArrayList<OrdenProduccion> getOrdenesPendientes() {
        return ordenesPendientes;
    }

    public static void setOrdenesPendientes(ArrayList<OrdenProduccion> ordenesPendientes) {
        OrdenProduccion.ordenesPendientes = ordenesPendientes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isCumplida() {
        return cumplida;
    }

    public void setCumplida(boolean cumplida) {
        this.cumplida = cumplida;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

}
