/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

import java.time.LocalDate;
import java.time.LocalTime;


import java.time.LocalDate;
import java.time.LocalTime;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * La clase **ReservacionDTO** (Data Transfer Object) se encarga de transferir
 * la información de una reservación entre las distintas capas de la aplicación.
 * Contiene todos los detalles necesarios para una reservación, incluyendo
 * la mesa asignada, el cliente, la fecha, la hora, el mesero responsable y un identificador único.
 *
 * @author Gael
 * @version 1.0
 */
public class ReservacionDTO {

    /**
     * El objeto {@link MesaDTO} que representa la mesa asignada a esta reservación.
     */
    private MesaDTO mesa;

    /**
     * El objeto {@link ClienteDTO} que representa al cliente que realizó la reservación.
     */
    private ClienteDTO cliente;

    /**
     * La dirección de correo electrónico del cliente para la confirmación o comunicación.
     */
    private String correo;

    /**
     * La fecha en que se realizará la reservación.
     */
    private LocalDate fecha;

    /**
     * El objeto {@link MeseroDTO} que representa al mesero asignado para atender esta reservación.
     */
    private MeseroDTO mesero;

    /**
     * La hora específica en que está programada la reservación.
     */
    private LocalTime hora;

    /**
     * El identificador único de la reservación.
     */
    private int id;

    /**
     * Constructor por defecto de la clase ReservacionDTO.
     * Permite crear una instancia de ReservacionDTO sin inicializar sus atributos.
     */
    public ReservacionDTO() {
    }

    /**
     * Constructor completo de la clase ReservacionDTO que inicializa todos los atributos de la reservación.
     *
     * @param id El identificador único de la reservación.
     * @param mesa El objeto MesaDTO asociado a la reservación.
     * @param cliente El objeto ClienteDTO asociado a la reservación.
     * @param correo La dirección de correo electrónico del cliente.
     * @param fecha La fecha de la reservación.
     * @param mesero El objeto MeseroDTO asignado a la reservación.
     * @param hora La hora de la reservación.
     */
    public ReservacionDTO(int id, MesaDTO mesa, ClienteDTO cliente, String correo, LocalDate fecha, MeseroDTO mesero, LocalTime hora) {
        this.mesa = mesa;
        this.cliente = cliente;
        this.correo = correo;
        this.fecha = fecha;
        this.mesero = mesero;
        this.hora = hora;
        this.id = id;
    }

    /**
     * Obtiene el objeto {@link MesaDTO} de la reservación.
     *
     * @return El objeto MesaDTO que representa la mesa de la reservación.
     */
    public MesaDTO getMesa() {
        return mesa;
    }

    /**
     * Establece el objeto {@link MesaDTO} para la reservación.
     *
     * @param mesa El nuevo objeto MesaDTO a asignar a la reservación.
     */
    public void setMesa(MesaDTO mesa) {
        this.mesa = mesa;
    }

    /**
     * Obtiene el objeto {@link ClienteDTO} de la reservación.
     *
     * @return El objeto ClienteDTO que representa al cliente de la reservación.
     */
    public ClienteDTO getCliente() {
        return cliente;
    }

    /**
     * Establece el objeto {@link ClienteDTO} para la reservación.
     *
     * @param cliente El nuevo objeto ClienteDTO a asignar a la reservación.
     */
    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la dirección de correo electrónico del cliente de la reservación.
     *
     * @return Una cadena de texto con la dirección de correo electrónico.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece la dirección de correo electrónico para la reservación.
     *
     * @param correo La nueva dirección de correo electrónico.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Obtiene la fecha de la reservación.
     *
     * @return Un objeto {@link LocalDate} que representa la fecha de la reservación.
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de la reservación.
     *
     * @param fecha La nueva fecha de la reservación.
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el objeto {@link MeseroDTO} asignado a la reservación.
     *
     * @return El objeto MeseroDTO que representa al mesero de la reservación.
     */
    public MeseroDTO getMesero() {
        return mesero;
    }

    /**
     * Establece el objeto {@link MeseroDTO} para la reservación.
     *
     * @param mesero El nuevo objeto MeseroDTO a asignar a la reservación.
     */
    public void setMesero(MeseroDTO mesero) {
        this.mesero = mesero;
    }

    /**
     * Obtiene la hora de la reservación.
     *
     * @return Un objeto {@link LocalTime} que representa la hora de la reservación.
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora de la reservación.
     *
     * @param hora La nueva hora de la reservación.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Obtiene el identificador único de la reservación.
     *
     * @return Un entero que representa el ID de la reservación.
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el identificador único de la reservación.
     *
     * @param id El nuevo ID de la reservación.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna una representación en cadena de texto del objeto ReservacionDTO.
     * Esta representación incluye el ID de la reservación, el número de mesa, la fecha y la hora.
     * Es útil para una visualización rápida de la reservación.
     *
     * @return Una cadena formateada con los datos clave de la reservación.
     */
    @Override
    public String toString() {
        return String.format("#%d — Mesa %s — %s %s",
            id,
            mesa.getNumeroMesa(),
            fecha.toString(),
            hora.toString()
        );
    }
}