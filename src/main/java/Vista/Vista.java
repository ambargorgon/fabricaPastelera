package Vista;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Ambar
 */
public class Vista extends javax.swing.JFrame {
    public Vista() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        idInput = new javax.swing.JTextField();
        productoInput = new javax.swing.JComboBox<>();
        cantidadInput = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        panelPendientes = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablaPendientes = new javax.swing.JTable();
        ejecutarBtn = new javax.swing.JButton();
        panelCumplidas = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaCumplidas = new javax.swing.JTable();
        panelMaterias = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaMateria = new javax.swing.JTable();
        panelMaterias1 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablaMateriaProducto = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        jList2.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(jList2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("ID");

        jLabel2.setText("Producto");

        jLabel3.setText("Cantidad");

        btnAgregar.setText("Agregar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel2))
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(68, 68, 68)
                                .addComponent(cantidadInput, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(225, 225, 225)
                        .addComponent(btnAgregar)))
                .addContainerGap(258, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(productoInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cantidadInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnAgregar)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Agregar Orden", jPanel1);

        tablaPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane6.setViewportView(tablaPendientes);
        if (tablaPendientes.getColumnModel().getColumnCount() > 0) {
            tablaPendientes.getColumnModel().getColumn(0).setHeaderValue("ID");
        }

        ejecutarBtn.setText("Ejecutar ");
        ejecutarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPendientesLayout = new javax.swing.GroupLayout(panelPendientes);
        panelPendientes.setLayout(panelPendientesLayout);
        panelPendientesLayout.setHorizontalGroup(
            panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPendientesLayout.createSequentialGroup()
                .addContainerGap(96, Short.MAX_VALUE)
                .addGroup(panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPendientesLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPendientesLayout.createSequentialGroup()
                        .addComponent(ejecutarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(252, 252, 252))))
        );
        panelPendientesLayout.setVerticalGroup(
            panelPendientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPendientesLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ejecutarBtn)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ordenes Pendientes", panelPendientes);

        tablaCumplidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Producto", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tablaCumplidas);

        javax.swing.GroupLayout panelCumplidasLayout = new javax.swing.GroupLayout(panelCumplidas);
        panelCumplidas.setLayout(panelCumplidasLayout);
        panelCumplidasLayout.setHorizontalGroup(
            panelCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCumplidasLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102))
        );
        panelCumplidasLayout.setVerticalGroup(
            panelCumplidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCumplidasLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ordenes Cumplidas", panelCumplidas);

        tablaMateria.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Unidad", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tablaMateria);

        javax.swing.GroupLayout panelMateriasLayout = new javax.swing.GroupLayout(panelMaterias);
        panelMaterias.setLayout(panelMateriasLayout);
        panelMateriasLayout.setHorizontalGroup(
            panelMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMateriasLayout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        panelMateriasLayout.setVerticalGroup(
            panelMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMateriasLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Materias Primas", panelMaterias);

        tablaMateriaProducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Materia Prima", "Producto"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(tablaMateriaProducto);

        jLabel4.setText("Listado de materias primas junto al ");

        jLabel5.setText("principal producto que las consume");

        javax.swing.GroupLayout panelMaterias1Layout = new javax.swing.GroupLayout(panelMaterias1);
        panelMaterias1.setLayout(panelMaterias1Layout);
        panelMaterias1Layout.setHorizontalGroup(
            panelMaterias1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMaterias1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelMaterias1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(186, 186, 186))
            .addGroup(panelMaterias1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );
        panelMaterias1Layout.setVerticalGroup(
            panelMaterias1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMaterias1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Materia-Producto", panelMaterias1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ejecutarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ejecutarBtnActionPerformed

    public JTable getTablaMateriaProducto() {
        return tablaMateriaProducto;
    }

    public void setTablaMateriaProducto(JTable tablaMateriaProducto) {
        this.tablaMateriaProducto = tablaMateriaProducto;
    }

    public void agregarListenerBotonEjecutar(ActionListener listener) {
        ejecutarBtn.addActionListener(listener);
    }
    
     public void mostrarMensajeConfirmacion(String mensaje) {
         JOptionPane.showMessageDialog(jPanel1, mensaje, "Confirmación", JOptionPane.INFORMATION_MESSAGE);
    }
    
     public void agregarListenerBotonAgregar(ActionListener listener) {
        btnAgregar.addActionListener(listener);
    }
     
     
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public JTextField getCantidadInput() {
        return cantidadInput;
    }

    public void setCantidadInput(JTextField cantidadInput) {
        this.cantidadInput = cantidadInput;
    }

    public JTextField getIdInput() {
        return idInput;
    }

    public void setIdInput(JTextField idInput) {
        this.idInput = idInput;
    }

    public JComboBox<String> getProductoInput() {
        return productoInput;
    }

    public void setProductoInput(JComboBox<String> productoInput) {
        this.productoInput = productoInput;
    }

 
    public JButton getEjecutarBtn() {
        return ejecutarBtn;
    }

    public void setEjecutarBtn(JButton ejecutarBtn) {
        this.ejecutarBtn = ejecutarBtn;
    }
    
    public JTable getTablaCumplidas() {
        return tablaCumplidas;
    }

    public void setTablaCumplidas(JTable tablaCumplidas) {
        this.tablaCumplidas = tablaCumplidas;
    }

    public JTable getTablaMateria() {
        return tablaMateria;
    }

    public void setTablaMateria(JTable tablaMateria) {
        this.tablaMateria = tablaMateria;
    }

    public JTable getTablaPendientes() {
        return tablaPendientes;
    }

    public void setTablaPendientes(JTable tablaPendientes) {
        this.tablaPendientes = tablaPendientes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JTextField cantidadInput;
    private javax.swing.JButton ejecutarBtn;
    private javax.swing.JTextField idInput;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelCumplidas;
    private javax.swing.JPanel panelMaterias;
    private javax.swing.JPanel panelMaterias1;
    private javax.swing.JPanel panelPendientes;
    private javax.swing.JComboBox<String> productoInput;
    private javax.swing.JTable tablaCumplidas;
    private javax.swing.JTable tablaMateria;
    private javax.swing.JTable tablaMateriaProducto;
    private javax.swing.JTable tablaPendientes;
    // End of variables declaration//GEN-END:variables
}
