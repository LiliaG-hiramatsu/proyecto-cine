package proyecto.cine_garcia.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "entrada")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Entrada extends Base {
    @Column(name = "precio")
    private double precio;
    @Column(name = "asiento")
    private String asiento;

    @ManyToOne
    @JoinColumn(name = "funcion_id")
    @JsonIgnore
    private Funcion funcion;

}
