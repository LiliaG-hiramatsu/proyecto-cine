package proyecto.cine_garcia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String redireccion() {
        return "redirect:/index.html";
    }
}

