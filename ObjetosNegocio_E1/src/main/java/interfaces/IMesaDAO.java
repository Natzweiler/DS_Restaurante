/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Mesa;
import exception.PersistenciaException;

/**
 *
 * @author Gael
 */
public interface IMesaDAO {
        public Mesa obtenerMesaPorNumeroMesa(Integer numeroMesa) throws PersistenciaException ;

}
