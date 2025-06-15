package proyecto.cine_garcia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import proyecto.cine_garcia.entities.*;
import proyecto.cine_garcia.repositories.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final CineRepository cineRepository;
    private final PeliculaRepository peliculaRepository;
    private final SalaRepository salaRepository;
    private final FuncionRepository funcionRepository;
    private final EmpleadoRepository empleadoRepository;

    public DataLoader(CineRepository cineRepository, PeliculaRepository peliculaRepository, SalaRepository salaRepository, FuncionRepository funcionRepository, EmpleadoRepository empleadoRepository) {
        this.cineRepository = cineRepository;
        this.peliculaRepository = peliculaRepository;
        this.salaRepository = salaRepository;
        this.funcionRepository = funcionRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (cineRepository.count() > 0) {
            System.out.println("Ya existen datos. No se cargó el DataLoader.");
            return;
        }
        System.out.println("Cargando datos iniciales...");

        // Crear Cines
        Cine cine1 = new Cine();
        cine1.setNombre("Cinemark Mendoza");
        cine1.setDireccion("Calle Panamericana 1688");

        Cine cine2 = new Cine();
        cine2.setNombre("Cinema Center");
        cine2.setDireccion("Av. Lateral Norte Acceso Este, Mendoza");

        // Crear Películas
        Pelicula pelicula1 = new Pelicula();
        pelicula1.setTitulo("Spider Man 5");
        pelicula1.setGenero(Genero.ACCION);

        Pelicula pelicula2 = new Pelicula();
        pelicula2.setTitulo("Lilo y Stitch");
        pelicula2.setGenero(Genero.COMEDIA);

        Pelicula pelicula3 = new Pelicula();
        pelicula3.setTitulo("Gladiador 2");
        pelicula3.setGenero(Genero.DRAMA);

        // Asociar películas con cines
        cine1.addPelicula(pelicula1);
        cine1.addPelicula(pelicula2);
        cine2.addPelicula(pelicula3);

        // Crear Salas
        Sala sala1 = new Sala();
        sala1.setNumero(4);
        sala1.setCapacidad(50);

        Sala sala2 = new Sala();
        sala2.setNumero(9);
        sala2.setCapacidad(90);

        cine1.addSala(sala1);
        cine2.addSala(sala2);

        // Crear Funciones
        Funcion funcion1 = new Funcion();
        funcion1.setHorario("Lunes 20:30 hs");
        funcion1.setPelicula(pelicula1);

        Funcion funcion2 = new Funcion();
        funcion2.setHorario("Martes 19:45 hs");
        funcion2.setPelicula(pelicula2);

        sala1.addFuncion(funcion1);
        sala2.addFuncion(funcion2);

        // Crear Empleado
        Empleado e1 = new Empleado();
        e1.setNombre("Martina Gomez");
        e1.setDni(123456);

        // Asociar empleado con cines
        e1.addCine(cine1);
        e1.addCine(cine2);

        // Guardar el empleado antes de guardar los cines
        empleadoRepository.save(e1);

        // Persistencia - Cine se encarga de persistir películas, salas, funciones y empleados
        cineRepository.save(cine1);
        cineRepository.save(cine2);

        System.out.println("Datos de prueba cargados correctamente.");
    }

}
