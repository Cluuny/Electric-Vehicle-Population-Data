package co.edu.uptc.model.dataManage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class JsonConvertorService {

    private final ObjectMapper objectMapper;

    public JsonConvertorService() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
       SimpleModule module = new SimpleModule();
        this.objectMapper.registerModule(module);
        this.objectMapper.registerModule(new JavaTimeModule());        
    }

    public <T> void objectToJson(ArrayList<T> objects, String outputFile) throws IOException {
        try (FileWriter fileWriter = new FileWriter(outputFile)) {
            objectMapper.writeValue(fileWriter, objects);
        }
    }

    public <T> T jsonToObject(String inputFile, TypeReference<T> typeReference) throws IOException {
        
        File file = new File(inputFile);
        /*return objectMapper.readValue(file, typeReference);*/
        
        //version 2

    
        ObjectReader reader = objectMapper.readerFor(typeReference);
        return  reader.readValue(new File(inputFile));
        
        
    }

    private void compresion(){


        
    }

    
}

