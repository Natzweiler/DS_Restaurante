/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Mesa;
import conexion.Conexion;
import exception.PersistenciaException;
import interfaces.IMesaDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * La clase **MesaDAO** implementa la interfaz {@link IMesaDAO} y proporciona
 * métodos para interactuar con la base de datos para la gestión de objetos
 * {@link Mesa}. Sigue el patrón Singleton para asegurar una única instancia
 * de la clase en la aplicación.
 *
 * Esta clase maneja las operaciones de persistencia como la obtención,
 * registro y actualización de mesas.
 *
 * @author Gael
 * @version 1.0
 */
public class MesaDAO implements IMesaDAO {

    /**
     * Instancia única de la clase MesaDAO (patrón Singleton).
     */
    private static MesaDAO instance;

    /**
     * Constructor privado de la clase MesaDAO.
     * Impide la creación de múltiples instancias de la clase desde el exterior,
     * forzando el uso del patrón Singleton a través del método {@code getInstanceDAO()}.
     */
    private MesaDAO() {
        // Constructor vacío intencionalmente para el patrón Singleton
    }

    /**
     * Obtiene la única instancia de la clase MesaDAO.
     * Si la instancia no ha sido creada, la inicializa.
     *
     * @return La instancia única de MesaDAO.
     */
    public static MesaDAO getInstanceDAO() {
        if (instance == null) {
            instance = new MesaDAO();
        }
        return instance;
    }

    /**
     * Recupera una {@link Mesa} de la base de datos utilizando su número de mesa.
     *
     * @param numeroMesa El número de la mesa a buscar.
     * @return El objeto {@link Mesa} encontrado.
     * @throws PersistenciaException Si la mesa no se encuentra o si ocurre un error durante la recuperación.
     */
    @Override
    public Mesa obtenerMesaPorNumeroMesa(Integer numeroMesa) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Mesa> query = em.createQuery(
                "SELECT m FROM Mesa m WHERE m.numeroMesa = :numero", Mesa.class);
            query.setParameter("numero", numeroMesa);
            Mesa mesa = query.getSingleResult();
            return mesa;
        } catch (NoResultException e) {
            // Se lanza cuando no se encuentra ninguna entidad que coincida con la consulta.
            throw new PersistenciaException("No se encontró la mesa con número: " + numeroMesa, e);
        } catch (Exception e) {
            // Captura cualquier otra excepción que pueda ocurrir durante la operación.
            throw new PersistenciaException("Error al recuperar la mesa con número: " + numeroMesa, e);
        } finally {
            // Asegura que el EntityManager se cierre en cualquier caso.
            em.close();
        }
    }

    /**
     * Registra una nueva {@link Mesa} en la base de datos.
     * Este método es útil para la inserción masiva de mesas, como para pruebas iniciales.
     *
     * @param mesa El objeto {@link Mesa} a registrar.
     * @return El objeto {@link Mesa} registrado (puede incluir el ID generado por la base de datos).
     * @throws PersistenciaException Si ocurre un error durante el proceso de registro.
     */
    @Override
    public Mesa registrarMesa(Mesa mesa) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin(); // Inicia una transacción.
            em.persist(mesa);           // Persiste el objeto Mesa en la base de datos.
            em.getTransaction().commit(); // Confirma la transacción.
            return mesa;
        } catch (Exception e) {
            // Si la transacción está activa y ocurre un error, se realiza un rollback.
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar la mesa", e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }

    /**
     * Obtiene una lista de todas las {@link Mesa}s disponibles en la base de datos.
     *
     * @return Una {@link List} de objetos {@link Mesa}.
     * @throws PersistenciaException Si ocurre un error al intentar obtener las mesas.
     */
    @Override
    public List<Mesa> obtenerTodasLasMesas() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Mesa> query = em.createQuery("SELECT m FROM Mesa m", Mesa.class);
            return query.getResultList(); // Retorna todos los resultados de la consulta.
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener todas las mesas", e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }

    /**
     * Actualiza el estado de disponibilidad de una {@link Mesa} específica en la base de datos.
     *
     * @param numeroMesa El número de la mesa cuya disponibilidad se desea actualizar.
     * @param disponible El nuevo estado de disponibilidad (true para disponible, false para ocupada).
     * @return {@code true} si la actualización fue exitosa, {@code false} en caso contrario.
     * @throws PersistenciaException Si ocurre un error durante la actualización de la disponibilidad.
     */
    @Override
    public boolean actualizarDisponibilidadMesa(int numeroMesa, boolean disponible) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin(); // Inicia una transacción.
            // Busca la mesa por su número.
            Mesa mesa = (Mesa) em.createQuery("SELECT m FROM Mesa m WHERE m.numeroMesa = :numero")
                                 .setParameter("numero", numeroMesa)
                                 .getSingleResult();
            mesa.setDisponible(disponible); // Actualiza el estado de disponibilidad.
            em.merge(mesa);                // Sincroniza los cambios con la base de datos.
            em.getTransaction().commit();  // Confirma la transacción.
            return true;
        } catch (Exception e) {
            // Si la transacción está activa y ocurre un error, se realiza un rollback.
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar la disponibilidad de la mesa", e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }
}
