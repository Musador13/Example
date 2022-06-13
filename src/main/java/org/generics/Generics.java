package org.generics;

public class Generics {

    public static void main(String[] args) {

    }
}

/**
 * Создаем обобщенный интерфейс
 * @param <T> универсальный параметр(вместо него можно подставить любой тип)
 */
interface Accountable<T> {
    T getId();
    int getSum();
    void setSum(int sum);
}

// Реализация интерфейса, когда для T задается конкретный тип.
// Тогда класс, реализующий интерфейс, жестко привязан к этому типу.
class Account1 implements Accountable<String> {

    private String id;
    private int sum;

    Account1(String id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public int getSum() {
        return sum;
    }

    @Override
    public void setSum(int sum) {
        this.sum = sum;
    }
}

// Реализуем представление обобщенного класса, который также использует тот же универсальный параметр
class Account2<T> implements Accountable<T> {

    private T id;
    private int sum;

    Account2(T id, int sum) {
        this.id = id;
        this.sum = sum;
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public int getSum() {
        return sum;
    }

    @Override
    public void setSum(int sum) {
        this.sum = sum;

    }
}

// Реализация обобщенного конструктора
class Account3 {

    private String id;
    private int sum;

    // Конструктор принимает параметр id, который представляет тип T.
    // В конструкторе его значение превращается в строку и сохраняется.
    <T>Account3(T id, int sum) {
        this.id = id.toString();
        this.sum = sum;
    }

    public String getId() {
        return id;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}


