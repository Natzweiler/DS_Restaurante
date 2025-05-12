/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Mesa;
import conexion.Conexion;
import exception.PersistenciaException;
import interfaces.IMesaDAO;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gael
 */
public class MesaDAO implements IMesaDAO{

    private static MesaDAO instance;

    private MesaDAO() {
        
    }

    public static MesaDAO getInstanceDAO() {
        if (instance == null) {
            instance = new MesaDAO();
        }
        return instance;
    }
    public Mesa obtenerMesaPorNumeroMesa(Integer numeroMesa) throws PersistenciaException {
    EntityManager em = Conexion.crearConexion();
    try {
        TypedQuery<Mesa> query = em.createQuery(
            "SELECT m FROM Mesa m WHERE m.numeroMesa = :numero", Mesa.class);
        query.setParameter("numero", numeroMesa);
        Mesa mesa = query.getSingleResult();

        return mesa;
    } catch (NoResultException e) {
        throw new PersistenciaException("No se encontró la mesa con número: " + numeroMesa);
    } catch (Exception e) {
        throw new PersistenciaException("Error al recuperar la mesa con número: " + numeroMesa, e);
    } finally {
        em.close();
    }
}
}

