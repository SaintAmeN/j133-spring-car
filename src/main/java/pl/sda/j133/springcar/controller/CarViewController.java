package pl.sda.j133.springcar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.sda.j133.springcar.model.dto.CarResponse;
import pl.sda.j133.springcar.model.dto.CreateCarRequest;
import pl.sda.j133.springcar.service.CarService;

import java.util.List;

@Controller // <--------------------- Controller, NIE! RestController
@RequestMapping("/view/car")
public class CarViewController {
    private final CarService carService;

    public CarViewController(CarService carService) {
        this.carService = carService;
    }

    // http://localhost:8080/view/car/demo
    @GetMapping("/demo")
    public String demo(){
        return "demo-page";
    }

    // http://localhost:8080/view/car
    // TODO: poczytam o: Model, ModelMap, ModelView
    @GetMapping
    public String list(Model model){
        List<CarResponse> listaSamochodow = carService.getAll();
        model.addAttribute("atrybutListaSamochodow", listaSamochodow);

        return "car-list-page";
    }

    // http://localhost:8080/view/car/form
    //
    // formularz wysyła => POST
    // przegladarka zawsze działa na GET
    // JavaScript umożliwia wywoływanie PATCH,PUT,DELETE
    @GetMapping("/form")
    public String pobierzStroneFormularza(Model model) {
        model.addAttribute("atrybutObiektFormularza", new CreateCarRequest());
        return "car-form-page";
    }

    @PostMapping("/form")
    public String przeslijWypelnionyFormularz(Model model, CreateCarRequest request) {
        carService.add(request);
        return "redirect:/view/car";
    }
}
