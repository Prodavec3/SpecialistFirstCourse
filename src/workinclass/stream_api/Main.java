package workinclass.stream_api;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> list = Stream.of("a", "b", "bc").
                filter(item -> item.contains("b")).
                collect(Collectors.toList());

        System.out.println("Вывод первого элемента содержащего b" +
                list.stream().findFirst().get());

        /*for (String str:arrayList
             ) {
            System.out.println(str);
        }*/

        List<String> list2 = Arrays.asList("abc1", "ab2", "abc3");
        long size = list2.stream().skip(1).
                map(item -> item.substring(0, 3)).sorted().count();
        // skip - убрали, map - отображение информации, вывод будет abc abc

        System.out.println(size);
    }
}