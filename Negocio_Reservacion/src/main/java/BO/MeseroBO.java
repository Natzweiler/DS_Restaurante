/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entidades.Mesero;
import Interfaces.IMeseroBO;
import Persistencia.MeseroDAO;
import exception.PersistenciaException;
import interfaces.IMeseroDAO;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public class MeseroBO implements IMeseroBO {

    private IMeseroDAO meseroDAO;

    public MeseroBO(IMeseroDAO meseroDAO) {
        this.meseroDAO = MeseroDAO.getInstanceDAO();
    }

    public Mesero obtenerMeseroPorId(Integer id) throws NegocioException {
        try {
            return meseroDAO.obtenerMeseroPorId(id);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener el mesero con ID: " + id, e);
        }
    }
}

