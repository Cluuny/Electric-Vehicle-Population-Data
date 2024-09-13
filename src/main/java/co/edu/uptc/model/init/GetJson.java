package co.edu.uptc.model.init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetJson {

    public String getJsonData(String urlParam) throws IOException {
        URL url = new URL(urlParam);
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            } else {
                response.append("ERROR");
            }
            connection.disconnect();
        } catch (Exception e) {
            response.append(e.getMessage());
        }
        return response.toString();
    }

}