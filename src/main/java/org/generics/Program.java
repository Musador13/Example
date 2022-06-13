package org.generics;

public class Program {

    public static void main(String[] args) {

        Account<String> acc1 = new Account<>("1876", 4500);
        Account acc2 = new Account("3476", 1500);

        Transaction<Account> tran1 = new Transaction<>(acc1, acc2, 4000);
        tran1.execute();
        tran1 = new Transaction<>(acc2, acc1, 4500);
        tran1.execute();

    }
}

class Transaction<T extends Account> {

    private T from;
    private T to;
    private int sum;

    public Transaction(T from, T to, int sum) {
        this.from = from;
        this.to = to;
        this.sum = sum;
    }

    public void execute() {

        if (from.getSum() > sum) {
            from.setSum(from.getSum() - sum);
            to.setSum(to.getSum() + sum);
            System.out.printf("Account %s: %d \nAccount %s: %d \n",
                    from.getId(), from.getSum(), to.getId(), to.getSum());
        } else {
            System.out.println("Operation is invalid");
        }
    }
}

class Account<T> implements Accountable<T> {

    private T id;
    private int sum;

    Account(T id, int sum) {
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