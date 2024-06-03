# Conversor de Monedas

Este es un programa de conversión de monedas que utiliza la API de ExchangeRate-API para obtener las tasas de cambio en tiempo real. Permite a los usuarios convertir una cantidad de una moneda a otra utilizando los códigos ISO 4217 de las monedas.

## Requisitos

- Java 11 o superior instalado en tu sistema.
- Acceso a internet para poder realizar las consultas a la API de ExchangeRate-API.

## Cómo usar

1. Clona este repositorio o descarga el código fuente en tu dispositivo.
2. Abre una terminal o línea de comandos y navega hasta el directorio donde se encuentra el código fuente.
3. Compila el programa ejecutando el siguiente comando:
   ```
   javac Main.java
   ```
4. Una vez compilado, puedes ejecutar el programa con el siguiente comando:
   ```
   java Main
   ```
5. Sigue las instrucciones en pantalla para ingresar los códigos ISO 4217 de las monedas, la cantidad que deseas convertir y si deseas realizar otra conversión.

## Créditos

- Este proyecto utiliza la biblioteca Gson para el manejo de datos JSON. Puedes encontrar más información sobre Gson en [su página oficial](https://github.com/google/gson).
- La API de ExchangeRate-API proporciona las tasas de cambio en tiempo real. Puedes obtener más información sobre ExchangeRate-API en [su sitio web](https://www.exchangerate-api.com/).
