import java.io.File;
import java.sql.Array;
import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.Arrays;

public class ActionsFile {

    //реализация через массив строк
    String[] readFullNames (String sampleWay) {
        File file = new File(sampleWay);
        String[] files = file.list();
        for (int i = 0; i < files.length; i++) {
//            System.out.println(files[i]);
        }
        return files;
    }

    //Реализация через массив строк
    String[] lessExtensionArrayString(String[] sampleArrayString){
        for (int i = 0; i < sampleArrayString.length; i++) {
            int dotIdx = sampleArrayString[i].lastIndexOf('.');
//            int bslashIdx = sampleArrayString[i].lastIndexOf('\\'); //переменная, которая отбрасывает слэши в полном имени файла
            if (dotIdx != -1
//                    && bslashIdx != -1
            ) {
                sampleArrayString[i] = sampleArrayString[i].substring(0,
//                        bslashIdx + 1,
                        dotIdx);
//                System.out.println(sampleArrayString[i]);
            }
        }
        return sampleArrayString;
    }

    //реализация через ArrayList
    ArrayList<String> readFullNamesList(File sampleFolder) {
        ArrayList<String> writerList = new ArrayList<>(
                Arrays.asList(sampleFolder.list()));

//        for(String s : writerList) {
//            System.out.println(s);
//        }
        return writerList;
    }

    //Удаление расширения (Реализация через ArrayList)
    ArrayList<String> lessExtensionArrayList (ArrayList<String> sampleArrayList){
        for (int i = 0; i < sampleArrayList.size(); i++) {
            int dotIdx = sampleArrayList.get(i).lastIndexOf('.');
            if (dotIdx != -1) {
                sampleArrayList.set(i, sampleArrayList.get(i).substring(0, dotIdx));
            }
        }
        return sampleArrayList;
    }

    //Вставка исполнителя перед именем
    ArrayList<String> executorAdd(File sampleEntry, ArrayList<String> sampleWriterList){
        String nameFolder = sampleEntry.getName();
//        int i = 0;
//        for (String s : sampleWriterList){
//            if (s.startsWith(nameFolder) == false) {
//                s = nameFolder.concat(" - " + s);
//                System.out.println(s);
//            }
//            i++;
////            System.out.println(s);
//        }

        for (int i  = 0; i < sampleWriterList.size(); i++) {
            if (sampleWriterList.get(i).startsWith(nameFolder) == false) {
                sampleWriterList.set(i, nameFolder.concat(" - "  +
                        sampleWriterList.get(i)));
//                System.out.println(sampleWriterList.get(i));
            }
        }

        for (String s : sampleWriterList) {
            System.out.println(s);
        }
//        System.out.println(sampleEntry.getName());
        return sampleWriterList;
    }

    //Рекурсивный обход папок
    public ArrayList<String> processFilesFromFolder(File folder) {
        ArrayList<String> writerArrayList = new ArrayList<>();
        ArrayList<String> aL1;
        ArrayList<String> aL2;
        ArrayList<String> aL3;
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            if (entry.isDirectory()) {
                aL1 = readFullNamesList(entry);
                aL2 = lessExtensionArrayList(aL1);
                aL3 = executorAdd(entry, aL2);
                for (String s : aL3) {
                    writerArrayList.add(s);
                }

                //Рекурсия
//                processFilesFromFolder(entry);
//                continue;
            }
            // иначе вам попался файл, обрабатывайте его!
        }
//        for (String s : writerArrayList){
//            System.out.println(s);
//        }
        System.out.println(writerArrayList.size());
        return writerArrayList;
    }
}
