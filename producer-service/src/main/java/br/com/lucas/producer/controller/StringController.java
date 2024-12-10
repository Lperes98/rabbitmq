package br.com.lucas.producer.controller;

import br.com.lucas.producer.services.StringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produces")
public class StringController {

    @Autowired
    private StringService service;

    @GetMapping
    public ResponseEntity<String> produces(@RequestParam("msg") String msg) {
        service.produce(msg);
        return ResponseEntity.ok().body("Enviando MSG");
    }

}
