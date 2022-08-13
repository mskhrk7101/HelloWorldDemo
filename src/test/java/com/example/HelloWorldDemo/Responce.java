package com.example.HelloWorldDemo;

import org.json.JSONException;
import org.json.JSONObject;

public class Responce {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        try {
            json.put("message", "HelloWorld");
            System.out.println(json);
        } catch (JSONException ex) {
            throw new RuntimeException(ex);
        }
    }
}
