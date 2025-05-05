# App2 - Gestión de Cultivos

## Descripción
Este proyecto es una aplicación de gestión de cultivos diseñada para ayudar a una empresa agrícola a mantener un registro de sus cultivos, parcelas y actividades de mantenimiento. La aplicación permite gestionar cultivos y parcelas, registrar actividades, generar reportes y persistir datos en un archivo CSV.

## Estructura del Proyecto
El proyecto está organizado en los siguientes paquetes:

- **src/models**: Contiene las clases que representan los modelos de datos, como `Cultivo`, `Parcela`, `Actividad` y `ElementoAgricola`.
- **src/services**: Contiene los servicios que gestionan la lógica de negocio, incluyendo `CultivoService`, `ParcelaService`, `ActividadService` y `ReporteService`.
- **src**: Contiene la clase principal `App2.java`, que inicia la aplicación.

## Requisitos
- Java 16 o superior
- Un entorno de desarrollo Java configurado

## Compilación y Ejecución
Para compilar y ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio:
   ```
   git clone https://github.com/matildavasquezdevi/App2.git
   ```

2. Navega al directorio del proyecto:
   ```
   cd App2
   ```

3. Compila el código fuente:
   ```
   javac -cp src -d bin src/models/*.java src/services/*.java App2.java
   ```

   Esto compilará los archivos `.java` y colocará los `.class` en el directorio `bin`.

4. Ejecuta la aplicación desde el directorio `bin`:
   ```
   java -cp bin App2 cultivos.csv
   ```

   Asegúrate de que el archivo `cultivos.csv` esté ubicado en el directorio del proyecto.

## Funcionalidades
La aplicación ofrece las siguientes funcionalidades a través de un menú en consola:

- **Gestión de Cultivos**
  - Listar cultivos existentes.
  - Crear un nuevo cultivo.
  - Eliminar un cultivo (solo si no tiene actividades pendientes).
  - Editar la información básica de un cultivo.

- **Gestión de Parcelas**
  - Listar parcelas con sus cultivos.
  - Agregar una parcela.
  - Eliminar una parcela (solo si no tiene cultivos activos).
  - Editar una parcela.
  - Asignar un cultivo a una parcela.

- **Gestión de Actividades**
  - Registrar actividad para un cultivo.
  - Listar actividades por cultivo.
  - Eliminar actividad.
  - Marcar actividad como completada.

- **Búsqueda/Reporte**
  - Buscar cultivos por nombre o variedad.
  - Generar reportes de cultivos activos, cosechados o en riesgo.

- **Persistencia**
  - Al salir, se guardarán todos los cambios en el archivo `cultivos.csv`.

## Contribuidores
- Matilda Vasquez
- Juan Pablo Salum
- Lucas Colombo
- Alvaro Astudillo
- Julian Epple
