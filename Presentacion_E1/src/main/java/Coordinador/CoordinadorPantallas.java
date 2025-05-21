package Coordinador;

import Presentacion.MapadeMesas;
import Presentacion.PantallaDeshabilitarHabilitarMesero;
import Presentacion.PantallaGestionMeseros;
import Presentacion.PantallaMenu;
import Presentacion.RegistrarReservacion;
import Presentacion.PantallaCancelarReservacion;
import BO.ReservacionBO;
import GenerarReportes.MenuReportesReservacion;
import GenerarReportes.ReporteReservaciones;
import GestionMeseros.PantallaRegistrarMesero;
import Persistencia.ReservacionDAO;
import Interfaces.IReservacionBO;
import Presentacion.PantallaModificarMesero;
import Roles.MenuRolesRestaurante;


/**
 * La clase **CoordinadorPantallas** actúa como un controlador centralizado
 * para la navegación entre las diferentes pantallas (vistas) de la aplicación.
 * Implementa el patrón **Singleton** para asegurar una única instancia
 * que gestione el flujo de la interfaz de usuario.
 *
 * Esta clase también sirve como un punto de acceso a las capas de negocio (BOs)
 * para que las vistas puedan interactuar con la lógica de negocio sin acoplarse
 * directamente a las implementaciones DAO.
 *
 * @author Gael
 * @version 1.0
 */
public class CoordinadorPantallas {

    /**
     * Instancia única de la clase CoordinadorPantallas (patrón Singleton).
     */
    private static CoordinadorPantallas instance;

    /**
     * Interfaz del objeto de negocio de reservaciones, para interactuar con la lógica de negocio.
     */
    private IReservacionBO controlReservacion;

    /**
     * Instancia de la pantalla del mapa de mesas.
     */
    private MapadeMesas mapaDeMesas;

    /**
     * Instancia de la pantalla del menú de roles del restaurante.
     */
    private MenuRolesRestaurante menuRoles;

    /**
     * Almacena el rol seleccionado por el usuario para la navegación condicional.
     */
    private String rolSeleccionado;

    /**
     * Constructor privado de la clase CoordinadorPantallas.
     * Inicializa las instancias de las vistas y de las capas de negocio
     * que serán gestionadas por el coordinador.
     * Es privado para asegurar el patrón Singleton.
     */
    private CoordinadorPantallas() {
        // Se inicializan las vistas que pueden ser persistentes o de acceso frecuente.
        this.mapaDeMesas = new MapadeMesas();
        // Se inicializa el control de negocio, inyectando la dependencia del DAO.
        this.controlReservacion = new ReservacionBO(ReservacionDAO.getInstanceDAO());
    }

    /**
     * Obtiene la única instancia de la clase CoordinadorPantallas.
     * Si la instancia no ha sido creada previamente, la inicializa.
     * Este es el punto de acceso para obtener el coordinador en toda la aplicación.
     *
     * @return La instancia única de CoordinadorPantallas.
     */
    public static CoordinadorPantallas getInstance() {
        if (instance == null) {
            instance = new CoordinadorPantallas();
        }
        return instance;
    }

    /**
     * Muestra la pantalla del menú de roles del restaurante.
     * Reinicia el rol seleccionado y asegura que la pantalla sea visible.
     */
    public void mostrarMenuRoles() {
        // Se asegura de que el rol seleccionado esté en blanco al mostrar el menú de roles.
        resetRolSeleccionado();
        if (menuRoles == null) {
            menuRoles = new MenuRolesRestaurante();
        }
        menuRoles.setVisible(true);
    }

    /**
     * Reinicia el valor de la variable `rolSeleccionado` a `null`.
     * Esto es útil cuando se necesita limpiar el estado del rol para una nueva selección.
     */
    public void resetRolSeleccionado() {
        this.rolSeleccionado = null;
    }

    /**
     * Obtiene la instancia de la pantalla del menú de roles.
     *
     * @return La instancia de {@link MenuRolesRestaurante}.
     */
    public MenuRolesRestaurante getMenuRoles() {
        return menuRoles;
    }

    /**
     * Establece la instancia de la pantalla del menú de roles.
     * Este método podría ser usado para inyectar una instancia de prueba o para reasignar.
     *
     * @param menuRoles La instancia de {@link MenuRolesRestaurante} a establecer.
     */
    public void setMenuRoles(MenuRolesRestaurante menuRoles) {
        this.menuRoles = menuRoles;
    }

    /**
     * Obtiene el rol que ha sido seleccionado por el usuario.
     *
     * @return Una cadena de texto que representa el rol seleccionado.
     */
    public String getRolSeleccionado() {
        return rolSeleccionado;
    }

    /**
     * Establece el rol seleccionado por el usuario.
     *
     * @param rolSeleccionado Una cadena de texto que representa el rol a establecer.
     */
    public void setRolSeleccionado(String rolSeleccionado) {
        this.rolSeleccionado = rolSeleccionado;
    }

    /**
     * Obtiene la instancia del objeto de negocio de reservaciones.
     * Permite a las vistas y otras clases de negocio acceder a la lógica de reservaciones.
     *
     * @return La instancia de {@link IReservacionBO}.
     */
    public IReservacionBO getControlReservacion() {
        return controlReservacion;
    }

    /**
     * Obtiene la instancia de la pantalla del mapa de mesas.
     *
     * @return La instancia de {@link MapadeMesas}.
     */
    public MapadeMesas getMapaDeMesas() {
        return mapaDeMesas;
    }

    /**
     * Muestra la pantalla del mapa de mesas.
     * Centra la pantalla en la ubicación nula (típicamente el centro de la pantalla)
     * y la hace visible.
     */
    public void mostrarMapaMesas() {
        MapadeMesas m = new MapadeMesas();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }

    /**
     * Muestra la pantalla para registrar una nueva reservación.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarRegistroReservacion() {
        RegistrarReservacion r = new RegistrarReservacion();
        r.setLocationRelativeTo(null);
        r.setVisible(true);
    }

    /**
     * Muestra la pantalla del menú principal de la aplicación.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarMenu() {
        PantallaMenu a = new PantallaMenu();
        a.setLocationRelativeTo(null);
        a.setVisible(true);
    }

    /**
     * Muestra la pantalla de gestión de meseros, que permite realizar
     * operaciones de CRUD sobre los meseros.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarGestionMeseros() {
        PantallaGestionMeseros g = new PantallaGestionMeseros();
        g.setLocationRelativeTo(null);
        g.setVisible(true);
    }

    /**
     * Muestra la pantalla para agregar un nuevo mesero al sistema.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarAgregarMesero() {
        PantallaRegistrarMesero rm = new PantallaRegistrarMesero();
        rm.setLocationRelativeTo(null);
        rm.setVisible(true);
    }

    /**
     * Muestra la pantalla para deshabilitar o habilitar un mesero existente.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarEliminarMesero() {
        PantallaDeshabilitarHabilitarMesero em = new PantallaDeshabilitarHabilitarMesero();
        em.setLocationRelativeTo(null);
        em.setVisible(true);
    }

    /**
     * Muestra la pantalla para modificar la información de un mesero existente.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarModificarMesero() {
        PantallaModificarMesero m = new PantallaModificarMesero();
        m.setLocationRelativeTo(null);
        m.setVisible(true);
    }

    /**
     * Muestra el menú de opciones para reportes de reservaciones.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarMenuReportes() {
        MenuReportesReservacion rr = new MenuReportesReservacion();
        rr.setLocationRelativeTo(null);
        rr.setVisible(true);
    }

    /**
     * Muestra la pantalla que presenta los reportes detallados de reservaciones.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarReportesReservacion() {
        ReporteReservaciones rp = new ReporteReservaciones();
        rp.setLocationRelativeTo(null);
        rp.setVisible(true);
    }

    /**
     * Muestra la pantalla para cancelar una reservación.
     * Se inyecta la instancia del control de reservaciones para que la pantalla pueda interactuar
     * con la lógica de negocio directamente.
     * Centra la pantalla y la hace visible.
     */
    public void mostrarCancelarReservacion() {
        PantallaCancelarReservacion pcr =
            new PantallaCancelarReservacion(getControlReservacion()); // Inyección de dependencia
        pcr.setLocationRelativeTo(null);
        pcr.setVisible(true);
    }
}
