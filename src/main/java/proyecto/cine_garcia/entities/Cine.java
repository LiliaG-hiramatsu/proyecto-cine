package proyecto.cine_garcia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cine")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
public class Cine extends Base {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cine_id")
    private List<Sala> salas = new ArrayList<Sala>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cine_id")
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cine_id")
    private List<Venta> ventas = new ArrayList<Venta>();

    @ManyToMany(mappedBy = "cines")
    private List<Empleado> empleados = new ArrayList<Empleado>();


}
