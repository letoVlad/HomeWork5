package ru.sber.school.reflection.proxy;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Class<CalculatorImpl> myCalculator = CalculatorImpl.class;

        //Задача 2: Вывод всех методов
        Method[] allMethods = myCalculator.getDeclaredMethods();
        System.out.println("Вывод всех методов ");
        for (Method method : allMethods) {
            System.out.println(method.getName());
        }

        //Задача 3: Вывод get методов
        System.out.println(" ----------------   ");
        Pattern getterPattern = Pattern.compile("^get[A-Z].*");
        System.out.println("Все геттеры класса");
        for (Method method : allMethods) {
            if (getterPattern.matcher(method.getName()).find()) {
                System.out.println(method.getName());
            }
        }

        //Задача 4: Проверить что все String константы имеют значение = их имени
        System.out.println(" ----------------   ");
        Field[] allFields = myCalculator.getDeclaredFields();
        for (Field field : allFields) {
            if (field.getType() == String.class) {
                Object value = field.get(null);
                System.out.println(field.getName() + " = " + value);
            }
        }

        //Задача 5: Реализовать кэширующий прокси
        System.out.println(" ----------------   ");
        CalculatorImpl realCalculator = new CalculatorImpl();
        Calculator proxyCalculator = new CachingProxyCalculator(realCalculator);

        System.out.println(proxyCalculator.calc(5));
        System.out.println(proxyCalculator.calc(5));
        System.out.println(proxyCalculator.calc(10));


        //Задача 5: Реализовать кэширующий прокси
        System.out.println(" Создать свою аннотацию Metric.  ");
        Calculator calculator = PerformanceProxy.createProxy(new CalculatorImpl());
        System.out.println(calculator.calc(5));
    }
}
