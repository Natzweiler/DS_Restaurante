/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Coordinador.CoordinadorPantallas;

/**
 *
 * @author Gael
 */
public class Main {

    public static void main(String[] args) {
        
       Coordinador.CoordinadorPantallas ca = CoordinadorPantallas.getInstance();
        ca.mostrarMenuRoles();
    }

}
