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

    @ManyToMany(mappedBy = "empleados")
    @JsonIgnore
    private List<Cine> cines = new ArrayList<Cine>();

    public void addCine(Cine c) {
        if (!cines.contains(c)) {
            cines.add(c);
        }
        if (!c.getEmpleados().contains(this)) {
            c.getEmpleados().add(this);
        }
    }

}
