package com.mrbook.controller;

import com.mrbook.entity.Week;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @RequestMapping("/")
    public List<Week> index(@RequestParam(defaultValue = "201713160402") String stuNumber) {

    }
}
