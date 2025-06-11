package proyecto.cine_garcia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "pago")
public class Pago implements Serializable {
    private int id_pago;
    private double monto;

}
