package proyecto.cine_garcia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
    private int id_pelicula;
    private String titulo;

}
