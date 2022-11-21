package com.genspringboot.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.genspringboot.project.model.Car;
import com.genspringboot.project.service.CarService;


@Controller
@CrossOrigin("*")
public class CarController {

    private CarService carService;

    public CarController (@Autowired CarService carService){
        this.carService = carService;
    }

    @PostMapping("/Car/save")
    public void guardarAuto (@RequestBody Car car){
        carService.saveCar(car);
    } 

    @PutMapping("/Car/update")
    public void actualizarAuto(@RequestBody Car car){
        carService.updateCar(car);
    }

    @GetMapping("/Car/findAll")
    public List<Car> todosLosAutos(){
        return carService.findAll();
    }

    @GetMapping("/Car/buscarMarca/{marca}")
    public List <Car> buscarMarca(@PathVariable String marca){
        return carService.buscarPorMarca(marca);
    }

    @GetMapping("/Car/buscarColor")
    public List<Car> colorAuto(@RequestBody String color){
        return carService.buscarPorColor(color);
    }

    @GetMapping("/Car/buscarColorMarca")
    public List<Car> colorMarcaAuto(@RequestBody String color, String marca){
        return carService.buscarPorColorMarca(color, marca);
    }

    @DeleteMapping("/Car/eliminarAuto/{id}")
    public void deleteAuto(@PathVariable Integer id){
        carService.eliminarAuto(id);
    }

    
}
