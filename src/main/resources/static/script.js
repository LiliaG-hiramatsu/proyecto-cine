document.addEventListener("DOMContentLoaded", () => {
    const formCliente = document.getElementById("form-registro");
    const cinesContainer = document.getElementById("cines-container");
    const peliculasContainer = document.getElementById("peliculas-container");
    const peliculasSection = document.getElementById("peliculas-section");
    const cineNombreSpan = document.getElementById("cine-nombre");
    const funcionesSection = document.getElementById("funciones-section");
    const funcionesContainer = document.getElementById("funciones-container");
    const peliculaNombreSpan = document.getElementById("pelicula-nombre");
    const formularioSection = document.getElementById("formulario-compra-section");
    const formularioContainer = document.getElementById("formulario-compra-container");

    let cliente;

    formCliente.addEventListener("submit", async (e) => {
        e.preventDefault();
        const nombre = document.getElementById("nombre").value;
        const email = document.getElementById("email").value;

        try {
            const res = await fetch("/api/clientes", {
                method: "POST",
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify({ nombre, email })
            });

            if (!res.ok) throw new Error("Error al guardar cliente");
            cliente = await res.json();
            alert(`¡Bienvenido, ${cliente.nombre}!`);
            formCliente.style.display = "none";
        } catch (err) {
            console.error("Error al guardar cliente:", err);
            alert("No se pudo registrar el cliente. Intenta de nuevo.");
        }
    });

    async function cargarCines() {
        try {
            const res = await fetch("/api/cines");
            if (!res.ok) throw new Error("Error al obtener cines");

            const cines = await res.json();
            cinesContainer.innerHTML = "";

            if (cines.length === 0) {
                cinesContainer.innerHTML = "<p>No hay cines disponibles.</p>";
                return;
            }

            cines.forEach(cine => {
                const card = document.createElement("div");
                card.className = "card";
                card.textContent = cine.nombre;
                card.addEventListener("click", () => cargarPeliculasDeCine(cine));
                cinesContainer.appendChild(card);
            });
        } catch (err) {
            console.error("Error al cargar cines:", err);
            cinesContainer.innerHTML = "<p>Error al cargar cines.</p>";
        }
    }

    async function cargarPeliculasDeCine(cine) {
        cineNombreSpan.textContent = cine.nombre;
        peliculasContainer.innerHTML = "<p>Cargando películas...</p>";
        peliculasSection.style.display = "block";

        funcionesSection.style.display = "none";
        formularioSection.style.display = "none";

        try {
            const res = await fetch(`/api/cines/${cine.id}/peliculas`);
            if (!res.ok) throw new Error("Error al cargar películas");

            const peliculas = await res.json();
            peliculasContainer.innerHTML = "";

            if (peliculas.length === 0) {
                peliculasContainer.innerHTML = "<p>No hay películas disponibles para este cine.</p>";
                return;
            }

            peliculas.forEach(pelicula => {
                const card = document.createElement("div");
                card.className = "card";
                card.innerHTML = `
                    <p><strong>Título:</strong> ${pelicula.titulo}</p>
                    <p><strong>Género:</strong> ${pelicula.genero}</p>
                `;
                card.addEventListener("click", () => cargarFuncionesDePelicula(pelicula, cine));
                peliculasContainer.appendChild(card);
            });
        } catch (err) {
            console.error("Error al cargar películas:", err);
            peliculasContainer.innerHTML = "<p>Error al cargar películas.</p>";
        }
    }

    async function cargarFuncionesDePelicula(pelicula, cine) {
        peliculaNombreSpan.textContent = pelicula.titulo;
        funcionesContainer.innerHTML = "<p>Cargando funciones...</p>";
        funcionesSection.style.display = "block";
        formularioSection.style.display = "none";

        try {
            const res = await fetch(`/api/cines/${cine.id}/peliculas/${pelicula.id}/funciones`);
            if (!res.ok) throw new Error("Error al cargar funciones");

            const funciones = await res.json();
            funcionesContainer.innerHTML = "";

            if (funciones.length === 0) {
                funcionesContainer.innerHTML = "<p>No hay funciones disponibles para esta película.</p>";
                return;
            }

            funciones.forEach(funcion => {
                const card = document.createElement("div");
                card.className = "card";
                card.innerHTML = `
                    <p><strong>Fecha:</strong> ${funcion.horario}</p>
                    <button class="btn-comprar">Conseguir entradas</button>
                `;

                const btn = card.querySelector(".btn-comprar");
                btn.addEventListener("click", () => mostrarFormularioCompra(funcion));
                funcionesContainer.appendChild(card);
            });
        } catch (err) {
            console.error("Error al cargar funciones:", err);
            funcionesContainer.innerHTML = "<p>Error al cargar funciones.</p>";
        }
    }

    async function mostrarFormularioCompra(funcion) {

        //const res = await fetch(`/api/funciones/${funcion.id}/entradas/asientos-ocupados`);
        //if (!res.ok) throw new Error("Error al obtener asientos");

        //const asientosOcupados = await res.json();
        const todosLosAsientos = generarAsientos();
        //const asientosDisponibles = todosLosAsientos.filter(a => !asientosOcupados.includes(a));

        //const options = asientosDisponibles.map(a => `<option value="${a}">${a}</option>`).join("");
        const options = todosLosAsientos.map(a => `<option value="${a}">${a}</option>`).join("");

        formularioContainer.innerHTML = `
            <form class="form-compra">
                <label for="asiento">Elegí un asiento:</label><br>
                <select name="asiento" required>${options}</select><br>

                <input type="hidden" name="precio" value="25">
                <p><strong>Precio:</strong> $25</p>

                <button type="submit">Ok</button>
            </form>
        `;

        formularioSection.style.display = "block";

        const formCompra = formularioContainer.querySelector("form");
        formCompra.addEventListener("submit", async (e) => {
            e.preventDefault();
            const asiento = formCompra.asiento.value;
            const precio = parseFloat(formCompra.precio.value);

            try {
                const res = await fetch("/api/entradas", {
                    method: "POST",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        funcion,
                        asiento,
                        precio
                    })
                });

                mostrarFormularioDePago(precio, funcion);

                if (!res.ok) throw new Error("Error al guardar entrada");
                await res.json();
            } catch (err) {
                console.error("Error al guardar entrada:", err);
                alert("No se pudo completar la compra.");
            }
        });
    }


    async function mostrarFormularioDePago(precio, funcion) {

        console.log("FUNCION: ", funcion);
        console.log("PRECIO: ", precio);

        const resTipos = await fetch("/api/tipo-pago");
        const tipos = await resTipos.json();

        const opciones = tipos.map(tipo =>
            `<option value="${tipo}">${tipo.charAt(0) + tipo.slice(1).toLowerCase()}</option>`
        ).join("");

        const pagoSection = document.createElement("section");
        pagoSection.innerHTML = `
            <h3>Pago</h3>
            <form id="form-pago">
                <label for="tipo">Tipo de pago:</label>
                <select name="tipo" required>
                    ${opciones}
                </select><br><br>

                <label for="monto">Monto:</label>
                <input type="number" name="monto" value="${precio}" readonly><br><br>

                <button type="submit">Realizar pago</button>
            </form>
        `;

        formularioContainer.innerHTML = "";
        formularioContainer.appendChild(pagoSection);
        formularioSection.style.display = "block";

        const formPago = document.getElementById("form-pago");
        formPago.addEventListener("submit", async (e) => {
            e.preventDefault();

            const tipoPago = formPago.tipo.value;
            const monto = parseFloat(formPago.monto.value);

            try {
                // Crear el pago
                console.log("Tipo de pago seleccionado:", tipoPago);
                console.log("Monto:", monto);

                const resPago = await fetch("/api/pagos", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify({
                        tipo: tipoPago,
                        monto: monto
                    })
                });

                if (!resPago.ok) throw new Error("Error al registrar el pago");

                const pago = await resPago.json();

                // Crear la venta
                console.log("cliente: ", cliente.id);
                console.log("funcion: ", funcion.id);
                console.log("pago:", pago.id);
                const resVenta = await fetch("/api/ventas", {
                    method: "POST",
                    headers: { "Content-Type": "application/json" },
                    body: JSON.stringify({
                        cliente,
                        funcion,
                        fecha: new Date().toISOString().slice(0, 19),
                        pago
                    })
                });

                if (!resVenta.ok) throw new Error("Error al registrar la venta");

                const venta = await resVenta.json();

                // Mostrar el comprobante
                mostrarComprobante(venta, pago);

            } catch (err) {
                console.error(err);
                alert("Ocurrió un error al procesar la compra.");
            }
        });
    }

    function mostrarComprobante(venta, pago) {
        console.log("Funcion: ", venta.funcion);
        const funcionData = venta.funcion;
        const pelicula = funcionData.pelicula?.titulo || "Película";
        const cine = funcionData.cine?.nombre || "Cine X";
        const horario = funcionData.horario;

        formularioContainer.innerHTML = `
            <h3>¡Compra realizada con éxito!</h3>
            <p><strong>Cliente:</strong> ${cliente.nombre}</p>
            <p><strong>Cine:</strong> ${cine}</p>
            <p><strong>Película:</strong> ${pelicula}</p>
            <p><strong>Horario:</strong> ${horario}</p>
            <p><strong>Monto pagado:</strong> $${pago.monto}</p>
            <p><strong>Tipo de pago:</strong> ${pago.tipo}</p>
            <p><strong>Fecha:</strong> ${pago.fecha}</p>
        `;

        formularioSection.style.display = "block";
    }

    function generarAsientos() {
        const filas = 10;
        const columnas = ['A', 'B', 'C', 'D', 'E', 'F'];
        const asientos = [];

        for (let i = 1; i <= filas; i++) {
            for (let letra of columnas) {
                asientos.push(`${i}${letra}`);
            }
        }
        return asientos;
    }

    cargarCines();

});
