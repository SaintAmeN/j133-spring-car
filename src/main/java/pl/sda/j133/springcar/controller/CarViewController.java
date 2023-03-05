package pl.sda.j133.springcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.j133.springcar.service.CarService;

@Controller // <--------------------- Controller, NIE! RestController
@RequestMapping("/view/car")
public class CarViewController {
    private final CarService carService;

    public CarViewController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String demo(){
        return "demo-page";
    }
}
