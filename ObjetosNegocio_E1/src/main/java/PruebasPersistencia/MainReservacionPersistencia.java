/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PruebasPersistencia;

import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Mesero;
import Entidades.Reservacion;
import Persistencia.ReservacionDAO;
import conexion.Conexion;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.persistence.EntityManager;

/**
 *
 * @author Gael
 */
public class MainReservacionPersistencia {
    public static void main(String[] args) {
        try {
            EntityManager em = Conexion.crearConexion();

            // Obtenemos una mesa y un mesero existentes
            Mesa mesa = em.find(Mesa.class, 1);
            Mesero mesero = em.find(Mesero.class, 1);

            if (mesa == null || mesero == null) {
                System.out.println("Mesa o mesero no encontrados. Asegúrate de tener registros en la BD.");
                return;
            }
            Cliente cliente = new Cliente();
            cliente.setNombre("Juan Perez");
            cliente.setCorreo("juan@example.com");
            cliente.setTelefono("6441929196");

            // Creamos la reservación
            Reservacion reservacion = new Reservacion();
            reservacion.setMesa(mesa);
            reservacion.setMesero(mesero);
            reservacion.setCliente(cliente);
            reservacion.setFecha(LocalDate.now());
            reservacion.setHora(LocalTime.of(14, 0)); 

            // Guardamos
            ReservacionDAO reservacionDAO = new ReservacionDAO();
            Reservacion resultado = reservacionDAO.registrarReservacion(reservacion);

            System.out.println("Reservación guardada con ID: " + resultado.getId());

        } catch (PersistenciaException e) {
            System.out.println("Error al guardar la reservación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

