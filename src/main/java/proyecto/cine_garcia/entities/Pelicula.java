package proyecto.cine_garcia.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "pelicula")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Pelicula extends Base implements Promocion {
    @Column(name = "titulo")
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(name = "genero")
    private Genero genero;

    @Override
    public float obtenerDescuento() {
        System.out.println("Insertar logica de promocion");
        return 0;
    }
}
