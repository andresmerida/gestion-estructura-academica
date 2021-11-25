package org.curso.gea.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GreetingResource {

    @GetMapping
    public String greeting() {
        return "Hello world.";
    }
}
