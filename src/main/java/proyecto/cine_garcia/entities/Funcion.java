package proyecto.cine_garcia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "funcion")
public class Funcion implements Serializable {
    private int id_funcion;
    private String horario;

}
