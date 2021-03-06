![Java CI with Maven](https://github.com/LuisCusihuaman/algohoot-quiz-game/workflows/Java%20CI%20with%20Maven/badge.svg)
[![CodeFactor](https://www.codefactor.io/repository/github/luiscusihuaman/algohoot-quiz-game/badge?s=cfd93816a1514d3484def9091b96a96aa7fbb223)](https://www.codefactor.io/repository/github/luiscusihuaman/algohoot-quiz-game)
[![codecov](https://codecov.io/gh/LuisCusihuaman/tp2-algo3/branch/release/graph/badge.svg?token=RVU3RHXHU6)](https://codecov.io/gh/LuisCusihuaman/tp2-algo3)

# ☕🚀 Trabajo Práctico 2

## ℹ️ Introducción
Este repositorio corresponde al [TP2 Grupal](https://drive.google.com/file/d/1dvx7QjCFtL-zMiupm4ckqBG0udupYlpO) de la materia Algoritmos y Programación III.

La aplicación consiste en un juego por turnos, de dos jugadores conformado de un panel en el cual se mostraran preguntas con múltiples opciones de respuesta.

Informe: https://docs.google.com/document/d/1XKI0ZeenwJU9EhsrE2SpGps43ZtOaTs2KclpOaOsMTA/

### 🔨 Pre-requisitos
- JDK: OpenJDK 11
- Java build tool: Maven 3.6.3

### 🔧 Artefactos definidos en el pom.xml:

- JUnit 5.4.0 - Unit testing framework
- Mockito  3.3.0  - Mock testing framework
- JaCoCo  0.8.5 - Java Code Coverage Tool
- maven-compiler-plugin 3.8.0
- maven-surefire-plugin 3.0.0-M3

## 🛠️ Cómo empezar
1. Clonar este repositorio: `git clone https://github.com/LuisCusihuaman/tp2-algo3`.
2. Ejecutar estas [Maven lifecycle tasks](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle.html) en orden para verificar la integridad del proyecto:
    1. Compilar el modelo y los test: `mvn test-compile`
    2. Correr los tests, generará el reporte de coverage en **target/site/jacoco/index.html**: `mvn test`
3. ¡Comienza a desarrollar!

## 🏁 Cómo correr la aplicacion
1. Compilar la aplicacion: `mvn javafx:compile`
2. Correr la aplicacion: `mvn javafx:run`
3. ¡Jugar!

![app](https://raw.githubusercontent.com/LuisCusihuaman/algohoot-quiz-game/master/docs/algohoot.png)

## Grupo N06 - Integrantes

| Padrón | Apellido y Nombre       |
|--------|------------------------ |
| 103268 | [Cabral Matias Ezequiel](https://github.com/MatiasEzequielCabral)|
| 101805 | [Cusihuaman Luis Eduardo](https://github.com/LuisCusihuaman) |
| 103368 | [Esquivel Matias Wilfredo](https://github.com/MatuMasaru)|
| 102110 | [Schejtman Ezequiel](https://github.com/Ezequiel-Schejtman)    |
| 97548  | [Vasquez Kevin](https://github.com/kaibakev1984)	     |
