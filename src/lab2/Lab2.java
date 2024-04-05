package lab2;

public class Lab2 {
    public static void main(String[] args) {
        ComLineParser comLineParser = new ComLineParser(new String[]{"?", "r", "w"});
        comLineParser.Parse(args);
    }
}
