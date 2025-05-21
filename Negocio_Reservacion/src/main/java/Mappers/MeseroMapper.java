/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Mesero;
import dtos.MeseroDTO;

/**
 * La clase **MeseroMapper** es una utilidad estática encargada de la
 * conversión bidireccional entre la entidad {@link Mesero} y su
 * DTO (Data Transfer Object) {@link MeseroDTO}.
 *
 * Facilita el transporte de datos de meseros entre diferentes capas de la aplicación,
 * asegurando un formato de datos adecuado para cada contexto.
 *
 * @author Gael
 * @version 1.0
 */
public class MeseroMapper {

    /**
     * Constructor privado para evitar la instanciación de la clase, ya que
     * todos sus métodos son estáticos.
     */
    private MeseroMapper() {
        // Constructor vacío intencionalmente
    }

    /**
     * Mapea un objeto {@link MeseroDTO} a un objeto de entidad {@link Mesero}.
     * Realiza un mapeo directo de las propiedades del DTO a la entidad.
     *
     * @param dto El objeto {@link MeseroDTO} a ser mapeado.
     * @return Una entidad {@link Mesero} con los datos del DTO, o {@code null} si el DTO de entrada es nulo.
     */
    public static Mesero toEntity(MeseroDTO dto) {
        if (dto == null) {
            return null;
        }
        Mesero mesero = new Mesero();
        mesero.setId(dto.getId());
        mesero.setNombre(dto.getNombre());
        mesero.setTelefono(dto.getTelefono());
        mesero.setFechaNacimiento(dto.getFechaNacimiento());
        mesero.setDireccion(dto.getDireccion());
        mesero.setEstado(dto.isEstado()); // Mapea el estado si está presente en el DTO
        return mesero;
    }

    /**
     * Mapea un objeto de entidad {@link Mesero} a un objeto {@link MeseroDTO}.
     * Realiza un mapeo directo de las propiedades de la entidad al DTO.
     *
     * @param mesero La entidad {@link Mesero} a ser mapeada.
     * @return Un objeto {@link MeseroDTO} con los datos del mesero, o {@code null} si la entidad de entrada es nula.
     */
    public static MeseroDTO toDTO(Mesero mesero) {
        if (mesero == null) {
            return null;
        }
        MeseroDTO dto = new MeseroDTO();
        dto.setId(mesero.getId());
        dto.setNombre(mesero.getNombre());
        dto.setTelefono(mesero.getTelefono());
        dto.setFechaNacimiento(mesero.getFechaNacimiento());
        dto.setDireccion(mesero.getDireccion());
        dto.setEstado(mesero.isEstado()); // Mapea el estado de la entidad al DTO
        return dto;
    }
}

