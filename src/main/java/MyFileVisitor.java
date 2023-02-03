import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.stream.Stream;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
//            throws IOException
    {
        try {
            if (file.toFile().isFile()==true){
                System.out.println(file.toRealPath());
            }
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return FileVisitResult.CONTINUE;
    }
}
