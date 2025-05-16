/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Entidades.Mesero;
import dtos.MeseroDTO;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public interface IMeseroBO {
    public Mesero obtenerMeseroPorId(Integer id) throws NegocioException ;
    public MeseroDTO registrarMesero(MeseroDTO dto) throws NegocioException;
    public MeseroDTO actualizarMesero(MeseroDTO dto) throws NegocioException;
    public boolean deshabilitarMesero(Integer id) throws NegocioException;
    public boolean activarMesero(Integer id) throws NegocioException;
    public List<MeseroDTO> obtenerTodos() throws NegocioException;
    public List<MeseroDTO> obtenerMeserosActivos() throws NegocioException;

}
