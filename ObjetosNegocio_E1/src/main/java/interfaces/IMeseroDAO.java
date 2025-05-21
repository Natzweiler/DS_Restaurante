/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Mesero;
import exception.PersistenciaException;
import java.util.List;
import java.util.List;

/**
 * La interfaz **IMeseroDAO** define el contrato para las operaciones de acceso a datos (DAO)
 * relacionadas con la entidad {@link Mesero}.
 *
 * Proporciona métodos para realizar operaciones CRUD y consultas específicas para la gestión
 * de meseros, incluyendo la posibilidad de habilitar y deshabilitar meseros, y obtener
 * listas de meseros por su estado.
 *
 * @author Gael
 * @version 1.0
 */
public interface IMeseroDAO {

    /**
     * Obtiene un objeto {@link Mesero} de la base de datos basándose en su identificador único.
     *
     * @param id El ID del mesero a buscar.
     * @return El objeto {@link Mesero} que coincide con el ID proporcionado.
     * @throws PersistenciaException Si no se encuentra un mesero con el ID o si ocurre un error en la persistencia.
     */
    public Mesero obtenerMeseroPorId(Integer id) throws PersistenciaException;

    /**
     * Registra un nuevo objeto {@link Mesero} en la base de datos.
     *
     * @param mesero El objeto {@link Mesero} a ser persistido.
     * @return El {@link Mesero} registrado, que puede incluir el ID generado por la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el registro del mesero.
     */
    public Mesero registrarMesero(Mesero mesero) throws PersistenciaException;

    /**
     * Actualiza la información de un objeto {@link Mesero} existente en la base de datos.
     *
     * @param mesero El objeto {@link Mesero} con los datos actualizados.
     * @return El {@link Mesero} actualizado después de la operación.
     * @throws PersistenciaException Si ocurre un error durante la actualización del mesero.
     */
    public Mesero actualizarMesero(Mesero mesero) throws PersistenciaException;

    /**
     * Deshabilita un mesero cambiando su estado a inactivo en la base de datos.
     *
     * @param id El ID del mesero a deshabilitar.
     * @return {@code true} si el mesero fue deshabilitado exitosamente.
     * @throws PersistenciaException Si el mesero no se encuentra o si ocurre un error durante la operación.
     */
    public boolean deshabilitarMesero(Integer id) throws PersistenciaException;

    /**
     * Habilita un mesero cambiando su estado a activo en la base de datos.
     *
     * @param id El ID del mesero a habilitar.
     * @return {@code true} si el mesero fue habilitado exitosamente.
     * @throws PersistenciaException Si el mesero no se encuentra o si ocurre un error durante la operación.
     */
    public boolean activarMesero(Integer id) throws PersistenciaException;

    /**
     * Obtiene una lista de todos los objetos {@link Mesero} registrados en la base de datos,
     * sin importar su estado (activo o inactivo).
     *
     * @return Una {@link List} de todos los objetos {@link Mesero}.
     * @throws PersistenciaException Si ocurre un error al obtener la lista de meseros.
     */
    public List<Mesero> obtenerTodos() throws PersistenciaException;

    /**
     * Obtiene una lista de todos los objetos {@link Mesero} que están actualmente activos
     * en la base de datos.
     *
     * @return Una {@link List} de objetos {@link Mesero} activos.
     * @throws PersistenciaException Si ocurre un error al obtener la lista de meseros activos.
     */
    public List<Mesero> obtenerMeserosActivos() throws PersistenciaException;
}