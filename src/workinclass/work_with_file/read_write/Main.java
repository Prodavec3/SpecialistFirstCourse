package workinclass.work_with_file.read_write;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        // Запись
        // try / catch без использования throw, без close
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Юрий\\IdeaProjects\\" +
                "SpecialistFirstCourse\\src\\workinclass\\work_with_file\\read_write\\" +
                "hello.txt")) {
            fileWriter.write("Hello World!");
        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
        }

        // Чтение
        // Любая передача данных осуществляется с помощью буффера, создаем буферизированную
        // читалку с помощью FileReader
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\" +
                "Users\\Юрий\\IdeaProjects\\SpecialistFirstCourse\\src\\workinclass\\" +
                "work_with_file\\read_write\\hello.txt"));
        String str = bufferedReader.readLine();
        System.out.println("Строка из файла: " + str);

        // Запись массива
        int[] mass = {1, 2, 3, 4, 5};
        writeArrayToFile(mass);

        // Запись объекта
        TestWriteClassInFile testWriteClassInFile = new TestWriteClassInFile("Hello", mass);
        writeClassTestToFile(testWriteClassInFile);
    }


    private static void writeArrayToFile(int[] mass) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream("C:\\Users\\Юрий\\" +
                        "IdeaProjects\\SpecialistFirstCourse\\src\\workinclass\\" +
                        "work_with_file\\read_write\\array.txt")));

        for (int a : mass
        ) {
            dataOutputStream.writeInt(a);
        }
        dataOutputStream.close();
    }


    private static void writeClassTestToFile(TestWriteClassInFile testWriteClassInFile) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(
                        "C:\\Users\\Юрий\\IdeaProjects\\SpecialistFirstCourse\\" +
                                "src\\workinclass\\work_with_file\\read_write\\class.txt"
                ))
        );
        objectOutputStream.writeObject(testWriteClassInFile);
        objectOutputStream.close();
    }
}

class TestWriteClassInFile implements Serializable {

    String name;
    int[] massive;

    public TestWriteClassInFile(String name, int[] massive) {
        this.name = name;
        this.massive = massive;
    }

    @Override
    public String toString() {
        return "TestWriteClassInFile{" +
                "name='" + name + '\'' +
                ", massive=" + Arrays.toString(massive) +
                '}';
    }
}