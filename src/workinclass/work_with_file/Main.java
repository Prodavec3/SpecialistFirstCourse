package workinclass.work_with_file;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

// Parse XML - DOM

public class Main {
    public static void main(String[] args) throws IOException {
        // Создаем новый файл
        File file = new File("C:\\Users\\Юрий\\IdeaProjects\\" +
                "SpecialistFirstCourse\\src\\workinclass\\work_with_file\\testFile.txt");
        file.createNewFile();

        File folder = new File(".");
        File[] files = folder.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile();
            }
        });

        for (File f : files){
            System.out.println(f.getName());
        }
    }
}
