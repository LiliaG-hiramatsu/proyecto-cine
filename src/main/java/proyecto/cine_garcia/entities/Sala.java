package proyecto.cine_garcia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "sala")
public class Sala implements Serializable {
    private int id_sala;
    private int numero;
    private int capacidad;

}
