package com.javadevjournal;

import org.junit.Test;
import org.junit.Assert;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class JavaEncodeExampleTest {

    String expectedURL="https://www.javadevjournal.com?secretKey=test_6H%217%26DCepBtGGx-b&name=Java+Dev+Journal&email=contact-us%40javadevjournal.com";  //final encoded URL

    @Test
    public void test_url_encoding(){

        Map<String, String> params = new HashMap<>();  //query string parameters

        params.put("name","Java Dev Journal");
        params.put("email","contact-us@javadevjournal.com");
        params.put("secretKey","test_6H!7&DCepBtGGx-b");

        String encodedURL = params.entrySet()
                              .stream()
                              .map(e->e.getKey() + "=" +encode(e.getValue()))
                              .collect(Collectors.joining("&","https://www.javadevjournal.com?",""));

        assertThat(expectedURL,is(encodedURL));
    }

    public static String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }

        return "";
    }
}
