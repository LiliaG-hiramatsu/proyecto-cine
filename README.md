# 🎬 Proyecto Cine

Aplicación web desarrollada en Java con Spring Boot y JPA para la gestión de entradas en cines. Permite a los clientes elegir un cine, seleccionar una película en una función disponible, registrar sus datos y comprar entradas.

## 🚀 Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **JPA (Hibernate)**
- **MySQL**
- **Gradle**

## 📦 Entidades principales

- **Cine**: contiene información de cada cine disponible.
- **Sala**: salas asociadas a un cine, donde se proyectan funciones.
- **Película**: catálogo de películas disponibles.
- **Función**: programación de películas (cine, sala, horario).
- **Cliente**: nombre y DNI del comprador.
- **Entrada**: entrada individual asociada a una función y cliente.
- **Venta**: registro de la operación de compra.
- **Pago**: información del medio de pago utilizado.

## 🛠️ Instalación y ejecución

1. Clonar el repositorio:
   ```bash
   git clone https://github.com/LiliaG-hiramatsu/proyecto-cine.git
   cd proyecto-cine
  

2. Crear la base de datos en MySQL:

   ```sql
   CREATE DATABASE db_cine;
   ```

3. Configurar `application.properties`:
   Configurar los datos de conexión a tu base de datos:

   ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/db_cine?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=
    
    spring.jpa.show-sql=true
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
    
    #Variable de entorno
    server.port=9000
   ```


## 🧩 Funcionalidades principales

* Visualización de cines disponibles.
* Selección de películas y funciones por cine.
* Registro simple de cliente.
* Compra de entradas asociadas a una función.
* Registro de venta y pago.
* Generación de entradas.

**Autor**: Lilia Garcia Hiramatsu
