/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Mesero;
import conexion.Conexion;
import exception.PersistenciaException;
import interfaces.IMeseroDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gael
 */
public class MeseroDAO implements IMeseroDAO{
    
    private static MeseroDAO instance;

    private MeseroDAO() {
        
    }

    public static MeseroDAO getInstanceDAO() {
        if (instance == null) {
            instance = new MeseroDAO();
        }
        return instance;
    }
        public Mesero obtenerMeseroPorId(Integer id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Mesero mesero = em.find(Mesero.class, id);
            if (mesero == null) {
                throw new PersistenciaException("No se encontró ningún mesero con ID: " + id);
            }
            return mesero;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar mesero por ID", e);
        } finally {
            em.close();
        }
    }
    
        public Mesero registrarMesero(Mesero mesero) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            em.persist(mesero);
            em.getTransaction().commit();
            return mesero;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar el mesero", e);
        } finally {
            em.close();
        }
    }
        public Mesero actualizarMesero(Mesero mesero) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Mesero actualizado = em.merge(mesero);
            em.getTransaction().commit();
            return actualizado;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar el mesero", e);
        } finally {
            em.close();
        }
    }
        public boolean deshabilitarMesero(Integer id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Mesero mesero = em.find(Mesero.class, id);
        if (mesero == null) {
            throw new PersistenciaException("Mesero no encontrado con ID: " + id);
        }

        
            mesero.setEstado(false);
            em.merge(mesero);

            em.getTransaction().commit();
        return true;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al deshabilitar el mesero", e);
        } finally {
            em.close();
    }
}
    
        public boolean activarMesero(Integer id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin();
            Mesero mesero = em.find(Mesero.class, id);
        if (mesero == null) {
            throw new PersistenciaException("Mesero no encontrado con ID: " + id);
        }

        
            mesero.setEstado(true);
            em.merge(mesero);

            em.getTransaction().commit();
        return true;
         } catch (Exception e) {
        if (em.getTransaction().isActive()) em.getTransaction().rollback();
        throw new PersistenciaException("Error al activar el mesero", e);
        } finally {
        em.close();
    }
}
        
        public List<Mesero> obtenerTodos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Mesero> query = em.createQuery("SELECT m FROM Mesero m", Mesero.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la lista de meseros", e);
        } finally {
            em.close();
        }
    }
        public List<Mesero> obtenerMeserosActivos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Mesero> query = em.createQuery(
                "SELECT m FROM Mesero m WHERE m.estado = true", Mesero.class);
            return query.getResultList();
        } catch (Exception e) {
             throw new PersistenciaException("Error al obtener meseros activos", e);
        } finally {
        em.close();
    }
}

}



