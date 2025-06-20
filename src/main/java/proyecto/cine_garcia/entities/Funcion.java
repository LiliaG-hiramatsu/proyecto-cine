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
@Table(name = "funcion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Funcion extends Base {
    @Column(name = "horario")
    private String horario;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    @JsonIgnore
    private Pelicula pelicula;

    @OneToMany(
            mappedBy = "funcion",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Entrada> entradas = new ArrayList<Entrada>();

    @ManyToOne
    @JoinColumn(name = "sala_id")
    @JsonIgnore
    private Sala sala;
}
