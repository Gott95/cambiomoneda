# Conversor de Monedas (Java Console)

Este proyecto es una aplicación de consola en Java que permite convertir entre diferentes monedas utilizando la API pública de ExchangeRate-API.

## Características
- Menú interactivo en consola.
- Conversión entre las siguientes monedas:
  - Dólar estadounidense (USD) y Peso Cubano (CUP)
  - Dólar estadounidense (USD) y Real Brasileño (BRL)
  - Dólar estadounidense (USD) y Peso Colombiano (COP)
- Consulta de tasas de cambio en tiempo real usando la API ExchangeRate-API.
- Manejo de errores y validación de entradas.

## Estructura del Proyecto
- `Principal.java`: Clase principal, inicia la aplicación.
- `MenuConversor.java`: Muestra el menú y gestiona la interacción con el usuario.
- `ConversorMoneda.java`: Lógica de consulta a la API y conversión de monedas.

## Requisitos
- Java 8 o superior
- [org.json](https://mvnrepository.com/artifact/org.json/json) (debes agregar el JAR manualmente si no usas Maven/Gradle)

## Instalación y Ejecución
1. Clona o descarga este repositorio.
2. Descarga el archivo `json-20230618.jar` desde [Maven Central](https://repo1.maven.org/maven2/org/json/json/20230618/json-20230618.jar) y colócalo en una carpeta `lib` dentro del proyecto.
3. Agrega el JAR al classpath de tu proyecto en tu IDE (por ejemplo, IntelliJ IDEA: clic derecho en el JAR > "Add as Library...").
4. Compila y ejecuta la clase `Principal`.

## Uso
1. Al iniciar, verás un menú con las opciones de conversión.
2. Selecciona la opción deseada e ingresa el monto a convertir.
3. El resultado se mostrará en pantalla.
4. Puedes realizar varias conversiones hasta elegir la opción de salir.

## Notas
- El proyecto utiliza una API Key pública de ejemplo. Si necesitas mayor uso, regístrate en [ExchangeRate-API](https://www.exchangerate-api.com/) para obtener tu propia clave.
- Si deseas agregar más monedas, solo debes modificar el menú y los códigos de moneda en `MenuConversor.java`.

