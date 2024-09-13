package co.edu.uptc.model.init;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetJsonFromFile {
    public String getJson(){
        String content = "";
        try {
            ClassLoader classLoader = GetJsonFromFile.class.getClassLoader();
            InputStream is = classLoader.getResourceAsStream("rows.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);

            }
            content= sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }
}
