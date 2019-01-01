package com.javadevjournal;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.javadevjournal.data.Product;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GsonSpringBootApplicationTests {

    private Product product;

    @Before
    public void setup(){
        product =new  Product("123","Demo Product",123);
    }

    @Test
    public void simpleGsonTest() throws JSONException {
        String expected = "{\n" +
                "\"code\": \"123\",\n" +
                "\"name\": \"Demo Product\",\n" +
                "\"price\": 123\n" +
                "}";

        Gson gson = new GsonBuilder().create();
        String data= gson.toJson(product);

        JSONAssert.assertEquals(expected,data,false);
    }

    @Test
    public void errorGsonTest() throws JSONException {
        String expected = "{\n" +
                "\"code\": \"1233\",\n" +
                "\"name\": \"Demo Product\",\n" +
                "\"price\": 123\n" +
                "}";

        Gson gson = new GsonBuilder().create();
        String data= gson.toJson(product);

        JSONAssert.assertEquals(expected,data,false);
    }

}

