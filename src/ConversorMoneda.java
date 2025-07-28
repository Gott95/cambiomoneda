import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class ConversorMoneda {
    private static final String API_KEY = "2996f32dd26629d6cea4f491";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/";

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) throws IOException {
        double tasa = obtenerTasa(monedaOrigen, monedaDestino);
        return cantidad * tasa;
    }

    private double obtenerTasa(String monedaOrigen, String monedaDestino) throws IOException {
        String urlStr = API_URL + API_KEY + "/latest/" + monedaOrigen;
        URL url = new URL(urlStr);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();

        int responseCode = conn.getResponseCode();
        if (responseCode != 200) {
            throw new IOException("Error en la conexión a la API: " + responseCode);
        }

        StringBuilder inline = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());
        while (scanner.hasNext()) {
            inline.append(scanner.nextLine());
        }
        scanner.close();

        JSONObject data = new JSONObject(inline.toString());
        JSONObject rates = data.getJSONObject("conversion_rates");
        return rates.getDouble(monedaDestino);
    }
}

