package workinclass.collection_with_data_compare;

// Класс Storage будет параметризован любым типом, который можно сравнивать с любым типом,
// который тоже можно сравнивать
// т.е мы можем сравнивать данные если их можно сравнивать и они в одной цепочке сравнения
public class Storage<T extends Comparable<? super T>> { // Параметризация, T=Object
    // Параметризация будет для данных типа Т, которые дибо сами реализуют интерфейс
    // Comparable, либо наследуются от класса с интерфейсом Comparable для данных той же
    // цепочки классов (для любых классов у которых Т родительский)

    // super - если Т именно родитель
    // extends - если Т есть в списке родителей

    // Запись <? super T> - любой класс, который родитель для T и сама T

    // Запись <? extends T> - любой тип являющийся дочерним для T. Доступна ТОЛЬКО для чтения

    // Плавило PECS
    // Producer uses Extends, Consumer uses Super

    // C0->C1->C2->C3

    // <? extends C3> - можем получить C0, C1, C2, однако если мы точно
    // уверены в типе данных, то через приведение можем C4 c4 = (C4) get(0)
    // get(0) -> тип C3

    // <? super T> - только принимает, прочитать его нельзя практически
    // в нем будут данные не младше С3; add(C4()) можно, а add(C2()) нельзя
    // однако получить можем Object

    // В данном случае отправной точкой будет Comparable (т.е что бы мы туда не поместили
    // точно будет Comparable

    private T data;

    public Storage(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isGreater(T data){
        return this.data.compareTo(data) > 0;
    }

    public boolean isGreater(Storage<T> rightValue){
        return data.compareTo(rightValue.getData()) > 0;
    }
}
