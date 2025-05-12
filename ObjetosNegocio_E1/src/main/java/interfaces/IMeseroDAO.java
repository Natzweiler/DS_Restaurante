/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Mesero;
import exception.PersistenciaException;

/**
 *
 * @author Gael
 */
public interface IMeseroDAO {
    public Mesero obtenerMeseroPorId(Integer id) throws PersistenciaException ;

}
