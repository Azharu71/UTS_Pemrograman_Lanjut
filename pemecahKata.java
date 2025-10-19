import java.util.Scanner;

public class pemecahKata {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan teks: ");
        String teksInput = scanner.nextLine();

        // gunakan string builder karena array tidak bisa di append di java
        StringBuilder kata = new StringBuilder();

        // iterasi untuk setiap kata input
        for (int i = 0; i < teksInput.length(); i++) {
            char a = teksInput.charAt(i);
            if (Character.isLetter(a)) {
                kata.append(a);
            } else if (kata.length() > 0) {
                System.out.println(kata.toString());
                kata.setLength(0);
            }

            scanner.close();
        }
        if (kata.length() > 0) {
            System.out.println(kata.toString());
        }

    }
}
