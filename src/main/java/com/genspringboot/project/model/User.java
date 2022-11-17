package com.genspringboot.project.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

//le vamos a poner el nombre a nuestra tabla en la BD
@Entity(name = "User")
public class User {
    //le especificamos a la base que el siguente atributo
    //será el id de la tabla
    @Id
    //generamos la llave primaria
    @GeneratedValue
    //definimos el atributo id
    private int id;
    private String name;
    @Column(name="last_name")
    private String lastName;
    //hago que el correo sea unico, que no se pueda repetir
    @Column(name="email", unique = true)
    private String correo;

    //relacion one to one
    @JsonBackReference
    //cuando se envia una relacion one to one siempre se ocupa LAZY
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private License license;

    //relacion one to many
    @JsonBackReference
    //en las relaciones one to many el tipo de fetch siempre se hace con EAGER cuando se envía :D
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch= FetchType.EAGER)
    private List<BuySell> buySell;

    public User() {
    }

    public User(int id, String name, String lastName, String correo) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
    

}
