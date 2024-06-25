package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controller {

    @Autowired
    private Environment environment;

    @Autowired
    private BasicService basicService;

    Logger logger = (Logger) LoggerFactory.getLogger(Controller.class);

    @GetMapping("/")
    public String getInfo() {

        logger.info("You have greeted someone");
        return basicService.greetings();
    }

    @GetMapping("/exp")
    public int exponent() {

        int base = Integer.parseInt(environment.getProperty("myCustomVarTree.intA"));
        int exp = Integer.parseInt(environment.getProperty("myCustomVarTree.intB"));

        return basicService.calculateExp(base,exp);
    }

    @GetMapping("/get-errors")
    public void errors(){
        basicService.exception();
    }
}