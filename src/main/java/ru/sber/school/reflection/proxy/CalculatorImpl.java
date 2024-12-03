package ru.sber.school.reflection.proxy;

public class CalculatorImpl implements Calculator {
    private int one = 324;
    private int two = 324;

    public static final String FIRST = "FIRST";
    public static final String SECOND = "SECOND";
    public static final String THIRD = " ";


    public int getOne() {
        return one;
    }

    public void setOne(int one) {
        this.one = one;
    }

    public int getTwo() {
        return two;
    }

    public void setTwo(int two) {
        this.two = two;
    }


    private int sumTwoNumbers(int one, int two) {
        return one + two;
    }

    @Override
    public int calc(int arg) {
        System.out.println("Вызван calc:" + arg);
        try {
            System.out.println("Производятся супер сложные вычисления");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return arg * 5;
    }

    private void countCrow() {
        System.out.println("ызван countCrow");
    }

    private int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }
}
