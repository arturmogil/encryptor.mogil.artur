public class UserMenu {
    private static final CaesarCipher CIPHER = new CaesarCipher();
    private static final FileService FILE_SERVICE = new FileService();
    public static void printCommands() {
        System.out.println(
                "Type ENCRYPT to encrypt txt file\n" +
                "Type DECRYPT to decrypt txt file");
    }
    public static  void cipherFile(String command, String path, int key) {
        if(command.equals("ENCRYPT")) {
            String fileENC = CIPHER.Encrypt(FILE_SERVICE.readFromFile(path),key);
            FILE_SERVICE.writeToFile(path,fileENC);
        } else if (command.equals("DECRYPT")) {
            String fileDEC = CIPHER.Decrypt(FILE_SERVICE.readFromFile(path),key);
            FILE_SERVICE.writeToFile(path,fileDEC);
        }
        else {
            System.out.println("Unknown command");
        }
    }
}
