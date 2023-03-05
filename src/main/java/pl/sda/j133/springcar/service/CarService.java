package pl.sda.j133.springcar.service;

import org.springframework.stereotype.Service;
import pl.sda.j133.springcar.model.Car;
import pl.sda.j133.springcar.model.dto.CarResponse;
import pl.sda.j133.springcar.model.dto.CreateCarRequest;
import pl.sda.j133.springcar.repository.CarRepository;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public CarResponse add(CreateCarRequest request) {
        // Na podstawie obiektu żądania (request) tworzymy obiekt żądany (Car)
        Car car = Car.builder()
                .reg(request.getNrRejestracyjny())
                .engineCap(request.getPojemnoscSilnika())
                .registrationDate(request.getDataPierwszejRejestracji())
                .doors(request.getIloscDrzwi())
                .build();

        // Zapis stworzonego obiektu (car) do bazy
        car = carRepository.save(car);

        // Zwracamy stworzony samochód do użytkownika
        return mapujCarNaCarResponse(car);
    }

    public List<CarResponse> getAll() {
        return carRepository.findAll()
                .stream().map(this::mapujCarNaCarResponse)
                .toList();
    }

    // Car -> CarResponse
    private CarResponse mapujCarNaCarResponse(Car car) {
        return new CarResponse(
                car.getId(),
                car.getReg(),
                car.getRegistrationDate(),
                car.getDoors(),
                car.getEngineCap()
        );
    }
}
