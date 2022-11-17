package com.genspringboot.project.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name="BuySell")
public class BuySell {
    @Id
    @GeneratedValue
    private Integer id;
    //con esto nos aseguramos que el monot siempre será mayor a 0
    @Range(min=0)
    private int monto;
    //nos permite darle un formato predeterminado a la fecha en la base
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaCompra;

    //recepcionar One to many (many to one)
    @JsonManagedReference
    //cuando se recibe una relacion many to one el fetch type es con LAZY
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    //many to many de auto
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="CarSell",
        joinColumns = @JoinColumn(name="buySell_id"),
        inverseJoinColumns = @JoinColumn(name="car_id")
    )
    private List <Car> car;


    public BuySell() {
    }

    public BuySell(Integer id, @Range(min = 0) int monto, Date fechaCompra) {
        this.id = id;
        this.monto = monto;
        this.fechaCompra = fechaCompra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    

    
}
