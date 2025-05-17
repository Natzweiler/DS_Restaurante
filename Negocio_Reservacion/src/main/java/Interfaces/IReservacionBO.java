
package Interfaces;

import Entidades.Reservacion;
import dtos.ReservacionDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public interface IReservacionBO {
    ReservacionDTO registrarReservacion(ReservacionDTO dto) throws NegocioException;
    boolean cancelarReservacion(int id) throws NegocioException;
    List<ReservacionDTO> listarReservaciones() throws NegocioException;
    public boolean estadoMesaDisponible(Integer numeroMesa, LocalDate fecha, LocalTime hora) throws NegocioException;

}
