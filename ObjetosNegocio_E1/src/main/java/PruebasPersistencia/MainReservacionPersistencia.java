/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package PruebasPersistencia;

import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Mesero;
import Entidades.Reservacion;
import Persistencia.MesaDAO;
import Persistencia.MeseroDAO;
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
    public static void main(String[] args) throws PersistenciaException {
        MeseroDAO meseroDAO = MeseroDAO.getInstanceDAO();
        MesaDAO mesaDAO = MesaDAO.getInstanceDAO();
        Mesa mesa1 = mesaDAO.obtenerMesaPorNumeroMesa(1);
        Mesero mesero1 = meseroDAO.obtenerMeseroPorId(1);
        System.out.println("Mesero:" +mesero1.getNombre() + mesa1.getNumeroMesa() + mesa1.getCapacidadMesa());
    }
}

