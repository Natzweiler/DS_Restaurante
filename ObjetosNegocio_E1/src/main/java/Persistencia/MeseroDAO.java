/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Mesero;
import conexion.Conexion;
import exception.PersistenciaException;
import interfaces.IMeseroDAO;
import javax.persistence.EntityManager;

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
}


