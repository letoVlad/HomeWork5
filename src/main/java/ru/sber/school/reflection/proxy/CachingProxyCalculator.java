package ru.sber.school.reflection.proxy;

import java.util.HashMap;
import java.util.Map;

public class CachingProxyCalculator implements Calculator {

    private final CalculatorImpl calculator;
    private final Map<Integer, Integer> cache = new HashMap();

    public CachingProxyCalculator(CalculatorImpl calculator) {
        this.calculator = calculator;
    }

    @Override
    public int calc(int arg) {
        return cache.computeIfAbsent(arg, calculator::calc);
    }
}
