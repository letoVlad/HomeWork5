package ru.sber.school.reflection.proxy;

public interface Calculator {
    @Metric
    @Cache
    int calc(int arg);
}
