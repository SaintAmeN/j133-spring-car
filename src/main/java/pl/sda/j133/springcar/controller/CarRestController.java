package pl.sda.j133.springcar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.sda.j133.springcar.model.dto.CarResponse;
import pl.sda.j133.springcar.model.dto.CreateCarRequest;
import pl.sda.j133.springcar.service.CarService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/rest/car")
public class CarRestController {
    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CarResponse add(@RequestBody CreateCarRequest request) {
        return carService.add(request);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CarResponse> list() {
        return carService.getAll();
    }

    // TODO: Zadanie domowe:
    //  -> dopisać metodę @DeleteMapping (adres: /rest/car/3 powinno usunąć samochód o identyfikatorze 3)
    //  -> dopisać metodę @PatchMapping  (adres: /rest/car/3 powinno aktualizować wszystko prócz id i daty pierwszej rejestracji)
    //  -> dopisać metodę @GetMapping    (adres: /rest/car/3 powinno zwrócić samochód o identyfikatorze 3)
}
