package Code;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsInJava {
    public static void main(String[] args) {
        System.out.println();
//        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<Integer> evens = numbers.stream()
//                .filter(n -> n % 2 == 0)   // Filter even numbers
//                .map(n -> n * 2)           // Multiply by 2
//                .toList(); // Collect into a List
//        System.out.println(evens);
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        IntStream doubledNumbersStream = numbers.stream()
                .mapToInt(n -> n * 2);
//        doubledNumbersStream.forEach(System.out::println);
        ArrayList<Integer> ar = new ArrayList<>(2);
        ar.add(2);
        ar.add(4);
        int[] arr = ar.stream().filter(n -> n % 2 == 0).mapToInt(n -> n * 2).toArray();
//        System.out.println(Arrays.toString(arr));

        OptionalInt s = IntStream.rangeClosed(1, 10).filter(n -> n % 2 == 0).max();
//        System.out.println(s.isPresent() ? s.getAsInt() : Integer.MIN_VALUE);
//        System.out.println("min: "+Integer.MIN_VALUE);
//        System.out.println("max: "+Integer.MAX_VALUE);
//        System.out.println("signed min: "+(-Integer.MAX_VALUE));
        Predicate<Integer> p = integer -> {
//            for (int i = 0; i < 10; i++) {
//                if (i%2==0) System.out.println(i);
//            }
            return false;
        };
//        p.test(-1);
        Predicate<?> pre;
        Function<String, Integer> fun;
        Consumer<Thread> con;
        Supplier<Integer> sup;
        Optional<Integer> op;
        Iterator<String> it = Collections.emptyIterator();//Given Iterator is an Interface


        OptionalDouble minDouble = DoubleStream.of(2.5, 3.4, 1.1).min();


        //Basic Filtering
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntStream stream = list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n);
//        stream.forEach(System.out::println);

        //String Uppercase
        List<String> str = List.of("apple", "banana", "mango");
        Stream<String> st = str.stream()
                .map(String::toUpperCase);
//        st.forEach(System.out::println);

        //Count numbers
        list = List.of(3, 4, 10, 2, 10, 12, 45, 75, 4); //3
//        long ns = list.stream().filter(n->n>10).count();

        // Min and Max
        List<Double> nums = List.of(2.5, 3.8, 1.2, 4.5, 0.9, 7.1, 5.3);
        nums.iterator();

        OptionalDouble min = nums.stream().mapToDouble(Double::doubleValue).min();
        OptionalDouble max = nums.stream().mapToDouble(Double::doubleValue).max();

        //collecting to list
        Stream<Integer> streams = list.stream().filter(n -> n % 3 == 0);
        streams.forEach(System.out::println);

        //Intermediate Questions
        // Grouping Data:
        List<Person> lp = new ArrayList<>(4);
        lp.add(new Person(20, "A"));
        lp.add(new Person(18, "B"));
        lp.add(new Person(20, "C"));
        lp.add(new Person(18, "D"));

        Map<Integer, List<Person>> map = lp.stream().collect(Collectors.groupingBy(Person::getAge));
        System.out.println(map);

        // Joining Strings
        List<String> l = new ArrayList<>(3);
        l.add("A");
        l.add("B");
        l.add("C");
        System.out.println(l.stream().collect(Collectors.joining(",", "[", "]")));

        // Distinct values
        List<Integer> il = new ArrayList<>(5);
        il.add(1);
        il.add(3);
        il.add(2);
        il.add(3);
        il.add(1);
        System.out.println(il.stream().distinct().toList());

        //Mapping to Custom Objects:
        List<String> ls = List.of("Alchemist", "MokingBird", "Black Heart", "The Dull Sun in my heart");
        String fa = "Rohit";
        ls.stream().map(title -> new Bok(fa, title)).toList().forEach(System.out::println);
        List<List<Integer>> lofl = List.of(
                List.of(1, 2, 3),
                List.of(3, 4, 5),
                List.of(5, 6, 7)
        );
        lofl.stream().flatMap(Collection::stream).distinct().toList().forEach(System.out::print);

        // Advanced Questions
        //Stream Reduction:
        System.out.println("\n" + il.stream().distinct().reduce(1, (i, j) -> i * j));

        //Opetional Based filtering
        List<Optional<Person>> lop = List.of(
                Optional.of(new Person(1, "X")),
                Optional.empty(),
                Optional.of(new Person(2, "Y")),
                Optional.empty(),
                Optional.of(new Person(3, "Z")),
                Optional.empty()
        );
        lop.stream().flatMap(Optional::stream).toList().forEach(System.out::println);

        //Sequential and parallel Streams Time conversion
        List<Integer> num = new ArrayList<>();
        for (int i = 0; i < 100_000_000; i++) {
            num.add(i);
        }

        // Sequential Stream
        long startTimeSeq = System.currentTimeMillis();
        long sumSeq = num.stream()
                .mapToInt(Integer::intValue)
                .sum();
        long endTimeSeq = System.currentTimeMillis();
        System.out.println("Sequential Stream Sum: " + sumSeq + ", Time Taken: " + (endTimeSeq - startTimeSeq) + "ms");

        // Parallel Stream
        long startTimePar = System.currentTimeMillis();
        long sumPar = num.parallelStream()
                .mapToInt(Integer::intValue)
                .sum();
        long endTimePar = System.currentTimeMillis();
        System.out.println("Parallel Stream Sum: " + sumPar + ", Time Taken: " + (endTimePar - startTimePar) + "ms");

        //Custom Collector
        List<String> lofs = List.of("A", "E", "F", "G", "B", "C", "D");
        System.out.println(lofs.stream().collect(Collectors.toCollection(() -> new TreeSet<>(String.CASE_INSENSITIVE_ORDER))));
    }
}

class Bok {
    String Author;
    String Title;

    Bok(String author, String title) {
        this.Author = author;
        this.Title = title;
    }

    @Override
    public String toString() {
        return "Bok{" +
                "Author='" + Author + '\'' +
                ", Title='" + Title + '\'' +
                '}';
    }
}

class Person {
    int age;
    String name;

    Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
