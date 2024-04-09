package lab4;

import java.io.*;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class WordCount {
    private String inFile, outFile;
    private static String testString = "My dream is to become a successful doctor. " +
            "Growing up, I always had a fascination with the human body and how it works. " +
            "I loved learning about different diseases and how they can be treated, " +
            "and I always knew that I wanted to work in the medical field.";

    public WordCount(String inFile, String outFile) {
        this.inFile = inFile;
        this.outFile = outFile;
    }

    private Hashtable words = new Hashtable();

    public Hashtable getWords() {
        return words;
    }

    public void countWords() {
        Reader reader;
        int num = 0;
        try {
            reader = (inFile == null) ? new StringReader(testString): new FileReader(inFile);

            BufferedReader bufferedReader = new BufferedReader(reader);
            for (String line = bufferedReader.readLine();
                 line != null;
                 line = bufferedReader.readLine()) {
                StringTokenizer stringTokenizer = new StringTokenizer(line,
                        " \t\n\r\f.,;:\"");
                while (stringTokenizer.hasMoreTokens()){
                    String strToken = stringTokenizer.nextToken();
                    if(!words.containsKey(strToken)){
                        words.put(strToken, 1);
                        num++;
                    } else {
                        Object objValue = words.get(strToken);
                        int count = (int) objValue;
                        count++;
                        words.put(strToken, count);
                    }
                }
            }
            bufferedReader.close();
            System.out.println("Общее количество слов: " + num + "\n");

        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
        }

    }
}
