package Persistencia;

import Entidades.Mesa;
import Entidades.Reservacion;
import conexion.Conexion;
import exception.PersistenciaException;
import interfaces.IReservacionDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


/**
 * La clase **ReservacionDAO** implementa la interfaz {@link IReservacionDAO} y proporciona
 * métodos para la interacción con la base de datos, manejando las operaciones
 * de persistencia relacionadas con las entidades {@link Reservacion}.
 * Sigue el patrón **Singleton** para garantizar una única instancia de la clase
 * en la aplicación, optimizando la gestión de recursos y la consistencia del acceso a datos.
 *
 * Incluye funcionalidades para registrar, cancelar y listar reservaciones,
 * así como para verificar la disponibilidad de mesas en un horario específico.
 *
 * @author Gael
 * @version 1.0
 */
public class ReservacionDAO implements IReservacionDAO {

    /**
     * Instancia única de la clase ReservacionDAO (patrón Singleton).
     */
    private static ReservacionDAO instance;

    /**
     * Constructor privado de la clase ReservacionDAO.
     * Impide la instanciación directa de la clase desde el exterior,
     * asegurando que la única forma de obtener una instancia sea a través
     * del método estático {@link #getInstanceDAO()}.
     */
    private ReservacionDAO() {
        // Constructor vacío intencionalmente para el patrón Singleton
    }

    /**
     * Obtiene la única instancia de la clase ReservacionDAO.
     * Si la instancia no ha sido creada previamente, la inicializa.
     *
     * @return La instancia única de ReservacionDAO.
     */
    public static ReservacionDAO getInstanceDAO() {
        if (instance == null) {
            instance = new ReservacionDAO();
        }
        return instance;
    }

    /**
     * Registra una nueva {@link Reservacion} en la base de datos.
     * La operación se realiza dentro de una transacción para asegurar la atomicidad.
     *
     * @param reservacion El objeto {@link Reservacion} a persistir.
     * @return El objeto {@link Reservacion} una vez ha sido persistido (puede incluir ID generado).
     * @throws PersistenciaException Si ocurre un error durante el proceso de guardar la reservación.
     */
    @Override
    public Reservacion registrarReservacion(Reservacion reservacion) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin(); // Inicia la transacción
            em.persist(reservacion);     // Persiste el objeto Reservacion
            em.getTransaction().commit(); // Confirma la transacción
            return reservacion;
        } catch (Exception e) {
            // Si la transacción está activa y falla, se revierte
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al guardar la reservación: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }

    /**
     * Cancela una reservación existente en la base de datos, eliminándola por su ID.
     *
     * @param id El identificador único de la reservación a cancelar.
     * @return {@code true} si la reservación fue cancelada exitosamente.
     * @throws PersistenciaException Si la reservación con el ID especificado no existe,
     * o si ocurre un error durante la eliminación.
     */
    @Override
    public boolean cancelarReservacion(int id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin(); // Inicia la transacción
            Reservacion r = em.find(Reservacion.class, id); // Busca la reservación por ID
            if (r == null) {
                // Lanza una excepción si la reservación no se encuentra
                throw new PersistenciaException("No existe reservación con id=" + id, null);
            }
            em.remove(r); // Elimina la reservación
            em.getTransaction().commit(); // Confirma la transacción
            return true;
        } catch (Exception e) {
            // Si la transacción está activa y falla, se revierte
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al cancelar la reservación: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }

    /**
     * Lista todas las reservaciones existentes en la base de datos.
     *
     * @return Una {@link List} de objetos {@link Reservacion} que representan todas las reservaciones.
     * @throws PersistenciaException Si ocurre un error al intentar obtener la lista de reservaciones.
     */
    @Override
    public List<Reservacion> listarReservaciones() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Reservacion> q = em.createQuery("SELECT r FROM Reservacion r", Reservacion.class);
            return q.getResultList(); // Retorna la lista de resultados
        } catch (Exception e) {
            throw new PersistenciaException("Error al listar reservaciones: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }

    /**
     * Verifica la disponibilidad de una mesa específica para una fecha y hora dadas.
     * Determina si hay alguna reservación ya existente para el número de mesa, fecha y un rango
     * de una hora a partir de la hora de inicio especificada.
     *
     * @param numeroMesa El número de la mesa que se desea verificar.
     * @param fecha La fecha de la reservación.
     * @param hora La hora de inicio de la reservación.
     * @return {@code true} si la mesa está disponible en ese horario (no hay colisiones),
     * {@code false} si ya existe una reservación para ese rango.
     * @throws PersistenciaException Si ocurre un error durante la verificación de disponibilidad.
     */
    public boolean estadoMesaDisponible(Integer numeroMesa, LocalDate fecha, LocalTime hora) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            // Consulta JPQL para contar las reservaciones que se solapan con el horario dado
            String consulta = "SELECT COUNT(r) FROM Reservacion r WHERE r.mesa.numeroMesa = :numeroMesa " +
                              "AND r.fecha = :fecha " +
                              "AND r.hora BETWEEN :inicio AND :fin";

            Long count = em.createQuery(consulta, Long.class)
                .setParameter("numeroMesa", numeroMesa)
                .setParameter("fecha", fecha)
                .setParameter("inicio", hora)
                .setParameter("fin", hora.plusHours(1)) // Se verifica un rango de 1 hora
                .getSingleResult();

            return count == 0; // Si el conteo es 0, la mesa está disponible
        } catch (Exception e) {
            throw new PersistenciaException("Error al verificar disponibilidad de la mesa: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager
        }
    }
}