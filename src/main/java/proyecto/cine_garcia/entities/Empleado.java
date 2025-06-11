package proyecto.cine_garcia.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {
    private int id_empleado;
    private String nombre;
    private int dni;

}
