package com.united.drools.controller;

import com.united.drools.service.DiscountService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.united.drools.entity.Sale;

@RestController
public class DiscountController {

    private DiscountService discountService;

    public DiscountController(DiscountService service) {
        this.discountService = service;
    }

    @GetMapping("/discount/{flag}")
    public ResponseEntity<Sale> getDiscount(@PathVariable String flag){

        if(flag.equalsIgnoreCase("PASS")){
            Sale s = discountService.getFestivalDiscount();
            return new ResponseEntity<Sale>(s, HttpStatus.OK);
        }else{
            throw new ResourceNotFoundException();
        }
    }
}