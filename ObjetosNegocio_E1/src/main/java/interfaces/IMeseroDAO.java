/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Mesero;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Gael
 */
public interface IMeseroDAO {
    public Mesero obtenerMeseroPorId(Integer id) throws PersistenciaException ;
    public Mesero registrarMesero(Mesero mesero) throws PersistenciaException;
    public Mesero actualizarMesero(Mesero mesero) throws PersistenciaException;
    public boolean deshabilitarMesero(Integer id) throws PersistenciaException;
    public boolean activarMesero(Integer id) throws PersistenciaException;
    public List<Mesero> obtenerTodos() throws PersistenciaException;
    public List<Mesero> obtenerMeserosActivos() throws PersistenciaException;

        
}
