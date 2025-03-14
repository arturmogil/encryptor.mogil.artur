import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        String command;
        String path;
        int key;

        if (args.length == 3) {
            command = args[0];
            path = args[1];
            key = Integer.parseInt(args[2]);
            if (key < 1) {
                System.out.println("Key can't be less then 1");
                System.exit(0);
            }
            UserMenu.cipherFile(command,path,key);
        }
        else if(args.length == 0) {
            Scanner scannerUserInput = new Scanner(System.in);
            System.out.println("Welcome to the Caesar cipher program!\n" +
                    "Enter file path:");
            path = scannerUserInput.nextLine();
            System.out.println("Enter key for cipher:");
            key = Integer.parseInt(scannerUserInput.nextLine());
            if (key < 1) {
                System.out.println("Key can't be less then 1");
                System.exit(0);
            }
            UserMenu.printCommands();
            command = scannerUserInput.nextLine();
            UserMenu.cipherFile(command, path, key);
        }
    }
}