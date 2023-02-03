import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;

public class ActionsPathFiles {

    //Рекурсивный обход папок
    public Stream<Path> processFilesFromFolder(Path samplePath)
//            throws IOException
    {
        AtomicReference<Path> directory = new AtomicReference<>();
//        var ref = new Object() {
//            AtomicReference<String> directoryString = new AtomicReference<>();
//        };
        AtomicReference<String> directoryName = new AtomicReference<>();
        Map<Path, Path> map = new Map<Path, Path>() {};
        try(Stream<Path> stream = Files.list(samplePath)){
//            stream.forEach(p-> System.out.println(p));
            stream.forEach(p-> {
                if (p.toFile().isDirectory()==true) {
                    directory.set(p.getFileName());
//                    ref.directoryString = directory.toString();
                    System.out.println(directory);
//                    System.out.println(ref.directoryString);
                    processFilesFromFolder(p);
                } else {
//                    System.out.println(p);
                    Path relativize = samplePath.relativize(p);
                    Path relativize1 = p.getFileName();
                    directoryName = relativize1.toString();
                    System.out.println(relativize1);
//                    ArrayList<String> list = new ArrayList<>(Collections.singleton(p.toString()));
//                    list.forEach(System.out::println);
                }

            });
//            Stream<Path> stream1 = Files.list();
//            stream1.forEach(System.out::println);

//            Stream<Path> stream2 = stream.forEach(stream.Files.list(samplePath));

//        ArrayList<String> writerArrayList = new ArrayList<>();
//        try (DirectoryStream<Path> folderEntries  = Files.newDirectoryStream(samplePath)) {
//
//            for (Path entry : folderEntries) {
//                if (Files.isDirectory(entry) == true) {
//                    folderEntries.iterator();
//                }
//            }
            return stream;
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    //реализация через ArrayList
    ArrayList<Path> readFullNamesList(DirectoryStream<Path> sampleFolderEntries) {
        ArrayList<Path> writerList = null;
        for (Path entry : sampleFolderEntries) {
            if (Files.isDirectory(entry) == true) {
                writerList = new ArrayList<>(Arrays.asList(entry.getFileName()));
            }
        }


//        for(String s : writerList) {
//            System.out.println(s);
//        }
        return writerList;
    }


}
