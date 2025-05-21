/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Mesa;
import exception.PersistenciaException;
import java.util.List;
import java.util.List;

/**
 * La interfaz **IMesaDAO** define el contrato para las operaciones de acceso a datos (DAO)
 * relacionadas con la entidad {@link Mesa}.
 *
 * Proporciona métodos para realizar operaciones CRUD (Crear, Leer, Actualizar, Borrar)
 * específicas para la gestión de mesas, así como consultas para obtener listas de mesas
 * y actualizar su disponibilidad.
 *
 * @author Gael
 * @version 1.0
 */
public interface IMesaDAO {

    /**
     * Obtiene un objeto {@link Mesa} de la base de datos basándose en su número de mesa.
     *
     * @param numeroMesa El número de la mesa a buscar.
     * @return El objeto {@link Mesa} que coincide con el número proporcionado.
     * @throws PersistenciaException Si la mesa no se encuentra o si ocurre un error en la capa de persistencia.
     */
    public Mesa obtenerMesaPorNumeroMesa(Integer numeroMesa) throws PersistenciaException;

    /**
     * Registra una nueva {@link Mesa} en la base de datos.
     *
     * @param mesa El objeto {@link Mesa} a ser persistido.
     * @return La {@link Mesa} registrada, que puede incluir el ID generado por la base de datos.
     * @throws PersistenciaException Si ocurre un error durante el proceso de registro de la mesa.
     */
    public Mesa registrarMesa(Mesa mesa) throws PersistenciaException;

    /**
     * Obtiene una lista de todas las {@link Mesa}s disponibles en la base de datos.
     *
     * @return Una {@link List} de objetos {@link Mesa}.
     * @throws PersistenciaException Si ocurre un error al intentar obtener todas las mesas.
     */
    public List<Mesa> obtenerTodasLasMesas() throws PersistenciaException;

    /**
     * Actualiza el estado de disponibilidad de una {@link Mesa} específica en la base de datos.
     *
     * @param numeroMesa El número de la mesa cuya disponibilidad se desea actualizar.
     * @param disponible El nuevo estado de disponibilidad ({@code true} para disponible, {@code false} para ocupada).
     * @return {@code true} si la actualización fue exitosa, {@code false} en caso contrario.
     * @throws PersistenciaException Si ocurre un error durante la actualización de la disponibilidad de la mesa.
     */
    public boolean actualizarDisponibilidadMesa(int numeroMesa, boolean disponible) throws PersistenciaException;
}