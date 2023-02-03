import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Solution {

    public static void GetResult(String samplePath)
//            throws IOException
    {
        ActionsFile actionsFile = new ActionsFile();
        WriterToFile writer = new WriterToFile();
        File file = new File(samplePath);
        if (file.exists() == false) {
            throw new IllegalArgumentException("Аргумент не может быть null");
        }

        //Реализация через ArrayList
//        ArrayList<String> arraylist = new ArrayList<>(
//                actions.readFullNamesList(/* samplePath */
//                                            file));
//        actions.lessExtensionArrayList(arraylist);

        //Реализация через массив строк
//        String[] arrayString = actions.readFullNames(samplePath);
//        actions.lessExtensionArrayString(arrayString);

        //Рекурсивный обход папок
        ArrayList<String> arrayList = actionsFile.processFilesFromFolder(file);

        //запись в файл
        writer.toWriter(arrayList);

        ///////////
        System.out.println();

        //Работа через Path и Files
        Path path = Paths.get(samplePath);
        ActionsPathFiles actionsPathFiles = new ActionsPathFiles();

        Stream<Path> stream =  actionsPathFiles.processFilesFromFolder(path);
        System.out.println();

        //обход дерева файлов
//        try {
//            Files.walkFileTree(Paths.get(samplePath), new MyFileVisitor());
//        } catch (IOException e) {
//            throw new IllegalArgumentException(e);
//        }



    }
}
