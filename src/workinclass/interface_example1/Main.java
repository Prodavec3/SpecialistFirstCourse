package workinclass.interface_example1;

// Задача: сортировка ящиков по объему, по строке

// Используем Comparable для if(obj.compareTo(obj2))
// Для использования специального закона сравнения - Comparator: if(cmprtr.compare(obj1, obj2))

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Box[] boxes = {
                new Box(10, 1, 1),
                new Box(2,2,2),
                new Box(1,10,10),
        };

        Arrays.sort(boxes); // Сортировка объектов задана только у реализующих интерфейс Comparable

        System.out.println("Сортировка по площади:");

        for (Box box : boxes){
            System.out.println(box);
        }

        // Сортировка с помощью Comparator
        // Чтобы передать в сортировку новый закон сравнения -
        // надо создать новый класс реализующий интерфейс Comparator

        // Для создания объекта внутреннего класса команда new должна быть привязана к объекту внешнего класса

        // Box.CompareByA compareByA = boxes[0].new CompareByA();
        // Arrays.sort(boxes, compareByA);

        // Box.CompareByA compareByA = new Box.CompareByA(); // т.к static - теперь не привязываемся к объекту
        // Arrays.sort(boxes, compareByA);

        // Arrays.sort(boxes, Box.compareByA()); // Локальный класс (что для обычного что для анонимного)

        // Просто Анонимный класс
        /* Arrays.sort(boxes, new Comparator<Box>() {
            @Override
            public int compare(Box b1, Box b2) {
                return b1.getA() - b2.getA();
            }
        });*/

        Arrays.sort(boxes, (b1, b2) -> b1.getA() - b2.getA()); // Лямбда выражение

        // Лямбда выражение - компактная запись анонимного класса с одним методом

        System.out.println("\nСортировка по стороне а:");

        for (Box box : boxes){
            System.out.println(box);
        }
    }
}