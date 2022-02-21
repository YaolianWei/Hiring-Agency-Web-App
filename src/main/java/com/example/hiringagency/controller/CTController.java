package com.example.hiringagency.controller;

import com.example.hiringagency.service.CTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CTController {

    @Autowired
    private CTService ctService;
}
