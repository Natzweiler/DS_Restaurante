package Persistencia;

import Entidades.Mesa;
import Entidades.Reservacion;
import conexion.Conexion;
import exception.PersistenciaException;
import interfaces.IReservacionDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ReservacionDAO implements IReservacionDAO {
    private static ReservacionDAO instance;

    private ReservacionDAO() { }

    public static ReservacionDAO getInstanceDAO() {
        if (instance == null) {
            instance = new ReservacionDAO();
        }
        return instance;
    }

    @Override
    public Reservacion registrarReservacion(Reservacion reservacion) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(reservacion);
            em.getTransaction().commit();
            return reservacion;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar la reservación", e);
        } finally {
            em.close();
        }
    }

    @Override
    public boolean cancelarReservacion(int id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Reservacion r = em.find(Reservacion.class, id);
            if (r == null) {
                throw new PersistenciaException("No existe reservación con id=" + id, null);
            }
            em.remove(r);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al cancelar la reservación", e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Reservacion> listarReservaciones() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Reservacion> q = em.createQuery("SELECT r FROM Reservacion r", Reservacion.class);
            return q.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar reservaciones", e);
        } finally {
            em.close();
        }
    }
    public boolean estadoMesaDisponible(Mesa mesa, LocalDate fecha, LocalTime hora) throws PersistenciaException {
    EntityManager em = Conexion.crearConexion();
    try {
        String jpql = "SELECT COUNT(r) FROM Reservacion r WHERE r.mesa = :mesa AND r.fecha = :fecha AND r.hora = :hora";
        Long count = em.createQuery(jpql, Long.class)
            .setParameter("mesa", mesa)
            .setParameter("fecha", fecha)
            .setParameter("hora", hora)
            .getSingleResult();
        return count == 0;
    } catch (Exception e) {
            throw new PersistenciaException("Error al listar reservaciones", e);
        } finally {
            em.close();
        }
    
}

}
