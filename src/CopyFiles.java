import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFiles {
    public static void copyFile(String nameOne, String nameTwo) {
        File DirOne = new File(nameOne);
        File[] fileNameForCopy = DirOne.listFiles(new FilterForFile("doc"));

        File DirTwo = new File(nameTwo);
        String[] nameFileInTwoDir = DirTwo.list();
        for (int i = 0; i < nameFileInTwoDir.length; i++) {
            for (int j = 0; j < fileNameForCopy.length; j++) {
                if (nameFileInTwoDir[i].equals(fileNameForCopy[j].getName())) {
                    System.out.println("Copying was interrupted because a file with   " + fileNameForCopy[j].getName() +
                            "name already exists in the folderCopying was interrupted because a file with  " + fileNameForCopy[j].getName() +
                            "name already exists in the folder  " + nameTwo);
                    return;
                }
            }
        }
        for (File file : fileNameForCopy) {
            File newFile = new File(nameTwo, file.getName());
            try {
                newFile.createNewFile();
                byte[] buffer = new byte[1024];
                int byteread = 0;
                try (FileInputStream fileFrom = new FileInputStream(file);
                     FileOutputStream whereСopy = new FileOutputStream(newFile)) {
                    for (; (byteread = fileFrom.read(buffer)) > 0; ) {
                        whereСopy.write(buffer, 0, byteread);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
