package org.LambdaApp;

public class Lambda {

    static int x = 10;
    static int y = 20;

    public static void main(String[] args) {

        Operational<Integer> operation1 = (x, y) -> x + y;
        Operational<String> operation2 = (x, y) -> x + y;

        System.out.println(operation1.calculate(20, 10));
        System.out.println(operation2.calculate("22", "22"));

        Operation op = () -> {
          x = 30;
          return x + y;
        };

        System.out.println(op.calculate());
        System.out.println(x);
    }
}

interface Operation {
    int calculate();
}

interface Operational<T> {
    T calculate(T x, T y);
}
