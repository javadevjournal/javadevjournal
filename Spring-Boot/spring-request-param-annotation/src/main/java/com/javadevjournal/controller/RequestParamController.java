package com.javadevjournal.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p></p>This is an the main controller for our @RequestParam annotation post.It conatins different methods to demonstrate
 * the features of the @RequestParam annotation.</p>
 */
@RestController
public class RequestParamController {

    /**
     * <p> A very basic method to demonstrate as how to use the @RequestParam annotation.</p>
     * @param name
     * @return response
     */
    @GetMapping("/greeting")
    public String sayHello(@RequestParam String name){
        return "Hello "+name+" !!!";
    }


    /**
     *<p>Method displaying, how to use parameter name while using this annotation</p>
     * @param id
     * @return response
     */
    @GetMapping("/getUser")
    public String getUser(@RequestParam(name = "email") String id){
        return "It seems we have record for email "+id;
    }

    /**
     *<p>Method for demonstrating the use of <em>defaultValue</em> in @RequestParam annotation.</p>
     * @param name
     * @return response
     */
    @GetMapping("/default-value")
    public String defaultValueExample(@RequestParam(defaultValue = "Anonymous user") String name){
        return "Hello "+name+"!!!";
    }

    /**
     *<p>Method for demonstrating how to enable optional parameter using this annotation.</p>
     * @param name
     * @return response
     */
    @GetMapping("/optional")
    public String optional(@RequestParam(required = false) String name){
        return getGreeting(name);
    }

    /**
     *<p>Multi-value parameter example using <em>@RequestParam</em> annotation</p>
     * @param id
     * @return
     */
    @GetMapping("/products")
    public String getProducts(@RequestParam List<String> id){
        return "Products: "+id;
    }


    private String getGreeting(final String name){
        if(StringUtils.isEmpty(name)){
            return "Hello Stranger!!";
        }

        return "Hello "+name+" !!!";
    }
}
