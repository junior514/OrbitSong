# OrbitSong

## Descripción General

OrbitSong es una aplicación móvil de música en desarrollo, diseñada para ofrecer una experiencia de usuario fluida para la gestión y reproducción de contenido musical. Esta aplicación se conecta a una API RESTful personalizada desarrollada con **Spring Boot**, que a su vez se encarga de la interacción con la base de datos **MySQL** para el almacenamiento y recuperación de toda la información relacionada con los usuarios, canciones, artistas y listas de reproducción.

## Características Principales (en desarrollo)

* **Gestión de Usuarios:** Permite a los usuarios registrarse, iniciar sesión y gestionar sus perfiles.
* **Exploración de Música:** Posibilidad de buscar y explorar canciones, álbumes y artistas.
* **Listas de Reproducción:** Creación y gestión de listas de reproducción personalizadas.
* **Reproducción de Audio:** Integración para la reproducción de archivos de audio (funcionalidad a ser implementada).
* **Conexión a API:** Interacción con un backend robusto para el manejo de datos.

## Arquitectura

La aplicación sigue una arquitectura cliente-servidor:

* **Frontend (Aplicación Móvil):** Desarrollada en Android (Java), se encarga de la interfaz de usuario y la lógica de presentación.
* **Backend (API RESTful):** Desarrollada con **Spring Boot**, sirve como intermediario entre la aplicación móvil y la base de datos. Se encarga de la lógica de negocio, la autenticación y la autorización.
* **Base de Datos:** **MySQL**, gestionada a través de MySQL Workbench, almacena toda la información persistente de la aplicación (usuarios, canciones, etc.).

## Tecnologías Utilizadas

### Frontend (Android)
* **Lenguaje de Programación:** Java
* **Frameworks/Librerías:** Retrofit (para la comunicación con la API), Glide (o similar para carga de imágenes), etc.

### Backend (API)
* **Framework:** Spring Boot
* **Lenguaje de Programación:** Java
* **Base de Datos:** MySQL

### Base de Datos
* **Sistema de Gestión de Bases de Datos (SGBD):** MySQL
* **Herramienta de Gestión:** MySQL Workbench

* **Diagrama de BD**
    ![Pantalla de Registro](https://i.postimg.cc/NMYRYd6g/bd.jpg)

## Estructura del Proyecto (Frontend - Android)

El proyecto Android está organizado de la siguiente manera:

* `app/src/main/java/com/example/orbitsong`: Contiene el código fuente de la aplicación.
    * `activities`: Actividades principales de la aplicación (ej. `GenerarActivity`, `InicioSesionActivity`, `RegistroActivity`).
    * `api`: Clases relacionadas con la comunicación con la API.
        * `ApiClient`: Cliente HTTP para realizar peticiones.
        * `ApiService`: Interfaz que define los endpoints de la API.
    * `models`: Clases que representan los modelos de datos (ej. `Usuario`).
* `app/src/main/res`: Recursos de la aplicación (layouts, drawables, valores, etc.).

## Instalación y Configuración (Para desarrollo)

### Requisitos
* Android Studio
* Java Development Kit (JDK)
* Un emulador de Android o un dispositivo físico.
* MySQL Workbench (para la gestión de la base de datos).
* Un entorno de desarrollo para Spring Boot (IDE como IntelliJ IDEA o Eclipse con Spring Tools Suite, Maven o Gradle).

### URL del Backend
1.  **https://github.com/junior514/APIMusic**

📸 Capturas de Pantalla
Pantallas Principales
<div align="center">
  <table>
    <tr>
      <td align="center">
        <img src="https://i.postimg.cc/cCkx9Jxp/Inicio.png" width="200px" alt="Pantalla Principal"/>
        <br><b>🏠 Pantalla Principal</b>
      </td>
      <td align="center">
        <img src="https://i.postimg.cc/fyRWfdN7/Iniciar-Sesion.png" width="200px" alt="Inicio de Sesión"/>
        <br><b>🔐 Inicio de Sesión</b>
      </td>
      <td align="center">
        <img src="https://i.postimg.cc/66Mp5MrM/Registro.png" width="200px" alt="Registro"/>
        <br><b>📝 Registro</b>
      </td>
    </tr>
  </table>
</div>
Navegación y Contenido
<div align="center">
  <table>
    <tr>
      <td align="center">
        <img src="https://i.postimg.cc/Y0d9533y/Artboard-4.png" width="200px" alt="Géneros"/>
        <br><b>🎵 Géneros Musicales</b>
      </td>
      <td align="center">
        <img src="https://i.postimg.cc/hPGh9k4F/Artboard-5.png" width="200px" alt="Género Seleccionado"/>
        <br><b>🎯 Género Seleccionado</b>
      </td>
      <td align="center">
        <img src="https://i.postimg.cc/kGJGYZxb/Artboard-6.png" width="200px" alt="Lista de Reproducción"/>
        <br><b>📋 Lista de Reproducción</b>
      </td>
    </tr>
  </table>
</div>
Reproducción y Biblioteca
<div align="center">
  <table>
    <tr>
      <td align="center">
        <img src="https://i.postimg.cc/TYH1QthK/Artboard-7.png" width="200px" alt="Reproducción"/>
        <br><b>▶️ Reproductor</b>
      </td>
      <td align="center">
        <img src="https://i.postimg.cc/59g6Q4Vq/Artboard-8.png" width="200px" alt="Biblioteca"/>
        <br><b>📚 Biblioteca</b>
      </td>
      <td align="center">
        <img src="https://i.postimg.cc/Dw9Z3mrF/Artboard-9.png" width="200px" alt="Artistas"/>
        <br><b>🎤 Artistas</b>
      </td>
    </tr>
  </table>
</div>
Detalles de Artista y Álbumes
<div align="center">
  <table>
    <tr>
      <td align="center">
        <img src="https://i.postimg.cc/R0w0S9dt/Artboard-10.png" width="200px" alt="Artista Seleccionado"/>
        <br><b>⭐ Perfil de Artista</b>
      </td>
      <td align="center">
        <img src="https://i.postimg.cc/x1JCZLbt/Artboard-11.png" width="200px" alt="Álbumes"/>
        <br><b>💿 Álbumes</b>
      </td>
      <td align="center">
        <img src="https://i.postimg.cc/Ssqxj51v/Artboard-12.png" width="200px" alt="Canciones del Álbum"/>
        <br><b>🎶 Canciones del Álbum</b>
      </td>
    </tr>
  </table>
</div>
Perfil de Usuario
<div align="center">
  <table>
    <tr>
      <td align="center">
        <img src="https://i.postimg.cc/C1NL8NWL/Artboard-13.png" width="200px" alt="Perfil"/>
        <br><b>👤 Perfil de Usuario</b>
      </td>
    </tr>
  </table>
</div>
👥 Equipo de Desarrollo
<div align="center">
  <table>
    <tr>
      <td align="center">
        <b>🧑‍💻 Paico Valverde Brayan</b><br>
        <sub>Desarrollador Frontend</sub>
      </td>
      <td align="center">
        <b>🧑‍💻 Paico Valverde Junior</b><br>
        <sub>Desarrollador Backend</sub>
      </td>
      <td align="center">
        <b>🧑‍💻 Frans Espinoza Pilco</b><br>
        <sub>Desarrollador Full Stack</sub>
      </td>
    </tr>
    <tr>
      <td align="center">
        <b>🧑‍💻 Garcia Bracho Maickel Adrian</b><br>
        <sub>Desarrollador Mobile</sub>
      </td>
      <td align="center">
        <b>🧑‍💻 Cristhoper Thomy Gotto Santa Cruz</b><br>
        <sub>Desarrollador Backend</sub>
      </td>
    </tr>
  </table>
</div>
