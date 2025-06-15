package proyecto.cine_garcia.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import proyecto.cine_garcia.entities.TipoPago;

@RestController
@RequestMapping("/api/tipo-pago")
public class TipoPagoController {

    @GetMapping
    public TipoPago[] obtenerTiposDePago() {
        return TipoPago.values();
    }
}

