import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriterToFile {
    public void toWriter(ArrayList<String> sampleWriterArrayList)
//            throws IOException
    {
        String outputPath = "F:\\Proejects\\Proejects\\ListNameMusic\\src\\main\\resources\\FileOutput.txt";
        try(FileWriter writer = new FileWriter(outputPath)) {
            for (String s : sampleWriterArrayList){
                writer.write(s);
                writer.write("\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Что-то не так с путём");
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
}
