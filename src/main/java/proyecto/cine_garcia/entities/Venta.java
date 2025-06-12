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
@Table(name = "venta")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Audited
public class Venta extends Base {
    @Column(name = "fecha")
    private String fecha;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "venta_funcion",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "funcion_id")
    )
    private List<Funcion> funciones = new ArrayList<Funcion>();

    @ManyToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name = "venta_cliente",
            joinColumns = @JoinColumn(name = "venta_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private List<Cliente> clientes = new ArrayList<Cliente>();
}
