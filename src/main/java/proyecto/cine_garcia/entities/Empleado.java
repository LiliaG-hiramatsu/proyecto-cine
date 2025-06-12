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
@Table(name = "empleado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Empleado extends Base {
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "dni")
    private int dni;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "empleado_cine",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "cine_id")
    )
    private List<Cine> cines = new ArrayList<Cine>();
}
