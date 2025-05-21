/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 * La clase **MesaDTO** (Data Transfer Object) se utiliza para transferir
 * datos de una mesa entre las capas de la aplicación.
 * Contiene información relevante sobre una mesa, como su número, capacidad
 * y estado de disponibilidad.
 *
 * @author Gael
 * @version 1.0
 */
public class MesaDTO {
    
    /**
     * El número único que identifica a la mesa.
     */
    private int numeroMesa;
    
    /**
     * La capacidad máxima de personas que puede albergar la mesa.
     */
    private int capacidadMesa;
    
    /**
     * Indica si la mesa está disponible (true) o no (false).
     */
    private boolean disponible;

    /**
     * Constructor por defecto de la clase MesaDTO.
     * Inicializa un nuevo objeto MesaDTO sin valores predefinidos.
     */
    public MesaDTO() {
    }

    /**
     * Constructor de la clase MesaDTO que permite inicializar todas las propiedades.
     *
     * @param numeroMesa El número de la mesa.
     * @param capacidadMesa La capacidad de la mesa (número de asientos).
     * @param disponible El estado de disponibilidad de la mesa (true si está disponible, false si está ocupada).
     */
    public MesaDTO(int numeroMesa, int capacidadMesa, boolean disponible) {
        this.numeroMesa = numeroMesa;
        this.capacidadMesa = capacidadMesa;
        this.disponible = disponible;
    }

    /**
     * Verifica si la mesa está disponible.
     *
     * @return {@code true} si la mesa está disponible, {@code false} en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Establece el estado de disponibilidad de la mesa.
     *
     * @param disponible El nuevo estado de disponibilidad (true para disponible, false para ocupada).
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Obtiene el número de la mesa.
     *
     * @return Un entero que representa el número de la mesa.
     */
    public int getNumeroMesa() {
        return numeroMesa;
    }

    /**
     * Establece el número de la mesa.
     *
     * @param numeroMesa El nuevo número de la mesa.
     */
    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    /**
     * Obtiene la capacidad de la mesa.
     *
     * @return Un entero que representa la capacidad de la mesa (número de asientos).
     */
    public int getCapacidadMesa() {
        return capacidadMesa;
    }

    /**
     * Establece la capacidad de la mesa.
     *
     * @param capacidadMesa La nueva capacidad de la mesa (número de asientos).
     */
    public void setCapacidadMesa(int capacidadMesa) {
        this.capacidadMesa = capacidadMesa;
    }

    /**
     * Retorna una representación en cadena de texto del objeto MesaDTO.
     * Esta representación incluye el número de la mesa y su capacidad.
     *
     * @return Una cadena formateada con los datos de la mesa.
     */
    @Override
    public String toString() {
        return "MesaDTO{" + "numeroMesa=" + numeroMesa + ", capacidadMesa=" + capacidadMesa + ", disponible=" + disponible + '}';
    }
}
