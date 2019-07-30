package com.hand.position.controller;

import com.hand.position.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController {
    @Autowired
    PositionService positionService;
}
