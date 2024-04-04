package workinclass;

public class StaticInClass {
    public static void main(String[] args) {
        System.out.println("Create obj 1");
        StaticInClass staticInClass1 = new StaticInClass();
        System.out.println("\nCrate obj 2");
        StaticInClass staticInClass2 = new StaticInClass(1);
    }

    static {
        System.out.println(1);
    }
    {
        System.out.println(2);
    }

    public StaticInClass() {
        System.out.println(3);
    }

    public StaticInClass(int a){
        System.out.println(4);
    }

    static {
        System.out.println(5);
    }
}
