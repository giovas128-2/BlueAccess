# BlueAccess 🔐

**Prototipo de inicio de sesión y registro para Android**, desarrollado en Android Studio con Java, XML y Material Design 3.

> **Proyecto académico:** las operaciones de inicio de sesión, registro y recuperación de contraseña son simulaciones. No hay autenticación real, base de datos de usuarios ni envío de correos.

## Descripción

BlueAccess presenta una interfaz móvil de acceso con identidad visual azul y blanca. Incluye validación de formularios, navegación entre las pantallas de acceso y registro, recuperación de contraseña mediante un diálogo y adaptación al modo claro y oscuro.

## Funcionalidades

- **Inicio de sesión:** correo electrónico y contraseña, con validación de campos obligatorios, formato de correo y longitud mínima de contraseña.
- **Registro:** nombre completo, correo, contraseña y confirmación, con mensajes de error.
- **Recuperación de contraseña:** diálogo para introducir el correo; funcionamiento demostrativo.
- **Material 3:** campos delineados, botones, diálogos y opción para mostrar u ocultar contraseñas.
- **Tema adaptable:** recursos separados en `res/values` y `res/values-night`, con compatibilidad para colores dinámicos donde estén disponibles.
- **Retroalimentación:** mensajes de error y bienvenida.

## Diseño de interfaces

El proyecto incluye **bocetos** (idea inicial), **wireframes** (estructura en escala de grises) y **mockups** (propuesta visual de alta fidelidad con estilo de presentación Figma).

Las imágenes de diseño y las capturas reales se pueden incorporar en `docs/imagenes/` para documentar el proceso.

## Capturas de la aplicación

| Pantalla | Evidencia |
|---|---|
| Login en modo claro | Diseño principal del formulario |
| Login en modo oscuro | Adaptación de fondos, textos y botones |
| Registro en modo claro y oscuro | Formulario de creación de cuenta |
| Validación de inicio de sesión | Mensajes de error en los campos |
| Validación de registro | Comprobación de datos obligatorios |
| Recuperación de contraseña | Diálogo de solicitud simulada |
| Inicio de sesión de demostración | Mensaje de bienvenida |

> **Nota:** Las imágenes de evidencia se añadirán a esta sección cuando estén cargadas en el repositorio.

## Tecnologías

- **Lenguaje:** Java
- **Interfaz:** XML
- **IDE:** Android Studio
- **Diseño:** Material Design 3 (Material Components)
- **Construcción:** Gradle con Kotlin DSL
- **Pruebas manuales:** emulador Android Pixel 4

## Estructura principal

```text
app/src/main/
├── java/com/cg128/blueaccess/
│   ├── MainActivity.java
│   └── ui/
│       ├── LoginActivity.java
│       └── RegistroActivity.java
├── res/
│   ├── layout/
│   │   ├── activity_login.xml
│   │   └── activity_registro.xml
│   ├── values/
│   └── values-night/
└── AndroidManifest.xml
```

## Cómo ejecutar

1. Clona el repositorio o descárgalo como ZIP.
2. Abre la carpeta del proyecto en Android Studio.
3. Espera a que finalice la sincronización de Gradle.
4. Selecciona un emulador o dispositivo Android compatible.
5. Ejecuta el módulo `app`.
6. Prueba el login, el registro, los mensajes de validación y el modo oscuro.

## Pruebas realizadas

Se verificaron manualmente el comportamiento de los campos vacíos, el formato del correo, las contraseñas cortas, la navegación al registro, la apertura del diálogo de recuperación y la apariencia en ambos temas.

Estas comprobaciones muestran el comportamiento de la **interfaz**; no constituyen pruebas de autenticación contra un servidor.

## Datos académicos

- **Institución:** Tecnológico de Estudios Superiores del Oriente del Estado de México
- **Carrera:** Ingeniería en Sistemas Computacionales
- **Materia:** Diseño y Desarrollo de Interfaces Móviles
- **Tema:** Login
- **Alumno:** Hernández Pizano César Giovanni
- **Grupo:** 7S1
- **Profesor:** Gustavo Moisés Romero González

## Autor

Hernández Pizano César Giovanni

**Repositorio:** https://github.com/giovas128-2/BlueAccess
