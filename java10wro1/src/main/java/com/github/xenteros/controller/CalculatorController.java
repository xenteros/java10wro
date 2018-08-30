package com.github.xenteros.controller;

import com.github.xenteros.dto.CalculationResultDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calculations")
public class CalculatorController {

    @GetMapping("/add")
    public CalculationResultDto add(@RequestParam Long a, @RequestParam Long b) {
        Long result = a+b;
        return new CalculationResultDto(a,b,result);
    }

    @GetMapping("divide")
    public CalculationResultDto divide(@RequestParam Long a, @RequestParam Long b){
        Long result = a/b;
        return new CalculationResultDto(a,b,result);
    }
}
