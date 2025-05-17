/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Mesa;
import exception.PersistenciaException;
import java.util.List;

/**
 *
 * @author Gael
 */
public interface IMesaDAO {
        public Mesa obtenerMesaPorNumeroMesa(Integer numeroMesa) throws PersistenciaException ;
        public Mesa registrarMesa(Mesa mesa) throws PersistenciaException ;
        public List<Mesa> obtenerTodasLasMesas() throws PersistenciaException;
        public boolean actualizarDisponibilidadMesa(int numeroMesa, boolean disponible) throws PersistenciaException;
        



}
