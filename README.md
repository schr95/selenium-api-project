# Taller 3 - Automatización con API y UI

## Introducción
Este proyecto implementa un flujo de pruebas donde se crea un usuario mediante la API, se autentica y elimina a través de la UI utilizando **Selenium** y **Rest Assured**. El proyecto utiliza **Gradle** como sistema de construcción y gestor de dependencias.

### Alumnos

- Sara Herrera Ramírez
- Julio Franco Ardila

## Reto 1

El reto fue realizado con un patrón de diseño **POM** para un mayor orden y facilidad en el manejo de las pruebas.
### Flujo de Prueba
1. Crear un usuario mediante la API de **demoqa** y verificar la creación con asserts.
2. Autenticarse en la interfaz web con **Selenium WebDriver**.
3. Eliminar al usuario desde la UI y validar el proceso de logout.
4. Intentar autenticarse nuevamente y verificar que se muestra el mensaje de error correcto.

### Funcionalidades Automatizadas

- **Create user**: Por medio de una petición POST se realiza la creación de un usuario.
- **Login**: Se realiza el login por medio de la interfaz gráfica
- **Delete user**: Se elimina el usuario por medio de la interfaz gráfica

## Requisitos

Para ejecutar el proyecto, necesitas tener instalados los siguientes componentes:

- **Java JDK** (versión 8 o superior)
- **Gradle**
- Este proyecto utiliza **WebDriverManager** para gestionar automáticamente las dependencias del navegador, por lo que no es necesario configurar manualmente **ChromeDriver** ni otros drivers de navegador.


## Configuración

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/schr95/selenium-api-project.git
   ```
2. Instalar las dependencias:

- Utiliza Gradle para gestionar las dependencias. Ejecuta el siguiente comando para compilar el proyecto y descargar las dependencias necesarias:

```bash
   gradle build
   ```

3. **Configurar el entorno de desarrollo**:
   - Utiliza un entorno de desarrollo integrado (IDE) como **IntelliJ IDEA** o **Eclipse**, y asegúrate de que las dependencias de **JUnit** y **Selenium WebDriver** estén correctamente configuradas.

## Estructura del Proyecto

El proyecto contiene la siguiente estructura principal:

```bash
/src
  └── /main/java/pages
    └── com.topicos.BasePage.java 
    └── com.topicos.LoginPage.java
    └── com.topicos.ProfilePage.java
  └── /test/java
    └── com.topicos.DemoQATest.java // Clase que contiene el test principal a evaluar
```

## Ejecución de las Pruebas

- Para compilar y ejecutar las pruebas:

```bash
gradle build clean test
```

- Revisar los resultados:

En consola se pueden revisar los resultados e impresiones de los pasos que se han logrado con exito.

## Notas Adicionales

- Si la estructura del sitio web cambia, puede ser necesario ajustar los **XPath** utilizados en las pruebas.
- Este proyecto fue desarrollado con fines educativos.


## Reto 2
El reto 2 consta de 4 request realizados en **POSTMAN** y la collection exportada en formato JSON se encuentra en la carpeta POSTMAN-NASA para fácil acceso

### Request elegidas

- **EARTH**
- **APOD**
- **NEoWS**
- **EPIC**

Se realizaron diferentes test post ejecución (status code, verificación de un campo de respuesta, tiempo de respuesta).
Además el manejo del api_key y url se hizo por varibles de ambiente globales en la collection.

