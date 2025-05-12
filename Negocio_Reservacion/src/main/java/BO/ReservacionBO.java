/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BO;

import Entidades.Reservacion;
import Interfaces.IReservacionBO;
import Persistencia.ReservacionDAO;
import negocio.exception.NegocioException;

/**
 *
 * @author Gael
 */
public class ReservacionBO implements IReservacionBO{

    private final ReservacionDAO reservacionDAO;

    public ReservacionBO() {
        this.reservacionDAO = new ReservacionDAO();
    }

    @Override
    public Reservacion registrarReservacion(Reservacion reservacion) throws NegocioException {
        return reservacionDAO.registrarReservacion(reservacion);
    }
}
}
