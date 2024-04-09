package workinclass.interface_example1;

import java.util.Comparator;

public class Box implements Comparable<Box> {
    private int a, b, c;

    public Box(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    @Override
    public String toString() {
        return "Box{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public int volume() {
        return a * b * c;
    }

    @Override
    public int compareTo(Box rightValue) {
        return volume() - rightValue.volume();
    }

    // 1 вариант - локальный класс
    /* public static Comparator<Box> compareByA(){
        class CMPRTR implements Comparator<Box>{

            @Override
            public int compare(Box b1, Box b2) {
                return b1.a - b2.a;
            }
        }
        return new CMPRTR();
    }*/

    // 2 вариант - локальный анонимный класс
    /* public static Comparator<Box> compareByA(){
        return new Comparator<Box>() {  // Анонимный локальный класс может реализовывать только 1 интерфейс
                                        // или наследоваться от абстрактного класса и ни то ни другое одновременно
            @Override
            public int compare(Box b1, Box b2) {
                return b1.a - b2.a;
            }
        };
    }*/

    // Использование лямбды для 2 варианта:
    public static Comparator<Box> compareByA(){ // Инициализация экземпляром (объектом)
        return (b1, b2) -> b1.a - b2.a;
    }

    // Внутренний класс (inner class) - класс, описанный внутри другого
    // Без объектов внешнего класса работать с ним извне нельзя

    //public class CompareByA implements Comparator<Box> {
    public static class CompareByA implements Comparator<Box> { // Статический внутренний класс
        @Override
        public int compare(Box b1, Box b2) { // 0 b1 == b2, + b1 > b2, - b1 < b2
            return b1.a - b2.a; // Внутренние классы имеют доступ в поля private внешнего класса
        }
    }


}