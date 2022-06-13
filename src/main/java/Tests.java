
public class Tests {
    int a = 5;
    protected int b = 6;
    public int c = 7;
}

class Baz {
    public static void main(String[] args) {
        Tests f = new Tests();
        System.out.print(" " + f.a);
        System.out.print(" " + f.b);
        System.out.print(" " + f.c);
    }
}
