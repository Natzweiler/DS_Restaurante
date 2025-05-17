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
import java.util.ArrayList;
import java.util.List;
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
        public int generarMesasIniciales() throws NegocioException {
        try {
            int contador = 0;
            for (int i = 1; i <= 7; i++) {
                Mesa mesa = new Mesa();
                mesa.setNumeroMesa(i);
                mesa.setCapacidadMesa(4); // o lo que necesites
                mesa.setDisponible(true);
                mesaDAO.registrarMesa(mesa);
                contador++;
            }
            return contador;
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al generar mesas iniciales", e);
        }
    }
    public List<MesaDTO> obtenerTodasLasMesas() throws NegocioException {
             try {
             List<Mesa> mesas = mesaDAO.obtenerTodasLasMesas();
             List<MesaDTO> dtoList = new ArrayList<>();
                 for (Mesa mesa : mesas) {
                  dtoList.add(MesaMapper.toDTO(mesa));
             }
             return dtoList;
    } catch (PersistenciaException e) {
        throw new NegocioException("Error al obtener las mesas", e);
    }
}

}

