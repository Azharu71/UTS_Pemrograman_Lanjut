import java.util.Scanner;

public class subrutin {

    // Subrutin/fungsi untuk mencetak versi huruf kapital dari string
    public static void printCapitalized(String str) {
        boolean awalKata = true; 
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isLetter(c)) {
                if (awalKata) {
                    c = Character.toUpperCase(c); 
                    awalKata = false; 
                }
            } else {
                awalKata = true; 
            }

            System.out.print(c);
        }

        System.out.println(); 
    }

    // Program main untuk menguji subrutin/fungsi
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Masukkan sebuah kalimat: ");
        String kalimat = input.nextLine();

        System.out.print("Versi kapital: ");
        printCapitalized(kalimat);

        input.close();
    }
}
