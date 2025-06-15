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
@Table(name = "sala")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Sala extends Base {
    @Column(name = "numero")
    private int numero;
    @Column(name = "capacidad")
    private int capacidad;

    @OneToMany(
            mappedBy = "sala",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private List<Funcion> funciones = new ArrayList<Funcion>();

    @ManyToOne
    @JoinColumn(name = "cine_id")
    @JsonIgnore
    private Cine cine;

    public void addFuncion(Funcion f) {
        if (funciones == null) funciones = new ArrayList<>();
        funciones.add(f);
        f.setSala(this);
    }
}
