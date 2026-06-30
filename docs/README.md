# Sistema de Gestión de Ingreso y Salida Vehicular

Aplicación de escritorio desarrollada en Java para el control y registro de acceso vehicular a un establecimiento o estacionamiento. Permite gestionar el ingreso, salida y consulta de vehículos de forma centralizada mediante una base de datos relacional.

## 📋 Descripción

El sistema busca automatizar el proceso de control vehicular, reemplazando registros manuales en papel por una solución digital que permite llevar un historial preciso de los vehículos que ingresan y salen de un establecimiento, facilitando la consulta y generación de reportes.

## ⚙️ Funcionalidades

- **Registro de ingreso**: captura de placa, hora de entrada y datos del vehículo/conductor.
- **Registro de salida**: actualización del registro con hora de salida.
- **Consulta de vehículos**: búsqueda de vehículos activos (dentro del establecimiento) e historial de movimientos.
- **CRUD completo**: creación, lectura, actualización y eliminación de registros.
- **Reportes**: listado de vehículos por fecha o estado (dentro/fuera).

## 🛠️ Tecnologías utilizadas

- **Lenguaje:** Java
- **IDE:** Eclipse
- **Base de datos:** MySQL
- **Paradigma:** Programación Orientada a Objetos (POO)

## 🗄️ Modelo de base de datos

El sistema cuenta con un modelo relacional compuesto principalmente por:

- **Vehículos**: información del vehículo (placa, tipo, color, etc.)
- **Usuarios/Conductores**: datos de la persona asociada al vehículo.
- **Registros de acceso**: historial de ingresos y salidas, con fecha y hora.

## 🚀 Cómo ejecutar el proyecto

1. Clonar el repositorio:
```bash
   git clone https://github.com/tu-usuario/sistema-ingreso-salida-vehicular.git
```
2. Importar el proyecto en Eclipse como proyecto Java existente.
3. Configurar la conexión a la base de datos MySQL (ver archivo de configuración de conexión).
4. Ejecutar el script SQL incluido para crear la base de datos y tablas.
5. Ejecutar la clase principal (`Main.java`) desde Eclipse.


## 📌 Estado del proyecto

Proyecto académico desarrollado como práctica de programación orientada a objetos y manejo de bases de datos relacionales.

## 👤 Autor

**Aaron Facundo Marcelo Santillan Elescano**  
Estudiante de Ingeniería de Sistemas Computacionales – UPN
