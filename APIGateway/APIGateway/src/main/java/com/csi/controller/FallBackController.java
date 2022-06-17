package com.csi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/customerfallback")
    public String customerFallBack(){
        return "Customer Service is down please wait!!!!!!!!";
    }

    @GetMapping("/billingfallback")
    public String billingFallBack(){
        return "Billing Service is down please wait!!!!!!!!";
    }
}
