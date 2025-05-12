package Mappers;

import Entidades.Reservacion;
import dtos.ReservacionDTO;

public class ReservacionMapper {

    public static ReservacionDTO toDTO(Reservacion reservacion) {
        ReservacionDTO dto = new ReservacionDTO();
        dto.setId(reservacion.getId());

        dto.setMesa(MesaMapper.toDTO(reservacion.getMesa()));
        dto.setCliente(ClienteMapper.toDTO(reservacion.getCliente()));
        dto.setFecha(reservacion.getFecha());
        dto.setHora(reservacion.getHora());
        dto.setMesero(MeseroMapper.toDTO(reservacion.getMesero()));
        
        return dto;
    }

    public static Reservacion toEntity(ReservacionDTO dto) {
        Reservacion reservacion = new Reservacion();
        reservacion.setId(dto.getId());

        reservacion.setMesa(MesaMapper.toEntity(dto.getMesa()));
        reservacion.setCliente(ClienteMapper.toEntity(dto.getCliente()));
        reservacion.setFecha(dto.getFecha());
        reservacion.setHora(dto.getHora());
        reservacion.setMesero(MeseroMapper.toEntity(dto.getMesero()));
        
        return reservacion;
    }
}
