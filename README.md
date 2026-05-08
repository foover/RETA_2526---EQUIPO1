<!-- ================================================== -->

<!-- IMAGEN DE PORTADA                                  -->

<!-- Añadir aquí la imagen/banner principal del proyecto -->

<!-- Ejemplo: ![Portada](ruta/a/la/imagen.png)           -->

<!-- ================================================== -->

<h1 align="center">⚙️ RETA 2526 – EQUIPO 1</h1>

<h3 align="center">Documentación, diseño de base de datos y aplicación Java</h3>

<p align="center">
  <img src="https://img.shields.io/badge/Estado-En%20desarrollo-yellow?style=for-the-badge" alt="Estado">
  <img src="https://img.shields.io/badge/Última%20actualización-Mayo%202026-blue?style=for-the-badge" alt="Última actualización">
  <img src="https://img.shields.io/badge/Contribuidores-3-green?style=for-the-badge" alt="Contribuidores">
</p>

---

# 📚 Tabla de contenidos

* [📖 Descripción del proyecto](#-descripción-del-proyecto)
* [👥 Equipo](#-equipo)
* [📁 Estructura del repositorio](#-estructura-del-repositorio)
* [🛠️ Tecnologías y herramientas](#️-tecnologías-y-herramientas)
* [📝 Documentación](#-documentación)
* [📊 Diagramas](#-diagramas)
* [🗺️ Roadmap](#️-roadmap)
* [🤝 Contribuciones](#-contribuciones)
* [📄 Licencia](#-licencia)

---

# 📖 Descripción del proyecto

Proyecto colaborativo desarrollado por el **Equipo 1** para la materia **RETA 2526**.

El objetivo principal del repositorio es centralizar toda la documentación técnica, diagramas, diseño de base de datos y desarrollo progresivo de una aplicación Java conectada a una base de datos MySQL.

La arquitectura prevista del proyecto contempla:

* Una aplicación Java como núcleo principal del sistema.
* Una base de datos MySQL alojada en un servidor Ubuntu.
* Un entorno Apache/Tomcat encargado de servir la aplicación desde el mismo servidor.
* Comunicación entre la aplicación y la base de datos mediante JDBC.

Actualmente el foco del proyecto se encuentra en:

* Diseño y planificación de la base de datos.
* Elaboración de diagramas ER y modelo relacional.
* Organización de la documentación técnica.
* Preparación de la estructura inicial para el desarrollo de la aplicación Java.

Parte del desarrollo y prototipos ya se encuentran distribuidos en distintas ramas del repositorio.

---

# 👥 Equipo

| Integrante    | GitHub                                                             |
| ------------- | ------------------------------------------------------------------ |
| Daniel Zabala | [@foover](https://github.com/foover)                               |
| Joaquín López | [@joaquinlopezperez](https://github.com/joaquinlopezperez)         |
| Rubén Ortiz   | [@Rub3nOL](https://github.com/Rub3nOL)                             |
| Mario Revilla | [@MarioRevillaAbarquero](https://github.com/MarioRevillaAbarquero) |
---

# 📁 Estructura del repositorio

```text
.
├── BD/
│   └── Diagramas/
├── documentacion/
│   ├── cuaderno_trabajo.md
│   ├── instrucciones_cuaderno_trabajo.md
│   └── notas.txt
├── .github/
│   └── ISSUE_TEMPLATE/
└── README.md
```

> ℹ️ Es posible visitar las distintas ramas del proyecto para ver el desarrollo.

---

# 🛠️ Tecnologías y herramientas

| Tecnología / Herramienta | Uso dentro del proyecto               |
| ------------------------ | ------------------------------------- |
| Draw.io / diagrams.net   | Diseño de diagramas y modelado        |
| Markdown                 | Documentación técnica                 |
| Git / GitHub             | Control de versiones y colaboración   |
| Java                     | Desarrollo de la aplicación principal |
| MySQL                    | Sistema de gestión de base de datos   |
| Apache                   | Servidor web y aplicaciones           |
| Ubuntu Server            | Sistema operativo del servidor        |

---

# 📝 Documentación

* [Cuaderno de trabajo](./documentacion/cuaderno_trabajo.md)

- Se añadira más documentación en las proximas semanas


---

# 📊 Diagramas

| Diagrama          | Estado        | Archivo                        |
| ----------------- | ------------  | ------------------------------ |
| Diagrama ER       | 🟢 Completado | */BD/Diagramas/DiagramaER.jpg* |
| Modelo relacional | 🔴 Pendiente  | *(por definir)*                |

---

# 🗺️ Roadmap

* [ ] **Fase 1: Análisis y modelado de datos (en curso)**
  Definir requerimientos, elaborar diagrama ER, construir modelo relacional y redactar documentación técnica inicial.

* [ ] **Fase 2: Implementación de la base de datos**
  Crear scripts SQL de creación, insertar datos de prueba y desarrollar consultas de verificación.

* [ ] **Fase 3: Desarrollo de la aplicación Java**
  Utilizando Maven desarrollaremos la aplicación Java conectando esta a MySQL a través del servidor Apache.

* [ ] **Fase 4: Despliegue en servidor Ubuntu + Apache**
  Configurar Ubuntu Server, instalar y asegurar MySQL, instalar Apache/Tomcat o PHP My Admin (Aún por decidir) y desplegar la aplicación verificando la conexión entre servicios.

* [ ] **Fase 5: Pruebas finales y ajustes**
  Realizar pruebas de integración y carga, corregir errores, generar documentación de despliegue y redactar manual de usuario.

> 💡 Consejo: consulta las ramas del repositorio para visualizar las primeras implementaciones relacionadas con el código Java.

---

# 🤝 Contribuciones

Este repositorio corresponde a un trabajo académico desarrollado por el **Equipo 1** para la materia RETA 2526.

Toda la organización del trabajo, asignación de tareas y seguimiento del progreso puede consultarse en el cuaderno de trabajo y documentación asociada.

---

# 📄 Licencia

<!-- ================================================== -->

<!-- ESPACIO RESERVADO PARA LA LICENCIA DEL PROYECTO    -->

<!-- Añadir aquí el texto completo de la licencia       -->

<!-- ================================================== -->

*Este proyecto todavía no tiene una licencia definida.*

Estamos valorando el uso de MIT o GNU GPL v3

<!-- ================================================== -->

<!-- EJEMPLO FUTURO CON LICENCIA MIT                    -->

<!--                                                     -->

<!-- ## Licencia                                         -->

<!-- Este proyecto está bajo la licencia MIT.            -->

<!-- Consulta el archivo LICENSE para más información.   -->

<!-- ================================================== -->
