class UserMenu {
    private static final CaesarCipher CIPHER = new CaesarCipher();
    private static final FileService FILE_SERVICE = new FileService();
    static void printCommands() {
        System.out.println(
                "Type ENCRYPT to encrypt txt file\n" +
                "Type DECRYPT to decrypt txt file");
    }
    static void cipherFile(String command, String path, int key) {
        if (command.equals("ENCRYPT")) {
            String fileENC = CIPHER.encrypt(FILE_SERVICE.readFromFile(path), key);
            FILE_SERVICE.writeToFile(path, fileENC);
        } else if (command.equals("DECRYPT")) {
            String fileDEC = CIPHER.decrypt(FILE_SERVICE.readFromFile(path),key);
            FILE_SERVICE.writeToFile(path,fileDEC);
        }
        else {
            System.out.println("Unknown command");
        }
    }
}
