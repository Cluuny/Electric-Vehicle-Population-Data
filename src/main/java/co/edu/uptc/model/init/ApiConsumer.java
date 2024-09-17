package co.edu.uptc.model.init;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.zip.GZIPInputStream;

public class ApiConsumer {

    public String getData() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI("https://data.wa.gov/api/views/f6w7-q2d2/rows.json"))
                    .header("Accept-Encoding", "gzip")
                    .build();

            // Enviar la solicitud y obtener la respuesta comprimida
            HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());

            // Comprobar el código de respuesta HTTP
            if (response.statusCode() != 200) {
                System.out.println("Error: Código de respuesta HTTP " + response.statusCode());
                return null;
            }

            InputStream inputStream = response.body();
            if ("gzip".equals(response.headers().firstValue("Content-Encoding").orElse(""))) {
                inputStream = new GZIPInputStream(inputStream);
            }

            // Usar un BufferedReader para leer los datos eficientemente
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream), 16 * 1024)) {
                StringBuilder result = new StringBuilder(2048);
                char[] buffer = new char[8192];
                int length;
                while ((length = reader.read(buffer)) != -1) {
                    result.append(buffer, 0, length);
                }
                return result.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // public static void writeDataInJson(){
    // File dataJson = new
    // File("src\\main\\java\\co\\edu\\uptc\\model\\files\\data.json");
    // if(!dataJson.exists()){
    // try {
    // dataJson.createNewFile();
    // } catch (Exception e) {
    // System.out.println("Error al crear el archivo");
    // }
    // }

    // String data = getData(); // Obtén los datos
    // if (data == null || data.isEmpty()) {
    // System.out.println("Error: No se recibieron datos de getData()");
    // return;
    // }

    // System.out.println("Datos recibidos: " + data.substring(0,
    // Math.min(data.length(), 200)));

    // /*Si añadimos si escribimos el json object se escriben solo los datos, si
    // * añadimos String data se escribe todo el json con metadata
    // */
    // JSONObject jsonResponse = new JSONObject(data);

    // try (FileWriter file = new FileWriter(dataJson)) {
    // file.write(jsonResponse.toString(4));
    // System.out.println("Data Saved in 'data.json'");
    // } catch (IOException e) {
    // System.out.println("Error saving the data: " + e.getMessage());
    // }

    // }

}