public class Main {
    public static void main(String[] args) {
        Encrypt e = new Encrypt();
        String text = new String("ab c,.k.k. kgergJ\n " +
                "JKfds ed.,fgg");
        System.out.println(text);
        e.Encrypt(text,1);

    }

}