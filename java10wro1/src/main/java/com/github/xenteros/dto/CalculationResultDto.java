package com.github.xenteros.dto;

public class CalculationResultDto {

    private Long a;
    private Long b;
    private Long result;

    public CalculationResultDto(Long a, Long b, Long result) {
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public Long getA() {
        return a;
    }

    public Long getB() {
        return b;
    }

    public Long getResult() {
        return result;
    }
}
