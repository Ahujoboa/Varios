package com.nttdata.bootcamp.micro.demo.Controoler;

import org.springframework.http.ResponseEntity;

public interface DemoController {
    ResponseEntity<String> saludo();
}
