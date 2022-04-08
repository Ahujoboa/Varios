package com.nttdata.bootcamp.micro.demo.Controoler.Impl;

import com.nttdata.bootcamp.micro.demo.Controoler.DemoController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DecomControllerImpl implements DemoController {

    @GetMapping("/demo/funcion")
    public ResponseEntity<String> saludo() {
        return new ResponseEntity<String>(HttpStatus.OK).ok("Hola Mundo");
    }
}
