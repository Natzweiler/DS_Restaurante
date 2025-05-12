/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entidades.Mesa;
import Interfaces.IMesaBO;
import Mappers.MesaMapper;
import Persistencia.MesaDAO;
import dtos.MesaDTO;
import exception.PersistenciaException;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public class MesaBO implements IMesaBO {

    private final MesaDAO mesaDAO;

    public MesaBO() {
        this.mesaDAO = MesaDAO.getInstanceDAO();
    }

    
    public MesaDTO obtenerMesaPorNumeroMesa(Integer idMesa) throws NegocioException {
        try {
            Mesa mesa = mesaDAO.obtenerMesaPorNumeroMesa(idMesa);
            return MesaMapper.toDTO(mesa);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al obtener la mesa: " + e.getMessage(), e);
        }
    }
}
