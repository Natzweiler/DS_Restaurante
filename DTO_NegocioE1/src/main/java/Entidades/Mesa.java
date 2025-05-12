/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author Gael
 */
@Entity
@Table(name = "mesa")
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "numeroMesa", nullable = false, unique = true)
    private Integer numeroMesa;

    @Column(name = "capacidad", nullable = false)
    private int capacidadMesa;

    @Column(name = "disponible", nullable = false)
    private boolean disponible;

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCapacidadMesa() {
        return capacidadMesa;
    }

    public void setCapacidadMesa(int capacidad) {
        this.capacidadMesa = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Mesa{" + "id=" + id + ", numeroMesa=" + numeroMesa + ", capacidadMesa=" + capacidadMesa + ", disponible=" + disponible + '}';
    }

}
