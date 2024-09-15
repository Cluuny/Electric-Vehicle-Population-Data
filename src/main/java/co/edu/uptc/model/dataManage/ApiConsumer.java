package co.edu.uptc.model.dataManage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.zip.GZIPInputStream;

import org.json.JSONObject;

public class ApiConsumer {

    public static String getData(){
        try {
            URI uri = new URI("https://data.wa.gov/api/views/f6w7-q2d2/rows.json");
            URL url = uri.toURL();

            // Utilizando HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);  // 5 segundos para tiempo de conexión
            connection.setReadTimeout(10000);    // 10 segundos para tiempo de lectura
            connection.setRequestProperty("Accept-Encoding", "gzip");

            // Comprobar el código de respuesta HTTP
            int responseCode = connection.getResponseCode();
            if (responseCode != HttpURLConnection.HTTP_OK) {
                System.out.println("Error: Código de respuesta HTTP " + responseCode);
                return null;
            }

            InputStream inputStream;
            if ("gzip".equals(connection.getContentEncoding())) {
                inputStream = new GZIPInputStream(connection.getInputStream());
            } else {
                inputStream = connection.getInputStream();
            }


            // Usar un BufferedReader con un tamaño de búfer más grande
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream), 16 * 1024)) {  // Tamaño del búfer de 16KB
                StringBuilder result = new StringBuilder(2048);  // Inicializar con capacidad mayor para grandes datos
                char[] buffer = new char[8192];  // Leer por bloques de 8KB
                int length;
                
                // Leer el JSON por bloques
                while ((length = reader.read(buffer)) != -1) {
                    result.append(buffer, 0, length);  // Añadir los datos al StringBuilder
                }

                return result.toString();
            }

        } catch (Exception e) {
            e.printStackTrace();  // Registrar excepciones para ayudar en la depuración
        } 

        return null;
    }

    

    public static void writeDataInJson(){
        File dataJson = new File("src\\main\\java\\co\\edu\\uptc\\model\\files\\data.json");
        if(!dataJson.exists()){
            try {
                dataJson.createNewFile();
            } catch (Exception e) {
                System.out.println("Error al crear el archivo");
            }
        }

        String data = getData(); // Obtén los datos
        if (data == null || data.isEmpty()) {
            System.out.println("Error: No se recibieron datos de getData()");
            return;
        }

        System.out.println("Datos recibidos: " + data.substring(0, Math.min(data.length(), 200)));

        /*Si añadimos si escribimos el json object se escriben solo los datos, si 
         * añadimos String data se escribe todo el json con metadata
         */
        JSONObject jsonResponse = new JSONObject(data);

        try (FileWriter file = new FileWriter(dataJson)) {
            file.write(jsonResponse.toString(4)); 
            System.out.println("Data Saved in 'data.json'");
        } catch (IOException e) {
            System.out.println("Error saving the data: " + e.getMessage());
        }

    }

    

}