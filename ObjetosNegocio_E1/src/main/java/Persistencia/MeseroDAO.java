/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Entidades.Mesero;
import conexion.Conexion;
import exception.PersistenciaException;
import interfaces.IMeseroDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;


/**
 * La clase **MeseroDAO** implementa la interfaz {@link IMeseroDAO} y proporciona
 * métodos para interactuar con la base de datos para la gestión de objetos
 * {@link Mesero}. Sigue el patrón **Singleton** para asegurar una única instancia
 * de la clase en toda la aplicación, facilitando la gestión de recursos y la consistencia
 * en las operaciones de acceso a datos de los meseros.
 *
 * Esta clase maneja las operaciones de persistencia como la obtención,
 * registro, actualización, habilitación y deshabilitación de meseros.
 *
 * @author Gael
 * @version 1.0
 */
public class MeseroDAO implements IMeseroDAO {
    
    /**
     * Instancia única de la clase MeseroDAO (patrón Singleton).
     */
    private static MeseroDAO instance;

    /**
     * Constructor privado de la clase MeseroDAO.
     * Impide la creación de múltiples instancias de la clase desde el exterior,
     * forzando el uso del método estático {@code getInstanceDAO()} para obtener la única instancia.
     */
    private MeseroDAO() {
        // Constructor vacío intencionalmente para el patrón Singleton
    }

    /**
     * Obtiene la única instancia de la clase MeseroDAO.
     * Si la instancia no ha sido creada previamente, la inicializa.
     * Este método garantiza que solo exista un punto de acceso a las operaciones DAO de meseros.
     *
     * @return La instancia única de MeseroDAO.
     */
    public static MeseroDAO getInstanceDAO() {
        if (instance == null) {
            instance = new MeseroDAO();
        }
        return instance;
    }
    
    /**
     * Recupera un objeto {@link Mesero} de la base de datos utilizando su identificador único.
     *
     * @param id El ID del mesero a buscar.
     * @return El objeto {@link Mesero} encontrado.
     * @throws PersistenciaException Si no se encuentra un mesero con el ID proporcionado
     * o si ocurre un error durante la búsqueda.
     */
    @Override
    public Mesero obtenerMeseroPorId(Integer id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            Mesero mesero = em.find(Mesero.class, id); // Utiliza find para buscar por PK.
            if (mesero == null) {
                throw new PersistenciaException("No se encontró ningún mesero con ID: " + id);
            }
            return mesero;
        } catch (Exception e) {
            throw new PersistenciaException("Error al buscar mesero por ID: " + e.getMessage(), e);
        } finally {
            em.close(); // Asegura que el EntityManager se cierre.
        }
    }
    
    /**
     * Registra un nuevo objeto {@link Mesero} en la base de datos.
     * Inicia una transacción, persiste el objeto y luego confirma la transacción.
     *
     * @param mesero El objeto {@link Mesero} a registrar.
     * @return El objeto {@link Mesero} persistido (puede incluir ID generado).
     * @throws PersistenciaException Si ocurre un error durante la operación de registro.
     */
    @Override
    public Mesero registrarMesero(Mesero mesero) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin(); // Inicia la transacción.
            em.persist(mesero);          // Persiste el objeto Mesero.
            em.getTransaction().commit();  // Confirma la transacción.
            return mesero;
        } catch (Exception e) {
            // Si la transacción está activa y ocurre un error, se realiza un rollback.
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al registrar el mesero: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }
    
    /**
     * Actualiza la información de un objeto {@link Mesero} existente en la base de datos.
     * Inicia una transacción, fusiona los cambios del objeto y luego confirma la transacción.
     *
     * @param mesero El objeto {@link Mesero} con la información actualizada.
     * @return El objeto {@link Mesero} actualizado después de la fusión.
     * @throws PersistenciaException Si ocurre un error durante la operación de actualización.
     */
    @Override
    public Mesero actualizarMesero(Mesero mesero) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin(); // Inicia la transacción.
            Mesero actualizado = em.merge(mesero); // Fusiona el estado del objeto.
            em.getTransaction().commit();  // Confirma la transacción.
            return actualizado;
        } catch (Exception e) {
            // Si la transacción está activa y ocurre un error, se realiza un rollback.
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al actualizar el mesero: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }
    
    /**
     * Deshabilita un mesero cambiando su estado a inactivo ({@code false}) en la base de datos.
     * Se busca el mesero por su ID, se actualiza su estado y se persisten los cambios.
     *
     * @param id El ID del mesero a deshabilitar.
     * @return {@code true} si el mesero fue deshabilitado exitosamente.
     * @throws PersistenciaException Si el mesero no se encuentra o si ocurre un error durante la operación.
     */
    @Override
    public boolean deshabilitarMesero(Integer id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin(); // Inicia la transacción.
            Mesero mesero = em.find(Mesero.class, id); // Busca el mesero por ID.
            if (mesero == null) {
                throw new PersistenciaException("Mesero no encontrado con ID: " + id);
            }
            
            mesero.setEstado(false); // Cambia el estado a inactivo.
            em.merge(mesero);        // Sincroniza los cambios con la base de datos.

            em.getTransaction().commit(); // Confirma la transacción.
            return true;
        } catch (Exception e) {
            // Si la transacción está activa y ocurre un error, se realiza un rollback.
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al deshabilitar el mesero: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }
    
    /**
     * Habilita un mesero cambiando su estado a activo ({@code true}) en la base de datos.
     * Se busca el mesero por su ID, se actualiza su estado y se persisten los cambios.
     *
     * @param id El ID del mesero a activar.
     * @return {@code true} si el mesero fue habilitado exitosamente.
     * @throws PersistenciaException Si el mesero no se encuentra o si ocurre un error durante la operación.
     */
    @Override
    public boolean activarMesero(Integer id) throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            em.getTransaction().begin(); // Inicia la transacción.
            Mesero mesero = em.find(Mesero.class, id); // Busca el mesero por ID.
            if (mesero == null) {
                throw new PersistenciaException("Mesero no encontrado con ID: " + id);
            }
            
            mesero.setEstado(true);  // Cambia el estado a activo.
            em.merge(mesero);        // Sincroniza los cambios con la base de datos.

            em.getTransaction().commit(); // Confirma la transacción.
            return true;
        } catch (Exception e) {
            // Si la transacción está activa y ocurre un error, se realiza un rollback.
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new PersistenciaException("Error al activar el mesero: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }
    
    /**
     * Obtiene una lista de todos los objetos {@link Mesero} registrados en la base de datos,
     * sin importar su estado (activo o inactivo).
     *
     * @return Una {@link List} de todos los objetos {@link Mesero}.
     * @throws PersistenciaException Si ocurre un error al obtener la lista de meseros.
     */
    @Override
    public List<Mesero> obtenerTodos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Mesero> query = em.createQuery("SELECT m FROM Mesero m", Mesero.class);
            return query.getResultList(); // Retorna todos los resultados de la consulta.
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener la lista de meseros: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }
    
    /**
     * Obtiene una lista de todos los objetos {@link Mesero} que están actualmente activos
     * (es decir, con el atributo `estado` en {@code true}) en la base de datos.
     *
     * @return Una {@link List} de objetos {@link Mesero} activos.
     * @throws PersistenciaException Si ocurre un error al obtener la lista de meseros activos.
     */
    @Override
    public List<Mesero> obtenerMeserosActivos() throws PersistenciaException {
        EntityManager em = Conexion.crearConexion();
        try {
            TypedQuery<Mesero> query = em.createQuery(
                "SELECT m FROM Mesero m WHERE m.estado = true", Mesero.class);
            return query.getResultList(); // Retorna los meseros con estado activo.
        } catch (Exception e) {
            throw new PersistenciaException("Error al obtener meseros activos: " + e.getMessage(), e);
        } finally {
            em.close(); // Cierra el EntityManager.
        }
    }
}



