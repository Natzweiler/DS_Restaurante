/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mappers;

import Entidades.Reservacion;
import dtos.ReservacionDTO;

/**
 *
 * @author Gael
 */
public class ReservacionMapper {

    // Método para mapear de entidad Reservacion a DTO
    public static ReservacionDTO toDTO(Reservacion reservacion) {
        ReservacionDTO dto = new ReservacionDTO();
        
        // Mapear las entidades relacionadas a sus DTOs
        dto.setMesa(MesaMapper.toDTO(reservacion.getMesa()));
        dto.setCliente(ClienteMapper.toDTO(reservacion.getCliente()));
        dto.setFecha(reservacion.getFecha());
        dto.setHora(reservacion.getHora());
        dto.setMesero(MeseroMapper.toDTO(reservacion.getMesero()));
        
        return dto;
    }

    // Método para mapear de DTO a entidad Reservacion (si lo necesitas para persistir)
    public static Reservacion toEntity(ReservacionDTO dto) {
        Reservacion reservacion = new Reservacion();
        
        // Mapear los DTOs a las entidades correspondientes
        reservacion.setMesa(MesaMapper.toEntity(dto.getMesa()));
        reservacion.setCliente(ClienteMapper.toEntity(dto.getCliente()));
        reservacion.setFecha(dto.getFecha());
        reservacion.setHora(dto.getHora());
        reservacion.setMesero(MeseroMapper.toEntity(dto.getMesero()));
        
        return reservacion;
    }
}

