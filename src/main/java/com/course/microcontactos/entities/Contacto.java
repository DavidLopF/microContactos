package com.course.microcontactos.entities;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Contactos")
@NamedQuery(name="Contacto.findALL", query="SELECT C FROM Contacto C")
public class Contacto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContacto;

    private int edad;

    @Column(unique = true)
    private String email;


    private String nombre;
    public Contacto() {
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }





}
