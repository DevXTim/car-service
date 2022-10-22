package kg.megacom.postgre.carservice.services;

import kg.megacom.postgre.carservice.models.Car;

import java.util.List;

public interface CarService {
    Car save(Car car);

    List<Car> getCars(double minPrice, double maxPrice, String manufacturerName);

    Car updateCar(Car car);
}
