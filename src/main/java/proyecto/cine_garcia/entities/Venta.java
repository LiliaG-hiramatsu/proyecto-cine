package proyecto.cine_garcia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "venta")
public class Venta implements Serializable {
    private int id_venta;
    private String fecha;
}
