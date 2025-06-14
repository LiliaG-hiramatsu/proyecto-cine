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
        Cine cine2 = new Cine();
        cine1.setNombre("Cinemark Mendoza");
        cine1.setDireccion("Calle Panamericana 1688");
        cine2.setNombre("Cinema Center");
        cine2.setDireccion("Av. Lateral Norte Acceso Este, Mendoza");
        List<Cine> cines = new ArrayList<Cine>();
        cines.add(cine1);
        cines.add(cine2);

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

        List<Pelicula> peliculas = new ArrayList<Pelicula>();
        peliculas.add(pelicula1);
        peliculas.add(pelicula2);
        peliculas.add(pelicula3);

        cine1.setPeliculas(peliculas);
        cine2.setPeliculas(peliculas);

        // Crear Funciones
        Funcion funcion1 = new Funcion();
        Funcion funcion2 = new Funcion();
        funcion1.setHorario("Lunes 20:30 hs");
        funcion1.setPelicula(pelicula1);

        funcion2.setHorario("Martes 19:45 hs");
        funcion2.setPelicula(pelicula2);

        List<Funcion> funciones = new ArrayList<Funcion>();
        funciones.add(funcion1);
        funciones.add(funcion2);

        // Crear Sala
        Sala sala1 = new Sala();
        sala1.setNumero(4);
        sala1.setCapacidad(50);
        sala1.setFunciones(funciones);
        sala1.setCine(cine1);

        Sala sala2 = new Sala();
        sala2.setNumero(9);
        sala2.setCapacidad(90);
        sala2.setFunciones(funciones);
        sala2.setCine(cine2);

        List<Sala> salas = new ArrayList<Sala>();
        salas.add(sala1);
        salas.add(sala2);

        cine1.setSalas(salas);
        cine2.setSalas(salas);

        // Crear un empleado
        Empleado e1 = new Empleado();
        e1.setNombre("Martina Gomez");
        e1.setDni(123456);
        // Hago una lista para poder seguir creando empleados
        List<Empleado> empleados = new ArrayList<Empleado>();
        empleados.add(e1);

        // Trabaja en los dos cines
        cine1.setEmpleados(empleados);
        cine2.setEmpleados(empleados);

        // Persistir los datos
        peliculaRepository.saveAll(peliculas);
        funcionRepository.saveAll(funciones);
        salaRepository.saveAll(salas);
        empleadoRepository.saveAll(empleados);
        cineRepository.saveAll(cines);

        System.out.println("Datos de prueba cargados correctamente.");
    }
}
