package org.StreamAPI;


import java.util.ArrayList;
import java.util.Optional;

public class OptionalClass {

    public static void main(String[] args) {
        /*
        Операции сведения, такие как min, max, reduce, возвращают
        объект Optional<T>. Этот объект фактически обертывает результат операции.
        После выполнения операции с помощью get() мы можем получить его значение.
        Но если поток не содержит вообще никаких данных программа выдаст
        NoSuchElementException.

        Можно предварительно проверить наличие значения в Optional с помощью
        метода isPresent(). Он возвращает true, если значение присутствует.

        Можно определить методом orElse() альтернативное значение, которое будет возвращаться,
        если Optional не получит из потока какого нибудь значения:
     */
        ArrayList<Integer> numbers = new ArrayList<>();
        Optional<Integer> min = numbers.stream().min(Integer::compare);
        System.out.println(min.orElse(-1));

    }

}
