package proyecto.cine_garcia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "entrada")
public class Entrada implements Serializable {
    private int id_entrada;
    private double precio;
    private String asiento;
}
