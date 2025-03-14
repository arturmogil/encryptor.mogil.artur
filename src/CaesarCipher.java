import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CaesarCipher {
    private final static List<Character> EN_SYMBOLS = Arrays.asList
            ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ');

    String encrypt(String input, int key) {
        char[] inputAsArray = input.toCharArray();
        List<Character> encryptedInputAsArray = new ArrayList<>();
        for (char c : inputAsArray) {
            if (EN_SYMBOLS.contains(c)) {
                int currentIndex = EN_SYMBOLS.indexOf(c);
                int newIndex = (currentIndex + key) % EN_SYMBOLS.size();
                encryptedInputAsArray.add(EN_SYMBOLS.get(newIndex));
            }
            else {
                encryptedInputAsArray.add(c);
            }
        }
        StringBuilder encryptedInputAsString = new StringBuilder();
        for (char c : encryptedInputAsArray) {
            encryptedInputAsString.append(c);
        }
        return encryptedInputAsString.toString();
    }

    String decrypt(String input, int key) {
        char[] inputAsArray = input.toCharArray();
        List<Character> decryptedInputAsArray = new ArrayList<>();
        for(char c : inputAsArray) {
            if(EN_SYMBOLS.contains(c)) {
                int currentIndex = EN_SYMBOLS.indexOf(c);
                int newIndex = (currentIndex - key) % EN_SYMBOLS.size();
                if (newIndex < 0) {
                    newIndex += EN_SYMBOLS.size();
                }
                decryptedInputAsArray.add(EN_SYMBOLS.get(newIndex));
            }
            else {
                decryptedInputAsArray.add(c);
            }
        }
        StringBuilder decryptedInputAsString = new StringBuilder();
        for (char c : decryptedInputAsArray) {
            decryptedInputAsString.append(c);
        }
        return decryptedInputAsString.toString();
    }
}
