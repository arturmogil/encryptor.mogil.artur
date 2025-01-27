import java.io.*;

public class FileService {
    public void writeToFile(String filePath, String content) {
        File originalFile = new File(filePath);
        if (!originalFile.exists()) {
            System.err.println("File not found");
            return;
        }

        String originalFileName = originalFile.getName();
        String encryptedFileName;
        String originalFileDirectory = originalFile.getParent();

        if (originalFileName.contains(".")) {
            if(originalFileName.contains("[ENCRYPTED]")) {
                int dotIndex = originalFileName.lastIndexOf(".");
                encryptedFileName = originalFileName.substring(0, dotIndex) + "[DECRYPTED]" + originalFileName.substring(dotIndex);
            }
            else {
                int dotIndex = originalFileName.lastIndexOf(".");
                encryptedFileName = originalFileName.substring(0, dotIndex) + "[ENCRYPTED]" + originalFileName.substring(dotIndex);
            }
        } else {
            if(originalFileName.contains("[ENCRYPTED]")) {
                encryptedFileName = originalFileName + "[DECRYPTED]";
            }
            else {
                encryptedFileName = originalFileName + "[ENCRYPTED]";
            }
        }

        String encryptedFilePath = originalFileDirectory + File.separator + encryptedFileName;
        try (FileWriter writer = new FileWriter(encryptedFilePath)) {
            writer.write(content);
            System.out.println("Text saved to file: " + encryptedFilePath);
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
        }
    }

    public String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(filePath)) {
            int currentChar;
            while ((currentChar = reader.read()) != -1) {
                content.append((char) currentChar);
            }
        } catch (IOException e) {
            System.err.println("File reading error: " + e.getMessage());
        }
        return content.toString();
    }
}
