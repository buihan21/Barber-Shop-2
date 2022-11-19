package com.jspmodel.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;

public class HttpUtil {
    private String data;

    public HttpUtil(String data){
        this.data = data;
    }

    // Convert json to String
    public static HttpUtil of (BufferedReader br){
        try{
            StringBuilder json = new StringBuilder();
            String value;
            while ((value = br.readLine()) != null){
                json.append(value);
            }
            return  new HttpUtil(json.toString());
        } catch (IOException e){
            return null;
        }
    }
    // convert String map to models
    public <T> T toModel(Class<T> toClass){
        try {
            return new ObjectMapper().readValue(this.data, toClass);
        } catch (IOException e){
            System.out.print(e.getMessage());
            return null;
        }
    }
}
