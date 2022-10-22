package kg.megacom.postgre.carservice.services.impl;

import kg.megacom.postgre.carservice.models.Car;
import kg.megacom.postgre.carservice.repository.CarRepository;
import kg.megacom.postgre.carservice.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public Car save(Car car) {
        // INSERT INTO CARS(manufacturer, model, year, color, price, volume, horse_power)
        // VALUES (?, ?, ?, ?, ?, ?, ?);

        System.out.println("Before save to DB");
        System.out.println(car);
        car = carRepository.save(car);

        System.out.println("*************************");

        System.out.println("After save to DB");
        System.out.println(car);
        return car;
    }

    @Override
    public List<Car> getCars(double minPrice, double maxPrice, String manufacturerName) {
        return carRepository.findAll()
                .stream()
                .filter(car -> car.getPrice() <= maxPrice && car.getPrice() >= minPrice
                        && car.getManufacturer().toLowerCase(Locale.ROOT).contains(manufacturerName.toLowerCase(Locale.ROOT).trim()))
                .sorted(Comparator.comparingDouble(Car::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public Car updateCar(Car car) {
        return carRepository.save(car);
    }
}
