package com.genspringboot.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    @Column(name="email")
    private String correo;

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
