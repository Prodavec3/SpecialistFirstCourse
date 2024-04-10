package lab5;

import java.util.Enumeration;

public class Main {
    public static void main(String[] args) {

        WordCount wordCount;
        SimpleParser simpleParser = new SimpleParser();
        simpleParser.parse(args);

        // wordCount = new WordCount(null,null);

        // wordCount = new WordCount(simpleParser.getInFile(), null);

        wordCount = new WordCount("C:\\Users\\Юрий\\IdeaProjects\\" +
                "SpecialistFirstCourse\\src\\lab5\\lab5.txt", null);

        wordCount.addListener((sender, size) ->
                System.out.println("Общее количество слов (Listener): " + size + "\n"));

        wordCount.countWords();

        Enumeration keys = wordCount.getWords().keys();
        while(keys.hasMoreElements()) {
            String w = keys.nextElement().toString();
            int n = (int) wordCount.getWords().get(w);
            System.out.println(w + "   " + n);
        }
    }
}
