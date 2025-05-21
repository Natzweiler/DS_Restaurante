/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entidades.Cliente;
import Entidades.Mesa;
import Entidades.Mesero;
import Entidades.Reservacion;
import Interfaces.IReservacionBO;
import Mappers.ReservacionMapper;
import Persistencia.MesaDAO;
import Persistencia.MeseroDAO;
import Persistencia.ReservacionDAO;
import dtos.ReservacionDTO;
import exception.PersistenciaException;
import interfaces.IMeseroDAO;
import interfaces.IReservacionDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;
import negocio.exception.NegocioException;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * La clase **ReservacionBO** (Business Object) implementa la interfaz {@link IReservacionBO}
 * y maneja la lógica de negocio relacionada con las reservaciones.
 * Es responsable de validar los datos de las reservaciones, coordinar con las capas de persistencia
 * de reservaciones, mesas y meseros, y transformar las entidades a DTOs para la capa de presentación.
 *
 * @author Gael
 * @version 1.0
 */
public class ReservacionBO implements IReservacionBO {

    /**
     * Instancia del DAO de reservaciones para interactuar con la capa de persistencia.
     */
    private IReservacionDAO reservacionDAO;
    
    /**
     * Instancia del DAO de meseros para interactuar con la capa de persistencia.
     */
    private IMeseroDAO meseroDAO;
    
    /**
     * Instancia del DAO de mesas para interactuar con la capa de persistencia (obtenida directamente).
     */
    private MesaDAO mesaDAO; // Declaración de MesaDAO

    /**
     * Constructor de la clase ReservacionBO.
     * Inicializa las instancias de los DAOs necesarios para la gestión de reservaciones.
     *
     * @param reservacionDAO La instancia del DAO de reservaciones a utilizar (normalmente, se inyectaría {@link ReservacionDAO#getInstanceDAO()}).
     */
    public ReservacionBO(IReservacionDAO reservacionDAO) {
        // Se fuerza la instancia Singleton del DAO concreto.
        this.reservacionDAO = ReservacionDAO.getInstanceDAO();
        this.meseroDAO = MeseroDAO.getInstanceDAO();
        this.mesaDAO = MesaDAO.getInstanceDAO(); // Inicialización de MesaDAO
    }

    /**
     * Registra una nueva reservación en el sistema.
     * Realiza validaciones de los datos del {@link ReservacionDTO}, como la información del cliente
     * y la disponibilidad de la mesa. Recupera las entidades gestionadas de mesa y mesero antes de persistir la reservación.
     *
     * @param dto El {@link ReservacionDTO} que contiene los datos de la reservación a registrar.
     * @return El {@link ReservacionDTO} de la reservación registrada, incluyendo su ID si fue generado.
     * @throws NegocioException Si los datos del DTO son inválidos, la mesa no está disponible,
     * o si ocurre un error en la persistencia.
     */
    @Override
    public ReservacionDTO registrarReservacion(ReservacionDTO dto) throws NegocioException {
        try {
            // Validaciones de datos del cliente
            if (dto.getCliente() == null) {
                throw new NegocioException("Los datos del cliente son obligatorios.");
            }
            if (dto.getCliente().getNombre() == null || dto.getCliente().getNombre().trim().isEmpty()) {
                throw new NegocioException("El nombre del cliente no puede estar vacío.");
            }
            if (dto.getCliente().getCorreo() == null || dto.getCliente().getCorreo().trim().isEmpty()) {
                throw new NegocioException("El correo del cliente no puede estar vacío.");
            }
            if (dto.getCliente().getTelefono() == null || dto.getCliente().getTelefono().trim().isEmpty()) {
                throw new NegocioException("El teléfono del cliente no puede estar vacío.");
            }

            // Validar si la mesa está disponible (Aunque ya tienes un método específico para esto,
            // esta validación rápida puede ser útil para la UI)
            if (dto.getMesa() == null || !dto.getMesa().isDisponible()) {
                throw new NegocioException("La mesa seleccionada no es válida o ya está ocupada.");
            }
            
            // Validar la disponibilidad de la mesa con el método de negocio específico
            if (!estadoMesaDisponible(dto.getMesa().getNumeroMesa(), dto.getFecha(), dto.getHora())) {
                throw new NegocioException("La mesa ya está reservada para esa fecha y hora.");
            }

            // Conversión de DTO a entidad de Reservacion
            Reservacion reservacion = ReservacionMapper.toEntity(dto);

            // Recuperar entidades gestionadas (Mesero y Mesa) desde la BD para asociarlas a la reservación
            // Esto es crucial para que JPA maneje correctamente las relaciones.
            Mesero meseroRecuperado = meseroDAO.obtenerMeseroPorId(dto.getMesero().getId());
            Mesa mesaRecuperada = mesaDAO.obtenerMesaPorNumeroMesa(dto.getMesa().getNumeroMesa());

            // Asignar las entidades gestionadas a la reservación
            reservacion.setMesero(meseroRecuperado);
            reservacion.setMesa(mesaRecuperada);

            // Persistir la reservación
            Reservacion nuevaReservacion = reservacionDAO.registrarReservacion(reservacion);

            return ReservacionMapper.toDTO(nuevaReservacion); // Retorna el DTO de la reservación registrada

        } catch (NegocioException ne) {
            // Si la excepción es de NegocioException, se relanza directamente
            throw ne;
        } catch (PersistenciaException pe) {
            // Las excepciones de persistencia se envuelven en NegocioException
            throw new NegocioException("Error en la capa de persistencia al registrar la reservación: " + pe.getMessage(), pe);
        } catch (Exception e) {
            // Captura cualquier otra excepción inesperada
            throw new NegocioException("Ocurrió un error inesperado al registrar la reservación: " + e.getMessage(), e);
        }
    }

    /**
     * Cancela una reservación existente por su identificador único.
     * Delega la operación a la capa de persistencia.
     *
     * @param id El ID de la reservación a cancelar.
     * @return {@code true} si la reservación fue cancelada exitosamente.
     * @throws NegocioException Si no se pudo cancelar la reservación debido a un error de persistencia.
     */
    @Override
    public boolean cancelarReservacion(int id) throws NegocioException {
        try {
            return reservacionDAO.cancelarReservacion(id);
        } catch (PersistenciaException pe) {
            throw new NegocioException("No se pudo cancelar la reservación: " + pe.getMessage(), pe);
        }
    }

    /**
     * Lista todas las reservaciones existentes en el sistema.
     * Convierte la lista de entidades {@link Reservacion} obtenida del DAO a una lista de {@link ReservacionDTO}s.
     *
     * @return Una {@link List} de objetos {@link ReservacionDTO}.
     * @throws NegocioException Si ocurre un error al listar las reservaciones.
     */
    @Override
    public List<ReservacionDTO> listarReservaciones() throws NegocioException {
        try {
            return reservacionDAO.listarReservaciones()
                .stream()
                .map(ReservacionMapper::toDTO) // Convierte cada entidad a DTO usando Stream API
                .collect(Collectors.toList());
        } catch (PersistenciaException pe) {
            throw new NegocioException("Error al listar reservaciones: " + pe.getMessage(), pe);
        }
    }

    /**
     * Verifica la disponibilidad de una mesa específica para una fecha y hora dadas.
     * Este método también valida la existencia de la mesa antes de verificar su disponibilidad
     * en la capa de persistencia.
     *
     * @param numeroMesa El número de la mesa que se desea verificar.
     * @param fecha La fecha de la potencial reservación.
     * @param hora La hora de inicio de la potencial reservación.
     * @return {@code true} si la mesa está disponible en ese horario (no hay colisiones),
     * {@code false} si ya existe una reservación que se solapa.
     * @throws NegocioException Si la mesa no existe o si ocurre un error durante la verificación de disponibilidad.
     */
    @Override
    public boolean estadoMesaDisponible(Integer numeroMesa, LocalDate fecha, LocalTime hora) throws NegocioException {
        try {
            // Primero, se verifica si la mesa existe en la base de datos
            Mesa mesa = mesaDAO.obtenerMesaPorNumeroMesa(numeroMesa);
            if (mesa == null) {
                throw new NegocioException("La mesa con número " + numeroMesa + " no existe.");
            }

            // Luego, se delega la verificación de disponibilidad al DAO de reservaciones
            return reservacionDAO.estadoMesaDisponible(numeroMesa, fecha, hora);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error al verificar disponibilidad de la mesa: " + e.getMessage(), e);
        }
    }
}