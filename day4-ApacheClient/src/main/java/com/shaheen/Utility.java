package com.shaheen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class Utility<T> {
    public T map(HttpResponse httpResponse, TypeReference<T> typeReference) {
        try {
            String jsonString = EntityUtils.toString(httpResponse.getEntity());
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonString, typeReference);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
