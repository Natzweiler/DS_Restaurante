package Mappers;

import Entidades.Reservacion;
import dtos.ReservacionDTO;

/**
 * La clase **ReservacionMapper** es una utilidad estática que se encarga de la
 * conversión entre la entidad {@link Reservacion} y su respectivo DTO
 * (Data Transfer Object) {@link ReservacionDTO}.
 *
 * Este mapper maneja el mapeo de objetos anidados ({@link Cliente}, {@link Mesa}, {@link Mesero}),
 * delegando la conversión de estos sub-objetos a sus respectivos mappers.
 *
 * @author Gael
 * @version 1.0
 */
public class ReservacionMapper {

    /**
     * Constructor privado para evitar la instanciación de la clase, ya que
     * todos sus métodos son estáticos.
     */
    private ReservacionMapper() {
        // Constructor vacío intencionalmente
    }

    /**
     * Mapea un objeto de entidad {@link Reservacion} a un objeto {@link ReservacionDTO}.
     * Incluye el mapeo de entidades relacionadas (Mesa, Cliente, Mesero) a sus respectivos DTOs.
     *
     * @param reservacion La entidad {@link Reservacion} a ser mapeada.
     * @return Un objeto {@link ReservacionDTO} con los datos de la reservación.
     */
    public static ReservacionDTO toDTO(Reservacion reservacion) {
        if (reservacion == null) {
            return null;
        }
        ReservacionDTO dto = new ReservacionDTO();
        dto.setId(reservacion.getId());
        dto.setMesa(MesaMapper.toDTO(reservacion.getMesa()));
        dto.setCliente(ClienteMapper.toDTO(reservacion.getCliente()));
        dto.setFecha(reservacion.getFecha());
        dto.setHora(reservacion.getHora());
        dto.setMesero(MeseroMapper.toDTO(reservacion.getMesero()));
        return dto;
    }

    /**
     * Mapea un objeto {@link ReservacionDTO} a un objeto de entidad {@link Reservacion}.
     * Incluye el mapeo de DTOs relacionados (MesaDTO, ClienteDTO, MeseroDTO) a sus respectivas entidades.
     *
     * @param dto El objeto {@link ReservacionDTO} a ser mapeado.
     * @return Una entidad {@link Reservacion} con los datos del DTO.
     */
    public static Reservacion toEntity(ReservacionDTO dto) {
        if (dto == null) {
            return null;
        }
        Reservacion reservacion = new Reservacion();
        reservacion.setId(dto.getId());
        // Se asume que los sub-DTOs (Mesa, Cliente, Mesero) no son nulos si la reservación es válida.
        // Si pueden ser nulos, se debe añadir una comprobación aquí.
        reservacion.setMesa(MesaMapper.toEntity(dto.getMesa()));
        reservacion.setCliente(ClienteMapper.toEntity(dto.getCliente()));
        reservacion.setFecha(dto.getFecha());
        reservacion.setHora(dto.getHora());
        reservacion.setMesero(MeseroMapper.toEntity(dto.getMesero()));
        return reservacion;
    }
}
