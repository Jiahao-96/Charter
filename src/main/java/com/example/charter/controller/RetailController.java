package com.example.charter.controller;

import com.example.charter.service.RetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/retail")
@Slf4j
public class RetailController {
    @Autowired
    private RetailService retailService;

    @GetMapping("/pointsCalculatorTest")
    public ResponseEntity<String> pointsCalculatorTest(){
        String str = retailService.calculatePoints();
        System.out.println(str);
        return new ResponseEntity<>(str, HttpStatus.OK);
    }
}
