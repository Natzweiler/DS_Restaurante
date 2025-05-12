package Coordinador;

import Presentacion.MapadeMesas;
import Presentacion.PantallaAgregarMesero;
import Presentacion.PantallaGestionMeseros;
import Presentacion.PantallaMenu;
import Presentacion.RegistrarReservacion;
import Presentacion.PantallaCancelarReservacion;
import BO.ReservacionBO;
import Persistencia.ReservacionDAO;
import Interfaces.IReservacionBO;

public class CoordinadorPantallas {
    private static CoordinadorPantallas instancia;
    private IReservacionBO controlReservacion;
    private MapadeMesas mapaDeMesas;

    private CoordinadorPantallas() {
        mapaDeMesas = new MapadeMesas();
        controlReservacion = new ReservacionBO(ReservacionDAO.getInstanceDAO());
    }

    public static CoordinadorPantallas getInstance() {
        if (instancia == null) {
            instancia = new CoordinadorPantallas();
        }
        return instancia;
    }

    // — Getter para la BO
    public IReservacionBO getControlReservacion() {
        return controlReservacion;
    }

    public MapadeMesas getMapaDeMesas() {
        return mapaDeMesas;
    }

    public void mostrarMapaMesas() {
        MapadeMesas m = new MapadeMesas();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }

    public void mostrarRegistroReservacion() {
        RegistrarReservacion r = new RegistrarReservacion();
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }

    public void mostrarMenu() {
        PantallaMenu a = new PantallaMenu();
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }

    // CRUD de meseros
    public void mostrarGestionMeseros() {
        PantallaGestionMeseros g = new PantallaGestionMeseros();
        g.setLocationRelativeTo(null);
        g.setVisible(true);
    }

    public void mostrarAgregarMesero() {
        PantallaAgregarMesero ag = new PantallaAgregarMesero();
        ag.setLocationRelativeTo(null);
        ag.setVisible(true);
    }

    public void mostrarCancelarReservacion() {
        // Usa el controlReservacion interno
        PantallaCancelarReservacion pcr =
            new PantallaCancelarReservacion(getControlReservacion());
        pcr.setLocationRelativeTo(null);
        pcr.setVisible(true);
    }
}
