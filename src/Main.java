import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    static String TARGET_FILE_DIR = "src\\testFile\\old\\";
    static String NEW_FILE_PATH_DIR = "src\\testFile\\RENAME\\";

    public static void main(String[] args) {
        File file = new File(TARGET_FILE_DIR);
        File[] fileList = file.listFiles();
        int successfullyRenameCount = 0;

        assert fileList != null;
        for (File file1 : fileList) {
            try {
                String newFileName = NEW_FILE_PATH_DIR + ThreadLocalRandom.current().nextInt(-999, 999) + "_" + file1.getName();
                if (file1.renameTo(new File(newFileName))) {
                    ++successfullyRenameCount;
                }
            } catch (SecurityException | NullPointerException exception) {
                System.out.println("Failed to rename file");

            }
        }
        System.out.println("Renamed " + successfullyRenameCount + " out of " + fileList.length);
    }
}