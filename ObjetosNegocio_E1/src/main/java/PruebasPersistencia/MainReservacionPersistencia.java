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
        Mesero mesero1 = new Mesero();
        mesero1.setNombre("Julio Urias");
        mesero1.setEstado(true);
        mesero1.setTelefono("6441929196");
        mesero1.setFechaNacimiento(LocalDate.of(1990, 3, 15));
        meseroDAO.registrarMesero(mesero1);
        System.out.println("Mesero Registrado Con Exito." + mesero1.getNombre());
        
        
    }
}

