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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "sala_id")
    private List<Funcion> funciones = new ArrayList<Funcion>();

    @ManyToOne
    @JoinColumn(name = "cine_id")
    private Cine cine;
}
