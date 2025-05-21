/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GenerarReportes;


import BO.ReservacionBO;
import Entidades.Reservacion;
import Interfaces.IReservacionBO;
import Persistencia.ReservacionDAO;
import com.itextpdf.text.BaseColor;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import com.itextpdf.text.Element;
import dtos.ReservacionDTO;
import exception.PersistenciaException;
import interfaces.IReservacionDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import negocio.exception.NegocioException;

/**
 * La clase **ReporteReservaciones** representa la interfaz gráfica de usuario (GUI)
 * para visualizar y generar reportes de las reservaciones existentes en el sistema.
 * Permite cargar todas las reservaciones en una tabla y filtrar por número de mesa,
 * además de ofrecer la funcionalidad de generar un reporte en formato PDF.
 *
 * Extiende de {@code javax.swing.JFrame}, lo que la convierte en una ventana de aplicación.
 *
 * @author Gael
 * @version 1.0
 */
public class ReporteReservaciones extends javax.swing.JFrame {
   
    /**
     * Creates new form ReporteClientesFrecuentes
     */
        /**
     * Constructor que inicializa la ventana y configura los componentes de la interfaz.
     * Inicializa los objetos de coordinación y los listeners para los campos de búsqueda.
     */
    public ReporteReservaciones() {
        initComponents();
        cargarTabla(); // Carga los datos iniciales al abrir la ventana

        // Configura el ActionListener para el botón de filtrar por número de mesa
        // Se asume que 'btnFiltrar' es el nombre del botón en tu diseño GUI
        btnFiltrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filtrarPorNumeroMesa();
            }
        });
        
        // Configura el ActionListener para el botón de generar PDF
        // Se asume que 'btnGenerarPDF' es el nombre del botón en tu diseño GUI
        btnGenerarPDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });
    }

    /**
     * Filtra las reservaciones mostradas en la tabla basándose en el número de mesa
     * ingresado por el usuario. Si el campo de filtro está vacío, se asume
     * que se desea ver todas las reservaciones (aunque este método solo filtra).
     *
     * Captura {@link NumberFormatException} si el texto no es un número válido
     * y {@link PersistenciaException} si hay un error al acceder a los datos.
     */
    private void filtrarPorNumeroMesa() {
        try {
            String textoFiltro = txtFiltroMesa.getText().trim();
            
            // Si el campo de filtro está vacío, recargar la tabla completa
            if (textoFiltro.isEmpty()) {
                cargarTabla();
                return; 
            }

            int numeroMesa = Integer.parseInt(textoFiltro);

            // Obtener todas las reservaciones de la capa DAO (o BO para mayor consistencia)
            List<Reservacion> reservaciones = ReservacionDAO.getInstanceDAO().listarReservaciones();

            // Limpiar la tabla antes de añadir los resultados filtrados
            DefaultTableModel modelo = (DefaultTableModel) tablaMostrarReservaciones.getModel();
            modelo.setRowCount(0); 

            // Iterar y añadir solo las reservaciones que coincidan con el número de mesa
            for (Reservacion r : reservaciones) {
                if (r.getMesa().getNumeroMesa() == numeroMesa) {
                    modelo.addRow(new Object[]{
                        "Mesa " + r.getMesa().getNumeroMesa(),
                        r.getCliente().getNombre(),
                        r.getMesero().getNombre(),
                        r.getFecha().toString()
                    });
                }
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa un número de mesa válido.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(this, "Error al filtrar las reservaciones: " + e.getMessage(), "Error de Persistencia", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Carga todas las reservaciones desde la capa de persistencia y las muestra
     * en la tabla de la interfaz gráfica.
     * Limpia la tabla antes de cargar nuevos datos.
     *
     * Captura {@link PersistenciaException} si hay un error al acceder a los datos.
     */
    private void cargarTabla() {
        try {
            // Se utiliza el DAO directamente para la carga simple de datos.
            // Para una aplicación más robusta, se podría usar el BO aquí también.
            List<Reservacion> reservaciones = ReservacionDAO.getInstanceDAO().listarReservaciones(); 
            
            DefaultTableModel modelo = (DefaultTableModel) tablaMostrarReservaciones.getModel();
            modelo.setRowCount(0); // Limpiar la tabla antes de cargar nuevos datos

            // Llenar la tabla con los datos de las reservaciones
            for (Reservacion r : reservaciones) {
                modelo.addRow(new Object[]{
                    "Mesa " + r.getMesa().getNumeroMesa(),
                    r.getCliente().getNombre(),
                    r.getMesero().getNombre(),
                    r.getFecha().toString()
                });
            }

        } catch (PersistenciaException e) {
            JOptionPane.showMessageDialog(this, "Error al cargar las reservaciones: " + e.getMessage(), "Error de Carga", JOptionPane.ERROR_MESSAGE);
        }
    }
        /**
     * Método que agrega listeners a los campos de texto para realizar la búsqueda en tiempo real.
     */

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        txtFiltroMesa = new javax.swing.JTextField();
        tabla = new javax.swing.JScrollPane();
        tablaMostrarReservaciones = new javax.swing.JTable();
        btnRegresar = new javax.swing.JButton();
        btnGenerarPDF = new javax.swing.JButton();
        btnFiltrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titulo.setText("Reporte de Reservaciones");

        nombreLabel.setText("Filtrar por mesa:");

        tablaMostrarReservaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mesa", "Cliente", "Mesero que atendió", "Fecha de reservacion"
            }
        ));
        tabla.setViewportView(tablaMostrarReservaciones);

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        btnGenerarPDF.setText("Generar PDF");
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });

        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(nombreLabel)
                                .addGap(177, 463, Short.MAX_VALUE))
                            .addComponent(tabla, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtFiltroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnFiltrar))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(184, 184, 184)
                                        .addComponent(titulo)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGenerarPDF)
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo)
                .addGap(0, 0, 0)
                .addComponent(nombreLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltroMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addGap(6, 6, 6)
                .addComponent(tabla, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar)
                    .addComponent(btnGenerarPDF))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
      /**
     * Método que maneja el evento del 
        /**
     * Clase interna que define el numerador de páginas para el reporte en PDF.
     * Extiende `PdfPageEventHelper` para insertar el número de página en el pie de página de cada página del PDF.
     */
    public class NumeradorPaginas extends PdfPageEventHelper {
    private Font fuente = FontFactory.getFont(FontFactory.HELVETICA, 9, Font.NORMAL, BaseColor.GRAY);

    @Override
    public void onEndPage(PdfWriter writer, Document document) {
        PdfContentByte cb = writer.getDirectContent();
        Phrase pie = new Phrase("Página " + writer.getPageNumber(), fuente);
        ColumnText.showTextAligned(cb, Element.ALIGN_CENTER,
                pie,
                (document.right() - document.left()) / 2 + document.leftMargin(),
                document.bottom() - 10, 0);
    }
}

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        Coordinador.CoordinadorPantallas.getInstance().mostrarMenuReportes();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed
        /**
     * Manejador del evento para el botón "Generar PDF".
     * Crea un documento PDF con la información de todas las reservaciones.
     * Incluye un título, fecha de generación y una tabla con los detalles de las reservaciones.
     * La lógica para la numeración de páginas (clase `NumeradorPaginas`) se asume existente.
     *
     * @param evt El evento de acción.
     */
    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
            Document documento = new Document();
    
    try {
        String ruta = System.getProperty("user.home");
        PdfWriter writer = PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/ReporteReservaciones.pdf"));
        writer.setPageEvent(new NumeradorPaginas()); 
        documento.open();

       
        Paragraph titulo = new Paragraph("REPORTE DE RESERVACIONES\n\n");
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);

        
        String fechaActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
        Paragraph fecha = new Paragraph("Fecha de generación: " + fechaActual);
        fecha.setAlignment(Element.ALIGN_RIGHT);
        documento.add(fecha);
        documento.add(new Paragraph("\n"));

       
        PdfPTable tabla = new PdfPTable(4);
        tabla.setWidthPercentage(100);
        tabla.addCell("Fecha");
        tabla.addCell("Mesa");
        tabla.addCell("Cliente");
        tabla.addCell("Mesero");

        IReservacionDAO dao = ReservacionDAO.getInstanceDAO();
        IReservacionBO reservacionBO = new ReservacionBO(dao);
        List<ReservacionDTO> listaReservaciones = reservacionBO.listarReservaciones();

        for (ReservacionDTO r : listaReservaciones) {
            tabla.addCell("Mesa " + r.getMesa().getNumeroMesa());
            tabla.addCell(r.getCliente().getNombre());
            tabla.addCell(r.getMesero().getNombre());
            tabla.addCell(r.getFecha().toString());

        }

        documento.add(tabla);
        documento.close();
        JOptionPane.showMessageDialog(this, "PDF generado con éxito en el escritorio.");
        
    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al generar el PDF: " + e.getMessage());
    }
    }//GEN-LAST:event_btnGenerarPDFActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnFiltrarActionPerformed

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
            java.util.logging.Logger.getLogger(ReporteReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReporteReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReporteReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReporteReservaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReporteReservaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JScrollPane tabla;
    private javax.swing.JTable tablaMostrarReservaciones;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField txtFiltroMesa;
    // End of variables declaration//GEN-END:variables
}
