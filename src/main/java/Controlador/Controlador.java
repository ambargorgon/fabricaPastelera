package Controlador;

import Modelo.DatabaseConnector;
import Modelo.MateriaPrima;
import Modelo.OrdenProduccion;
import Modelo.Producto;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ambar
 */
public class Controlador implements ActionListener {

    Vista vista;

    public Controlador() {
        this.vista = new Vista();
        vista.agregarListenerBotonAgregar(this);
        vista.agregarListenerBotonEjecutar(this);
    }

    public void iniciar() {
        vista.setLocationRelativeTo(null);
        vista.setVisible(true);

        //Establecer datos en tablas
        actualizarTablas();

        //Establecer lista de productos disponibles para fabricar
        obtenerProductos();
        JComboBox<String> comboBox = vista.getProductoInput();
        ArrayList<Producto> productos = Producto.getProductos();
        for (int i = 0; i < productos.size(); i++) {
            comboBox.addItem(productos.get(i).getNombre());
        }
    }

    //Evento de botones
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBtnAgregar()) {
            agregarOrdenPendiente();
        } else if (ae.getSource() == vista.getEjecutarBtn()) {
            ejecutarOrdenSeleccionada();
        }
    }

    //LLamado desde Boton ejecutar
    public void ejecutarOrdenSeleccionada() {
        //Obtener nombre de ordenPendiente
        String productoSeleccionado = (String) vista.getTablaPendientes().getModel().getValueAt(vista.getTablaPendientes().getSelectedRow(), 1);
        //Obtener cantidad de ordenPendiente
        int cantidadSeleccionada = (int) vista.getTablaPendientes().getModel().getValueAt(vista.getTablaPendientes().getSelectedRow(), 2);

        if (productoSeleccionado != null) {
            vista.mostrarMensajeConfirmacion("Producto seleccionado: " + productoSeleccionado);
            comprobarDisponibilidad(productoSeleccionado, cantidadSeleccionada);
        } else {
            vista.mostrarMensajeConfirmacion("No se ha seleccionado ningún producto");
        }
    }

    public void agregarOrdenPendiente() {
        //Creacion de nuevas ordenes a traves de inputs en la vista
        OrdenProduccion op = new OrdenProduccion(
                Integer.parseInt((vista.getIdInput().getText())),
                vista.getProductoInput().getSelectedItem().toString(),
                Integer.parseInt(vista.getCantidadInput().getText()),
                false
        );

        PreparedStatement preparedStatement = null;
        DatabaseConnector connector = new DatabaseConnector();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO ordenes (Id, Nombre, Cantidad, Cumplida) VALUES (?, ?, ?, false)";
            preparedStatement = connection.prepareStatement(sql);

            // Establecer el valor del parámetro
            preparedStatement.setInt(1, op.getId());
            preparedStatement.setString(2, op.getNombreProducto());
            preparedStatement.setInt(3, op.getCantidad());

            int rowsUpdated = preparedStatement.executeUpdate();
            //Añadir nueva orden a ordenes pendientes
            vista.mostrarMensajeConfirmacion("Orden Pendiente agregada correctamente");
            vista.getIdInput().setText("");
            vista.getCantidadInput().setText("");
            actualizarTablas();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarOrden(int idOrden) {
        //Metodo para establecer que una orden paso de estar pendiente a cumplida
        PreparedStatement preparedStatement = null;
        DatabaseConnector connector = new DatabaseConnector();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement()) {
            String sql = "UPDATE ordenes SET Cumplida = true WHERE Id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // Establecer el valor del parámetro
            preparedStatement.setInt(1, idOrden);
            int rowsUpdated = preparedStatement.executeUpdate();

            actualizarTablas();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void obtenerOrdenes() {
        //Metodo para traer ordenes de la base de datos y dividirlas en dos Arrays segun su estado de cumplimiento
        //vaciar arrays existentes
        OrdenProduccion.getOrdenesCumplidas().clear();
        OrdenProduccion.getOrdenesPendientes().clear();

        DatabaseConnector connector = new DatabaseConnector();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement()) {

            String querySQL = "SELECT id, nombre, cantidad, cumplida FROM ORDENES";
            ResultSet resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                int cantidad = resultSet.getInt("cantidad");
                boolean cumplida = resultSet.getBoolean("cumplida");

                if (cumplida == true) {
                    OrdenProduccion.getOrdenesCumplidas().add(new OrdenProduccion(id, nombre, cantidad, cumplida));
                } else {
                    OrdenProduccion.getOrdenesPendientes().add(new OrdenProduccion(id, nombre, cantidad, cumplida));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarCantidadEnBaseDeDatos(MateriaPrima materia) {
        //Metodo conecta con base de datos para actualizar las cantidades de materia prima
        DatabaseConnector connector = new DatabaseConnector();

        String updateSQL = "UPDATE MATERIAPRIMA SET cantidad = ? WHERE nombre = ?";

        try (Connection connection = connector.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(updateSQL)) {

            preparedStatement.setInt(1, materia.getCantidad());
            preparedStatement.setString(2, materia.getNombre());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void comprobarDisponibilidad(String nombre, int cantidad) {
        //Se comprueba disponibilidad de materiaPrima para realizar el producto y se actualizan las ordenes
        Producto productoElegido = Producto.setProducto(nombre);
        //Consultar disponibilidad y actualizar valores en base de datos
        boolean disponibilidad = comprobarMateriaPrima(productoElegido, cantidad);

        DefaultTableModel modeloPendientes = (DefaultTableModel) vista.getTablaPendientes().getModel();
        //SI hay materia prima suficiente:
        if (disponibilidad) {
            vista.mostrarMensajeConfirmacion("Se ha ejecutado la orden y se han actualizado las cantidades disponibles de materia prima");

            int selectedRow = vista.getTablaPendientes().getSelectedRow();
            if (selectedRow != -1) {
                // Obtener datos de la fila seleccionada
                Object id = modeloPendientes.getValueAt(selectedRow, 0);
                //Orden pasa a ser cumplida
                actualizarOrden((int) id);
                //Reiniciar tablas
                actualizarTablas();
            }
        } else {
            vista.mostrarMensajeConfirmacion("No hay materia prima suficiente para realizar esta orden");
        }
    }

    public boolean comprobarMateriaPrima(Producto producto, int cantidad) {
        // Variables para almacenar las materias primas necesarias
        MateriaPrima mp1 = null, mp2 = null, mp3 = null, mp = null;

        // Buscar las materias primas necesarias
        for (MateriaPrima materia : MateriaPrima.getMateriasPrimas()) {
            if (materia.getNombre().equalsIgnoreCase(producto.getIngrediente1())) {
                mp1 = materia;
            } else if (materia.getNombre().equalsIgnoreCase(producto.getIngrediente2())) {
                mp2 = materia;
            } else if (materia.getNombre().equalsIgnoreCase(producto.getIngrediente3())) {
                mp3 = materia;
            }
        }

        // Verificar si todas las materias primas necesarias están disponibles
        if (mp1 != null && mp1.getCantidad() >= producto.getCantidad1()
                && mp2 != null && mp2.getCantidad() >= producto.getCantidad2()
                && mp3 != null && mp3.getCantidad() >= producto.getCantidad3()) {

            // Restar las cantidades utilizadas
            mp1.setCantidad(mp1.getCantidad() - producto.getCantidad1());
            mp2.setCantidad(mp2.getCantidad() - producto.getCantidad2());
            mp3.setCantidad(mp3.getCantidad() - producto.getCantidad3());

            // Actualizar la base de datos
            actualizarCantidadEnBaseDeDatos(mp1);
            actualizarCantidadEnBaseDeDatos(mp2);
            actualizarCantidadEnBaseDeDatos(mp3);

            //Actualizar valores cuando el producto es tambien una materia prima
            if (producto.getNombre().equals("Masa para torta")) {
                mp = MateriaPrima.getMateriasPrimas().get(0);
                mp.setCantidad(mp.getCantidad() + cantidad);
                actualizarCantidadEnBaseDeDatos(mp);
            } else if (producto.getNombre().equals("Relleno Chocolate")) {
                mp = MateriaPrima.getMateriasPrimas().get(1);
                mp.setCantidad(mp.getCantidad() + cantidad);
                actualizarCantidadEnBaseDeDatos(mp);
            }
            return true;
        } else {
            return false;
        }
    }

    public void obtenerMaterias() {
        //Vaciar contenido existente
        MateriaPrima.getMateriasPrimas().clear();
        DatabaseConnector connector = new DatabaseConnector();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement()) {

            String querySQL = "SELECT id, nombre, unidad, cantidad, producto FROM MATERIAPRIMA";
            ResultSet resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String unidad = resultSet.getString("unidad");
                int cantidad = resultSet.getInt("cantidad");
                String producto = resultSet.getString("producto");

                MateriaPrima materia = new MateriaPrima(id, nombre, unidad, cantidad, producto);
                //Completar con nuevo contenido
                MateriaPrima.getMateriasPrimas().add(materia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public void obtenerProductos() {
        DatabaseConnector connector = new DatabaseConnector();
        try (Connection connection = connector.getConnection(); Statement statement = connection.createStatement()) {

            String querySQL = "SELECT id, nombre, ingrediente1, cantidad1, ingrediente2, cantidad2, ingrediente3, cantidad3 FROM PRODUCTOS";
            ResultSet resultSet = statement.executeQuery(querySQL);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String ingrediente1 = resultSet.getString("ingrediente1");
                String ingrediente2 = resultSet.getString("ingrediente2");
                String ingrediente3 = resultSet.getString("ingrediente3");
                int cantidad1 = resultSet.getInt("cantidad1");
                int cantidad2 = resultSet.getInt("cantidad2");
                int cantidad3 = resultSet.getInt("cantidad3");

                Producto producto = new Producto(id, nombre, ingrediente1, cantidad1, ingrediente2, cantidad2, ingrediente3, cantidad3);
                Producto.getProductos().add(producto);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarTablas() {
        DefaultTableModel plantilla = (DefaultTableModel) vista.getTablaMateria().getModel();
        DefaultTableModel modeloCumplidas = (DefaultTableModel) vista.getTablaCumplidas().getModel();
        DefaultTableModel modeloPendientes = (DefaultTableModel) vista.getTablaPendientes().getModel();
        DefaultTableModel modeloMateriaProductos = (DefaultTableModel) vista.getTablaMateriaProducto().getModel();
        

        //vaciar tablas
        plantilla.setRowCount(0);
        modeloPendientes.setRowCount(0);
        modeloCumplidas.setRowCount(0);
        modeloMateriaProductos.setRowCount(0);

        //obtener valores de base de datos
        obtenerMaterias();
        obtenerOrdenes();

        //imprimr informacion
        for (MateriaPrima mp : Modelo.MateriaPrima.getMateriasPrimas()) {
            plantilla.addRow(new Object[]{mp.getNombre(), mp.getUnidad(), mp.getCantidad()});
        }
        
        for (MateriaPrima mp : Modelo.MateriaPrima.getMateriasPrimas()) {
            modeloMateriaProductos.addRow(new Object[]{mp.getNombre(), mp.getProductoMasUsado()});
        }
        
        for (OrdenProduccion op : OrdenProduccion.getOrdenesPendientes()) {
            modeloPendientes.addRow(new Object[]{op.getId(), op.getNombreProducto(), op.getCantidad()});
        }
        for (OrdenProduccion op : OrdenProduccion.getOrdenesCumplidas()) {
            modeloCumplidas.addRow(new Object[]{op.getId(), op.getNombreProducto(), op.getCantidad()});
        }
        System.out.println("tablas actualizadas");
    }

}
