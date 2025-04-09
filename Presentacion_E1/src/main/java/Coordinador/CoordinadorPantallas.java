/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coordinador;

import Presentacion.MapadeMesas;
import Presentacion.PantallaInicio;
import Presentacion.PantallaMenu;
import Presentacion.RegistrarReservacion;

/**
 *
 * @author Gael
 */
public class CoordinadorPantallas {
    private static CoordinadorPantallas instancia;
    
    
    private MapadeMesas mapaDeMesas;
    
    private CoordinadorPantallas() {
        
        mapaDeMesas = new MapadeMesas();
    }
    
    public static CoordinadorPantallas getInstance() {
        if (instancia == null) {
            instancia = new CoordinadorPantallas();
        }
        return instancia;
    }
    
    public MapadeMesas getMapaDeMesas() {
        return mapaDeMesas;
    }
    public void mostrarPantallaInicio(){
    PantallaInicio p = new PantallaInicio();
    p.setLocationRelativeTo(null);
    p.setVisible(true);
    }
    
    
    public void mostrarMapaMesas(){
    MapadeMesas m = new MapadeMesas();
    m.setLocationRelativeTo(null);
    m.setVisible(true);
    
    }
    public void mostrarRegistroReservacion(){
    RegistrarReservacion r = new RegistrarReservacion();
    r.setLocationRelativeTo(null);
    r.setVisible(true);
    
    }
    
    public void mostrarMenu(){
    PantallaMenu a = new PantallaMenu();
    a.setLocationRelativeTo(null);
    a.setVisible(true);
    }
}

