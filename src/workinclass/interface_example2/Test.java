package workinclass.interface_example2;

public class Test {
    private int x;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int function(Hdmi inter) {
        return inter.f(x);
    }
}