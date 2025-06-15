package proyecto.cine_garcia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(
            mappedBy = "cine",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Sala> salas = new ArrayList<Sala>();

    @OneToMany(
            mappedBy = "cine",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Pelicula> peliculas = new ArrayList<Pelicula>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cine_id")
    private List<Venta> ventas = new ArrayList<Venta>();

    @ManyToMany
    @JoinTable(
            name = "cine_empleado",
            joinColumns = @JoinColumn(name = "cine_id"),
            inverseJoinColumns = @JoinColumn(name = "empleado_id")
    )
    private List<Empleado> empleados = new ArrayList<Empleado>();

    public void addPelicula(Pelicula pelicula) {
        if (peliculas == null) {
            peliculas = new ArrayList<>();
        }
        peliculas.add(pelicula);
        pelicula.setCine(this);
    }

    public void addSala(Sala s) {
        if (salas == null) salas = new ArrayList<>();
        salas.add(s);
        s.setCine(this);
    }

    public void addEmpleado(Empleado e) {
        if (empleados == null) empleados = new ArrayList<>();
        empleados.add(e);
        if (e.getCines() == null) e.setCines(new ArrayList<>());
        if (!e.getCines().contains(this)) {
            e.getCines().add(this);
        }
    }
}
