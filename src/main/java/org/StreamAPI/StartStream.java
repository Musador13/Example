package org.StreamAPI;

import java.util.*;
import java.util.stream.Stream;

public class StartStream {

    /**
     * С помощью данного метода можно реализовать постраничную навигацию
     */
    private static void pageNavigationStream() {

        List<String> phones = new ArrayList<>(); phones.addAll(
                Arrays.asList("iPhone 6 S", "Lumia 950", "Huawei Nexus 6P", "Samsung Galaxy S 6", "LG G 4",
                              "Xiaomi MI 5", "ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 5", "Lenovo S 850"));

        int pageSize = 3;   // количество элементов на странице.
        Scanner scanner = new Scanner(System.in); while (true) {

            System.out.println("Введите номер страницы: "); int page = scanner.nextInt();

            if (page < 1) {
                break;    // нумерация страниц с 1, если меньше выходим из цикла.
            }

            phones.stream().skip((long) (page - 1) * pageSize) // skip(long n) пропускает n элементов.
                    .limit(pageSize) // выборка первых n элементов, возвращаемый поток не больше n.
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {

        reduceStream3();
        //        minMaxStream();
        //        pageNavigationStream();
    }

    /**
     * Метод reduce выполняет терминальные операции сведения, возвращая
     * некоторое значение - результат операции.
     * Перрвая форма возвращает результат в виде объекта Optional<T>.
     */
    private static void reduceStream1() {

        /*
            Вычислим произведение всех чисел потока.
            Чтобы получить резултат из объекта Optional - get().
         */
        Stream<Integer> numbersStream = Stream.of(1, 2, 3, 4, 5, 6);
        Optional<Integer> result = numbersStream.reduce((x, y) -> x * y); System.out.println(result.get());

        /*
            Объединим слова
         */
        Stream<String> wordsStream = Stream.of("One", "two", "Tree");
        Optional<String> sentence = wordsStream.reduce((x, y) -> x + " " + y); System.out.println(sentence.get());
    }

    /**
     * Эта версия метода принимает два параметра:
     * T reduce(T identity, BinaryOperator<T> accumulator).
     * <p>
     * T identity - начальное значение для функции из второго параметра, а также
     * значение по умолчанию, если поток не имеет элементов.
     * <p>
     * BinaryOperator<T> accumulator - как и первая форма представляет функцию, которая
     * запускается для каждого элемента в потоке и принимает два параметра.
     */
    private static void reduceStream2() {

        Stream<Integer> numberStream = Stream.of(-4, 3, -2, 1);
        int identity = 1;
        int result = numberStream.reduce(identity, (x, y) -> x * y);
        System.out.println(result);
    }

    /**
     * Третья форма метода reduce:
     * U reduce(U identity, BiFunction<U,? super T,U> accumulator, BinaryOperator<U> combiner)
     * Первый параметр указавыет значение по умолчанию.
     * Второй параметр получает промежуточное значение.
     * Третий параметр представляет бинарную операцию, которая суммирует
     * все промежуточные значения.
     */
    private static void reduceStream3() {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600), new Phone("Pixel 2", "Google", 500),
                                              new Phone("iPhone 8", "Apple", 450),
                                              new Phone("Nokia 9", "HMD Global", 150),
                                              new Phone("Galaxy S9", "Samsung", 300));

        int sum = phoneStream.reduce(0, (x, y) -> {
            if (y.getPrice() > 400) {
                return x + y.getPrice();
            }
            else {
                return x + 0;
            }
        }, (x, y) -> x + y);
        System.out.println(sum);
    }

    /**
     * В качестве источника потока можно использовать коллекции.
     * В интерфейсе {@link java.util.Collection} есть два метода для работы с потоками.
     * default Stream<E> stream: возвращает поток из коллекции.
     * default Stream<E> parallelStream: возвращает параллельный поток данных.
     */
    private static void startStream1() {

        ArrayList<String> cites = new ArrayList<>();

        Collections.addAll(cites, "Paris", "London", "Moscow");

        /*
            С помощью вызова cities.stream получаем поток, которые использует
            данные из списка cities.
            С помощью каждой промежуточной операции, применённой к потоку,
            получается поток с учетом модификаций.
         */
        cites.stream()      // Получаем поток
                .filter(s -> s.length() == 6)   // фильтрация по длине строки
                .forEach(s -> System.out.println(s));   // вывод строк
        /*
            Важно, что после использования терминальных операций другие операции
            к этому потоку уже не могут быть применены, т.к. поток уже употреблен.
            Жизненный цикл потока:
            1. Создание потока.
            2. Применение к потоку ряда промежуточных операций.
            3. Применение к потоку терминальной операции и получение результата.
         */
    }

    /**
     * Один из способов создания потока, который создает поток из массива:
     */
    private static void startStream2() {
        Stream<String> citiesStream = Arrays.stream(new String[]{"New York", "Madrid", "St.Petersburg"});
        citiesStream.forEach(s -> System.out.println(s));
    }

    /**
     * Способ создания потока, представляющий метод of(T..values) класса Stream.
     */
    private static void startStream3() {
        Stream<String> countryStream = Stream.of("America", "Germany", "Russia");
        countryStream.forEach(s -> System.out.println(s));

        // можно передать массив
        String[] cities = {"Oslo", "Kiev"}; Stream<String> citiesStream = Stream.of(cities);

        citiesStream.forEach(s -> System.out.println(s));
    }

    /**
     * Отображенние или маппинг позволяет задать функцию преобразования одного
     * объекта в другой(получить из элемента одного типа элемент другого типа).
     * Для отображения используется метод map:
     * <R> Stream<R> map(Function<? super T, ? extends R> mapper).
     * Передаваемая в map функция задает преобразование от типа T к типу R.
     * В результате возвращается новый поток с преобразованными объектами.
     */
    private static void mapStream() {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600), new Phone("Pixel 2", "Google", 500),
                                              new Phone("iPhone 8", "Apple", 450),
                                              new Phone("Nokia 9", "HMD Global", 150),
                                              new Phone("Galaxy S9", "Samsung", 300));

        /*
         * Преобразование от типа Phone к типу String.
         */
        phoneStream.map(p -> p.getName())  // операция помещает в новый поток только названия.
                .forEach(s -> System.out.println(s));
    }

    /**
     * flatMap выполняет плоское отображение(когда из одного элемента нужно получить несколько).
     */
    private static void flatMapStream() {
        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600), new Phone("Pixel 2", "Google", 500),
                                              new Phone("iPhone 8", "Apple", 450),
                                              new Phone("Nokia 9", "HMD Global", 150),
                                              new Phone("Galaxy S9", "Samsung", 300));

        phoneStream.flatMap(
                p -> Stream.of(String.format("name: %s price without discount: %d", p.getName(), p.getPrice()),
                               String.format("name: %s price with discount: %d", p.getName(),
                                             p.getPrice() - (int) (p.getPrice() * 0.1)))).forEach(
                s -> System.out.println(s));
    }

    /**
     * Данный метод подходит только для сортировки объектов,
     * реализующих интерфейс Comparable.
     */
    private static void sortedStream1() {
        List<String> phones = new ArrayList<>();
        Collections.addAll(phones, "Iphone xr", "Samsung galaxy 9", "iPhone X", "Nokia 9", "Huawei Nexus 6P",
                           "Samsung Galaxy S8", "LG G6", "Xiaomi MI6", "ASUS Zenfone 3", "Sony Xperia Z5",
                           "Meizu Pro 6", "Pixel 2");

        phones.stream().filter(p -> p.length() < 12).sorted().forEach(s -> System.out.println(s));
    }

    /**
     * Метод с использованием сортировки собственным компаратором
     */
    private static void sortedStream2() {

        Stream<Phone> phoneStream = Stream.of(new Phone("iPhone X", "Apple", 600), new Phone("Pixel 2", "Google", 500),
                                              new Phone("iPhone 8", "Apple", 450),
                                              new Phone("Nokia 9", "HMD Global", 150),
                                              new Phone("Galaxy S9", "Samsung", 300));

        phoneStream.sorted(new PhoneComparator()).forEach(
                phone -> System.out.printf("%s (%s) - %d \n", phone.getName(), phone.getCompany(), phone.getPrice()));
    }

    /**
     * Методы min() и max() в качестве параметра принимают объект интерфейса Comparator.
     * Оба метода возвращают элемент потока обернутый в объект Optional.
     */
    private static void minMaxStream() {

        ArrayList<Phone> phones = new ArrayList<>(
                Arrays.asList(new Phone("iPhone X", "Apple", 600), new Phone("Pixel 2", "Google", 500),
                              new Phone("iPhone 8", "Apple", 450), new Phone("Nokia 9", "HMD Global", 150),
                              new Phone("Galaxy S9", "Samsung", 300)));

        Phone min = phones.stream().min(Phone::compare).get(); Phone max = phones.stream().max(Phone::compare).get();

        //        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        //
        //        /*
        //            Методы min и max возвращают именно Optional, и чтобы получить непосредственно
        //            результат операции из Optional, необходимо вызвать метод get().
        //
        //         */
        //        Optional<Integer> min = numbers.stream().min(Integer::compare);
        //        Optional<Integer> max = numbers.stream().max(Integer::compare);
        //
        System.out.printf("MIN Name: %s Company: %s Price: %d \n", min.getName(), min.getCompany(), min.getPrice());
        System.out.printf("MAX Name: %s Company: %s Price: %d \n", max.getName(), max.getCompany(), max.getPrice());
    }
}

/**
 * Класс компаратор, который сортирует объекты по полю name.
 */
class PhoneComparator implements Comparator<Phone> {

    public int compare(Phone o1, Phone o2) {
        return o1.getName().toUpperCase(Locale.ROOT).compareTo(o2.getName().toUpperCase(Locale.ROOT));
    }
}

class Phone {

    private String name;
    private int price;

    private String company;

    public Phone(String name, String company, int price) {
        this.name = name; this.company = company; this.price = price;
    }

    public static int compare(Phone p1, Phone p2) {
        if (p1.getPrice() > p2.getPrice()) {
            return 1;
        } return -1;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

}