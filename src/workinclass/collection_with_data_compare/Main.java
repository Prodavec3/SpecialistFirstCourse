package workinclass.collection_with_data_compare;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Storage<Integer>> arrayList = new ArrayList();

        arrayList.add(new Storage<>(10));
        arrayList.add(new Storage<>(20));

        if (arrayList.get(0).isGreater(arrayList.get(1))){ // get(1).getData()
            System.out.println("NotOk");
        } else {
            System.out.println("Ok");
        }
    }
}
