
package Interfaces;

import Entidades.Reservacion;
import dtos.ReservacionDTO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import negocio.exception.NegocioException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * La interfaz **IReservacionBO** define el contrato para la lógica de negocio
 * relacionada con la gestión de reservaciones.
 *
 * Especifica las operaciones que deben ser soportadas para manejar
 * la creación, cancelación, listado y verificación de disponibilidad de mesas
 * para las reservaciones.
 *
 * @author Gael
 * @version 1.0
 */
public interface IReservacionBO {

    /**
     * Registra una nueva reservación en el sistema.
     * Incluye validaciones de negocio antes de proceder con la persistencia.
     *
     * @param dto El objeto {@link ReservacionDTO} que contiene los datos de la reservación a registrar.
     * @return El {@link ReservacionDTO} de la reservación registrada, con cualquier ID generado.
     * @throws NegocioException Si los datos de la reservación son inválidos, la mesa no está disponible,
     * o si ocurre un error durante el proceso de registro.
     */
    ReservacionDTO registrarReservacion(ReservacionDTO dto) throws NegocioException;

    /**
     * Cancela una reservación existente por su identificador único.
     *
     * @param id El ID de la reservación a cancelar.
     * @return {@code true} si la reservación fue cancelada exitosamente.
     * @throws NegocioException Si no se encuentra la reservación o si ocurre un error durante la cancelación.
     */
    boolean cancelarReservacion(int id) throws NegocioException;

    /**
     * Lista todas las reservaciones existentes en el sistema.
     *
     * @return Una {@link List} de objetos {@link ReservacionDTO} que representan todas las reservaciones.
     * @throws NegocioException Si ocurre un error al obtener la lista de reservaciones.
     */
    List<ReservacionDTO> listarReservaciones() throws NegocioException;

    /**
     * Verifica la disponibilidad de una mesa específica para una fecha y hora dadas.
     * Considera si la mesa ya está reservada en el rango de tiempo especificado.
     *
     * @param numeroMesa El número de la mesa que se desea verificar.
     * @param fecha La fecha para la cual se desea verificar la disponibilidad.
     * @param hora La hora de inicio para la cual se desea verificar la disponibilidad.
     * @return {@code true} si la mesa está disponible en ese horario, {@code false} en caso contrario.
     * @throws NegocioException Si la mesa no existe o si ocurre un error durante la verificación.
     */
    public boolean estadoMesaDisponible(Integer numeroMesa, LocalDate fecha, LocalTime hora) throws NegocioException;
}

