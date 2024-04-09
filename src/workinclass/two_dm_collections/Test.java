package workinclass.two_dm_collections;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList<Number> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(75);

        ArrayList<ArrayList<String>> bigList = new ArrayList<>();
        bigList.add(new ArrayList<>());
        bigList.get(0).add("Hello"); // Добавление верхнего левого элемента
    }
}
