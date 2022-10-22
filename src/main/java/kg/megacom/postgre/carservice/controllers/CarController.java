package kg.megacom.postgre.carservice.controllers;

import kg.megacom.postgre.carservice.models.Car;
import kg.megacom.postgre.carservice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/save")
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }

    @GetMapping("/list")
    public List<Car> getCars(
            @RequestParam(required = false, defaultValue = "0") double minPrice,
            @RequestParam(required = false, defaultValue = Double.MAX_VALUE + "") double maxPrice,
            @RequestParam(required = false, defaultValue = "") String manufacturerName) {
        return carService.getCars(minPrice, maxPrice, manufacturerName);
    }

    @PutMapping("/update")
    public Car updateCar(@RequestBody Car car) {
        return carService.updateCar(car);
    }
}
