/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Reservacion;
import conexion.Conexion;
import exception.PersistenciaException;
import interfaces.IReservacionDAO;
import javax.persistence.EntityManager;

/**
 *
 * @author Gael
 */
public class ReservacionDAO implements IReservacionDAO {
   private static ReservacionDAO instance;

    private ReservacionDAO() {
      
    }

    public static ReservacionDAO getInstanceDAO() {
        if (instance == null) {
            instance = new ReservacionDAO();
        }
        return instance;
    }

    public Reservacion registrarReservacion(Reservacion reservacion) throws PersistenciaException {
    EntityManager em = Conexion.crearConexion();
    try {
        em.getTransaction().begin();
        em.persist(reservacion);
        em.getTransaction().commit();
        return reservacion;
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        throw new PersistenciaException("Error al guardar la reservación", e);
    } finally {
        em.close();
    }
}
}
