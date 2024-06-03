import com.google.gson.Gson;
import exception.MonedaFinalNoEncontradaException;
import exception.MonedaInicialNoEncontradaException;
import model.Moneda;
import model.MonedaER;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner entrada = new Scanner(System.in);
        Gson gson = new Gson();

        System.out.println("¡Bienvenido al Conversor de Monedas!");

        while(true){
            try {

                String monedaInicial;
                while (true) {
                    System.out.println("Ingrese el código ISO 4217 de la moneda inicial:");
                    monedaInicial = entrada.nextLine().toUpperCase();
                    if (monedaInicial.matches("[A-Z]{3}")) {
                        break;
                    } else {
                        System.out.println("Código ISO 4217 inválido. Por favor, ingrese un código válido de 3 letras.");
                    }
                }

                Double cantidad = null;
                while (true) {
                    System.out.println("Ingrese la cantidad que desea convertir:");
                    String cantidadInput = entrada.nextLine();
                    try {
                        cantidad = Double.parseDouble(cantidadInput);
                        if (cantidad < 0) {
                            System.out.println("La cantidad debe ser un número positivo. Por favor, ingrese una cantidad válida.");
                        } else {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Cantidad inválida. Por favor, ingrese un número válido.");
                    }
                }

                String monedaFinal;
                while (true) {
                    System.out.println("Ingrese el código ISO 4217 de la moneda final:");
                    monedaFinal = entrada.nextLine().toUpperCase();
                    if (monedaFinal.matches("[A-Z]{3}")) {
                        break;
                    } else {
                        System.out.println("Código ISO 4217 inválido. Por favor, ingrese un código válido de 3 letras.");
                    }
                }

                String direccion = "https://v6.exchangerate-api.com/v6/f274f5fe225023b4d82d857c/latest/"+monedaInicial;

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(direccion))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();

                MonedaER monedaER = gson.fromJson(json, MonedaER.class);

                if (monedaER.result().equals("error")) {
                    throw new MonedaInicialNoEncontradaException("La moneda inicial no se encontró: " + monedaInicial);
                }
                if (!monedaER.conversion_rates().containsKey(monedaFinal)) {
                    throw new MonedaFinalNoEncontradaException("La moneda final no se encontró: " + monedaFinal);
                }

                Moneda moneda = new Moneda(monedaER, monedaFinal);

                Conversor conversor = new Conversor();
                double resultado = conversor.conversorMoneda(moneda, cantidad);

                System.out.println(cantidad + " " + monedaInicial + " equivale a " + resultado + " " + monedaFinal);

            }catch (MonedaInicialNoEncontradaException | MonedaFinalNoEncontradaException e) {
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            String convertir;
            while (true) {
                System.out.println("¿Desea realizar otra conversion? 'SI' o 'NO'");
                convertir = entrada.nextLine();
                if (convertir.equalsIgnoreCase("SI") || convertir.equalsIgnoreCase("NO")) {
                    break;
                } else {
                    System.out.println("Por favor, responda 'SI' o 'NO'.");
                }
            }

            if (convertir.equalsIgnoreCase("NO")) {
                break;
            }


        }
        entrada.close();
    }
}