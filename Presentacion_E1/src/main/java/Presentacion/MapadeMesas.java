/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import controlReservacion.GestorReservacion;
import dtos.MesaDTO;
import java.awt.Color;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import objetosnegocio.MesaON;
import objetosnegocio.ReservacionON;

/**
 *
 * @author Gael
 */
public class MapadeMesas extends javax.swing.JFrame {
    private static MapadeMesas instancia;
   private GestorReservacion negocioReservacion;
   
   private MesaDTO mesaSeleccionada;
   
   public MesaDTO getMesaSeleccionada() {
    return mesaSeleccionada;
}
    public static MapadeMesas getInstance() {
        if (instancia == null) {
            instancia = new MapadeMesas();
        }
        return instancia;
    }
   
    
    /**
     * Creates new form MapadeMesas
     */
    public MapadeMesas() {
        initComponents();
        negocioReservacion = new GestorReservacion();
        cargarMesasDisponibles();
        for (int i = 2; i <= 31; i++) {
            cbDia.addItem(String.valueOf(i));
        }
        for (int hora = 9; hora <= 21; hora++) {
            String horaFormateada = String.format("%02d:00", hora);
            cbHora.addItem(horaFormateada);
        }
  }
    public void actualizarEstadoMesas() {
    List<MesaDTO> mesas = new ArrayList<>(MesaON.getInstance().cargarMesas());
    if (mesas != null && mesas.size() >= 7) {
        configurarMesa(mesa1, MesaON.getInstance().obtenerMesa(1));
        configurarMesa(mesa2, MesaON.getInstance().obtenerMesa(2));
        configurarMesa(mesa3, MesaON.getInstance().obtenerMesa(3));
        configurarMesa(mesa4, MesaON.getInstance().obtenerMesa(4));
        configurarMesa(mesa5, MesaON.getInstance().obtenerMesa(5));
        configurarMesa(mesa6, MesaON.getInstance().obtenerMesa(6));
        configurarMesa(mesa7, MesaON.getInstance().obtenerMesa(7));
    }
}
    public void mostrarMesasDisponibles(LocalDate fecha, LocalTime hora){
    List<MesaDTO> todasMesas = new ArrayList<>(MesaON.getInstance().cargarMesas());
    ReservacionON reservacionON = ReservacionON.getInstance();
        for (MesaDTO mesa : todasMesas) {
            boolean disponible = reservacionON.MesaDisponibleDiaHora(mesa, fecha, hora);
            mesa.setDisponible(disponible);
        }
        actualizarEstadoMesas();
        cargarMesasDisponibles();
    }
    private void cargarMesasDisponibles() {
    List<MesaDTO> mesas = new ArrayList<>(MesaON.getInstance().cargarMesas());
    if (mesas != null && mesas.size() >= 7) {
        configurarMesa(mesa1, MesaON.getInstance().obtenerMesa(1));
        configurarMesa(mesa2, MesaON.getInstance().obtenerMesa(2));
        configurarMesa(mesa3, MesaON.getInstance().obtenerMesa(3));
        configurarMesa(mesa4, MesaON.getInstance().obtenerMesa(4));
        configurarMesa(mesa5, MesaON.getInstance().obtenerMesa(5));
        configurarMesa(mesa6, MesaON.getInstance().obtenerMesa(6));
        configurarMesa(mesa7, MesaON.getInstance().obtenerMesa(7));
    }

        
        
}
    private void abrirRegistrarReservacion(MesaDTO mesa) {
    RegistrarReservacion registrarReservacion = new RegistrarReservacion();
    registrarReservacion.setMesaSeleccionada(mesa);
    registrarReservacion.setLocationRelativeTo(null);
    registrarReservacion.setVisible(true); 
    this.dispose();
}
        
    private void configurarMesa(JButton mesaBtn, MesaDTO mesa) {
    mesaBtn.setText("Mesa " + mesa.getNumeroMesa());
    if (mesa.isDisponible()) {
        mesaBtn.setBackground(Color.GREEN);  
        mesaBtn.setEnabled(true);
    } else {
        mesaBtn.setBackground(Color.RED);  
        mesaBtn.setEnabled(false);
    }

    mesaBtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        MesaDTO mesaActualizada = MesaON.getInstance().obtenerMesa(mesa.getNumeroMesa()); 
        if (mesaActualizada.isDisponible()) {
            mesaSeleccionada = mesaActualizada;
            JOptionPane.showMessageDialog(MapadeMesas.this, "Mesa " + mesaActualizada.getNumeroMesa() + " seleccionada.");
            
            
            int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
            int mes = cbMes.getSelectedIndex() + 1; 
            int año = Integer.parseInt(cbAño.getSelectedItem().toString());
            
            String horaSeleccionadasrt = cbHora.getSelectedItem().toString();
            String horaNum = horaSeleccionadasrt.split(":")[0];
            int horaSeleccionada = Integer.parseInt(horaNum);
            
            
            LocalDate fechaSeleccionada = LocalDate.of(año, mes, dia);
            LocalTime hora = LocalTime.of(horaSeleccionada, 0); 

            
            RegistrarReservacion registrarReservacion = new RegistrarReservacion();
            registrarReservacion.setMesaSeleccionada(mesaActualizada);
            registrarReservacion.setFechaHoraSeleccionada(fechaSeleccionada, hora); 
            registrarReservacion.setLocationRelativeTo(null); 
            registrarReservacion.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(MapadeMesas.this, "La mesa " + mesaActualizada.getNumeroMesa() + " está ocupada.");
        }
    }
});

}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        mesa2 = new javax.swing.JButton();
        mesa3 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        mesa4 = new javax.swing.JButton();
        mesa5 = new javax.swing.JButton();
        mesa6 = new javax.swing.JButton();
        mesa7 = new javax.swing.JButton();
        mesa1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbHora = new javax.swing.JComboBox<>();
        cbDia = new javax.swing.JComboBox<>();
        cbMes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbAño = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        mesa2.setText("Mesa 2");

        mesa3.setText("Mesa 3");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(mesa2)
                        .addGap(282, 282, 282))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(mesa3)
                        .addGap(39, 39, 39))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(218, Short.MAX_VALUE)
                .addComponent(mesa2)
                .addGap(3, 3, 3)
                .addComponent(mesa3)
                .addContainerGap())
        );

        btnRegresar.setBackground(new java.awt.Color(204, 255, 204));
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        mesa4.setText("Mesa 4");

        mesa5.setText("Mesa 5");

        mesa6.setText("Mesa 6");

        mesa7.setText("Mesa 7");

        mesa1.setText("Mesa 1");
        mesa1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mesa1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Seleccione la hora:");

        jLabel2.setText("Seleccione la fecha:");

        cbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00" }));
        cbHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbHoraActionPerformed(evt);
            }
        });

        cbDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1" }));
        cbDia.setToolTipText("Mes");

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE" }));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Mapa de Mesas");

        cbAño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2025", "2026" }));
        cbAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAñoActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mesa7)
                .addGap(275, 275, 275))
            .addGroup(layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(mesa4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mesa6)
                .addGap(122, 122, 122))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(mesa1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(284, 284, 284)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnRegresar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBuscar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(mesa5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(mesa1)
                                .addGap(21, 21, 21))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(btnBuscar)
                                .addGap(164, 164, 164)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)))))
                .addComponent(mesa7)
                .addGap(20, 20, 20)
                .addComponent(mesa5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(mesa4)
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(mesa6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnRegresar)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Coordinador.CoordinadorPantallas.getInstance().mostrarMenu();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void mesa1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mesa1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mesa1ActionPerformed

    private void cbHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbHoraActionPerformed

    private void cbAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbAñoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        int dia = Integer.parseInt(cbDia.getSelectedItem().toString());
        int mes = cbMes.getSelectedIndex()+1;
        int año = Integer.parseInt(cbAño.getSelectedItem().toString());
        String horaSeleccionada = (String) cbHora.getSelectedItem();
        
        if (horaSeleccionada == null) {
            JOptionPane.showMessageDialog(this, "Selecciona una hora.");
            return;
        }
        LocalDate fecha = LocalDate.of(año, mes, dia);
        LocalTime hora = LocalTime.parse(horaSeleccionada);
        mostrarMesasDisponibles(fecha, hora);
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MapadeMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapadeMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapadeMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapadeMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapadeMesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cbAño;
    private javax.swing.JComboBox<String> cbDia;
    private javax.swing.JComboBox<String> cbHora;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton mesa1;
    private javax.swing.JButton mesa2;
    private javax.swing.JButton mesa3;
    private javax.swing.JButton mesa4;
    private javax.swing.JButton mesa5;
    private javax.swing.JButton mesa6;
    private javax.swing.JButton mesa7;
    // End of variables declaration//GEN-END:variables
}
