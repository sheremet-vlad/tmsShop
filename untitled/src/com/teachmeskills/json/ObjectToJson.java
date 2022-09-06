package com.teachmeskills.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ObjectToJson {

    public <T> void ConvertToJSON(T t, String path) throws IOException {


        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(Paths.get("contractAsFile.json").toFile(), t);

        objectMapper.writeValueAsString(t);
    }

    public <T> T ConvertFromJONtoObject(Class<T> classz, String path) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(new File(path), classz);
    }
}