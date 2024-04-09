package workinclass.interface_example2;

public class Main {
    public static void main(String[] args) {
        Test test = new Test();
        XFunction xFunction = new XFunction();

        test.setX(7);

        int y = test.function(xFunction);
        System.out.println("result: " + y);
    }
}