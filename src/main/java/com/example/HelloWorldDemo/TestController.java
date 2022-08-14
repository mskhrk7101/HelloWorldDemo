package com.example.HelloWorldDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/")
//public class TestController {
//    @GetMapping
//    public String ResMessage(){
//        JSONObject json = new JSONObject();
//        try {
//            json.put("message", "HelloWorld");
//            System.out.println(json);
//        } catch (JSONException ex) {
//            throw new RuntimeException(ex);
//        }
//        return "index";
//    }
//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }
//}

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @GetMapping("/prettyjson")
    @ResponseStatus(HttpStatus.OK)
    public String prettyjson() {

        TestModel model = new TestModel();
        model.setId(1);
        model.setMessage("HelloWorld");

        // インスタンス生成時に SerializationFeature.INDENT_OUTPUT を設定することで整形される
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        String json = "";

        try {
            json = mapper.writeValueAsString(model);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            System.out.println(e.getMessage());
        }
        return json;
    }
}