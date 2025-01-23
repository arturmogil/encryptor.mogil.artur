import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Encrypt {
    final private List<Character> EN_SYMBOLS = Arrays.asList
            ('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' ');

    public void Encrypt(String input, int key)
    {
        char[] inputAsArray = input.toCharArray();
        List<Character> encryptedInputAsArray= new ArrayList<>();
        for(char c : inputAsArray)
        {
            if(EN_SYMBOLS.contains(c))
            {
                int currentIndex = EN_SYMBOLS.indexOf(c);
                int newIndex = (currentIndex + key) % EN_SYMBOLS.size();
                encryptedInputAsArray.add(EN_SYMBOLS.get(newIndex));
            }
            else
            {
                encryptedInputAsArray.add(c);
            }
        }
        String encryptedInput = "";
        for (char c : encryptedInputAsArray) {
            encryptedInput += c; // Додаємо кожен символ до рядка
        }
        System.out.println(encryptedInput);
    }
}
