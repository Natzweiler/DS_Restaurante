/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Coordinador;

import Presentacion.MapadeMesas;

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
}

