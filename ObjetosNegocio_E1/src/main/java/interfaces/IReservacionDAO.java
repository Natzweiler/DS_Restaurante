/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Mesa;
import Entidades.Reservacion;
import exception.PersistenciaException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author Gael
 */
public interface IReservacionDAO {
    
    
    public Reservacion registrarReservacion(Reservacion reservacion) throws PersistenciaException;
    boolean cancelarReservacion(int id) throws PersistenciaException; //Para cancelar
     List<Reservacion> listarReservaciones() throws PersistenciaException;//para listar todas o activas
    //public boolean estadoMesaDisponible(Mesa mesa, LocalDate fecha, LocalTime hora) throws PersistenciaException;
    public boolean estadoMesaDisponible(Integer numeroMesa, LocalDate fecha, LocalTime hora) throws PersistenciaException;


}
