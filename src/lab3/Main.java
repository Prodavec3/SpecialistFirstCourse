package lab3;

public class Main {
    public static void main(String[] args) {
        SimpleParser simpleParser = new SimpleParser();
        simpleParser.Parse(args);
        System.out.println("inFile: " + simpleParser.getInFile() + "" +
                " | outFile: " + simpleParser.getOutFile());
    }
}
