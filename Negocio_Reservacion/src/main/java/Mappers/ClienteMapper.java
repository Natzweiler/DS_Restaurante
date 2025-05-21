/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Cliente;
import dtos.ClienteDTO;

/**
 * La clase **ClienteMapper** es una utilidad estática que se encarga de la
 * conversión entre la entidad {@link Cliente} y su respectivo DTO
 * (Data Transfer Object) {@link ClienteDTO}.
 *
 * Facilita la transferencia de datos entre la capa de persistencia y la capa de
 * negocio/presentación, asegurando que solo los datos necesarios sean expuestos.
 *
 * @author Gael
 * @version 1.0
 */
public class ClienteMapper {

    /**
     * Constructor privado para evitar la instanciación de la clase, ya que
     * todos sus métodos son estáticos.
     */
    private ClienteMapper() {
        // Constructor vacío intencionalmente
    }

    /**
     * Mapea un objeto de entidad {@link Cliente} a un objeto {@link ClienteDTO}.
     *
     * @param cliente La entidad {@link Cliente} a ser mapeada.
     * @return Un objeto {@link ClienteDTO} con los datos del cliente.
     */
    public static ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        ClienteDTO dto = new ClienteDTO();
        dto.setNombre(cliente.getNombre());
        dto.setCorreo(cliente.getCorreo());
        dto.setTelefono(cliente.getTelefono());
        return dto;
    }

    /**
     * Mapea un objeto {@link ClienteDTO} a un objeto de entidad {@link Cliente}.
     *
     * @param dto El objeto {@link ClienteDTO} a ser mapeado.
     * @return Una entidad {@link Cliente} con los datos del DTO.
     */
    public static Cliente toEntity(ClienteDTO dto) {
        if (dto == null) {
            return null;
        }
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setCorreo(dto.getCorreo());
        cliente.setTelefono(dto.getTelefono());
        return cliente;
    }
}

