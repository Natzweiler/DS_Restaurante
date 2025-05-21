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

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * La interfaz **IReservacionDAO** define el contrato para las operaciones de acceso a datos (DAO)
 * relacionadas con la entidad {@link Reservacion}.
 *
 * Proporciona métodos para la gestión de reservaciones, incluyendo el registro,
 * cancelación, listado y la verificación de disponibilidad de mesas para nuevas reservaciones.
 *
 * @author Gael
 * @version 1.0
 */
public interface IReservacionDAO {

    /**
     * Registra una nueva {@link Reservacion} en la base de datos.
     *
     * @param reservacion El objeto {@link Reservacion} a ser persistido.
     * @return La {@link Reservacion} registrada, que puede incluir el ID generado por la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de guardar la reservación.
     */
    public Reservacion registrarReservacion(Reservacion reservacion) throws PersistenciaException;

    /**
     * Cancela (elimina) una reservación existente en la base de datos por su identificador único.
     *
     * @param id El identificador único de la reservación a cancelar.
     * @return {@code true} si la reservación fue cancelada exitosamente.
     * @throws PersistenciaException Si la reservación con el ID especificado no existe
     * o si ocurre un error durante la eliminación.
     */
    boolean cancelarReservacion(int id) throws PersistenciaException;

    /**
     * Lista todas las reservaciones existentes en la base de datos.
     *
     * @return Una {@link List} de objetos {@link Reservacion} que representan todas las reservaciones.
     * @throws PersistenciaException Si ocurre un error al intentar obtener la lista de reservaciones.
     */
    List<Reservacion> listarReservaciones() throws PersistenciaException;

    /**
     * Verifica la disponibilidad de una mesa específica para una fecha y hora dadas.
     * Determina si hay alguna reservación ya existente para el número de mesa, fecha y un rango
     * de una hora a partir de la hora de inicio especificada.
     *
     * @param numeroMesa El número de la mesa que se desea verificar.
     * @param fecha La fecha de la reservación.
     * @param hora La hora de inicio de la reservación.
     * @return {@code true} si la mesa está disponible en ese horario (no hay colisiones),
     * {@code false} si ya existe una reservación que se solapa.
     * @throws PersistenciaException Si ocurre un error durante la verificación de disponibilidad.
     */
    public boolean estadoMesaDisponible(Integer numeroMesa, LocalDate fecha, LocalTime hora) throws PersistenciaException;
}
