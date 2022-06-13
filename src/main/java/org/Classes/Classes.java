package org.Classes;

public class Classes {

    public static void main(String[] args) {

        Operation op = Operation.SUM;
        System.out.println(op.action(11, 22));
        op = Operation.SUBTRACT;
        System.out.println(op.action(123, 23));
        op = Operation.MULTIPLY;
        System.out.println(op.action(11, 12));
    }
}

/**
 * Перечисления, как и обычные классы, могут определять конструкторы,
 * поля и методы(можно определять методы для отдельных констант)
 */
enum Operation {
    SUM {
        public int action(int x, int y) {return x + y;}
    },
    SUBTRACT {
        public int action(int x, int y) {return x - y;}
    },
    MULTIPLY {
        public int action(int x, int y) {return x * y;}
    };

    public abstract int action(int x, int y);
}