package com.javadevjournal;


import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;


public class JavaDecodeExampleTest {


    /*
       expected values
       "name","Java Dev Journal"
       "email","contact-us@javadevjournal.com"
       "secretKey","test_6H!7&DCepBtGGx-b"
     */

    @Test
    public void test_url_decoder() throws MalformedURLException {
        URL url =new URL("https://www.javadevjournal.com?secretKey=test_6H%217%26DCepBtGGx-b&name=Java+Dev+Journal&email=contact-us%40javadevjournal.com");
        Map<String, List<String>> decodedParams= decodeQuery(url);
        System.out.println(decodedParams);

    }

    public Map<String, List<String>> decodeQuery(URL url) {

       return Arrays.stream(url.getQuery().split("&"))
                .map(this::splitQueryParameter)
                .collect(Collectors.groupingBy(AbstractMap.SimpleImmutableEntry::getKey, LinkedHashMap::new, mapping(Map.Entry::getValue, toList())));

    }

    public AbstractMap.SimpleImmutableEntry<String, String> splitQueryParameter(String it) {
        final int idx = it.indexOf("=");
        final String key = idx > 0 ? it.substring(0, idx) : it;
        final String value = idx > 0 && it.length() > idx + 1 ? it.substring(idx + 1) : null;
        return new AbstractMap.SimpleImmutableEntry<>(key, decode(value));
    }

    private String decode(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }

}
