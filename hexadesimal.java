import java.util.Scanner;

public class hexadesimal {
    // fungsi hexValue dengan switch case
    static int hexValue(char ch) {
        switch (ch) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case 'A':
            case 'a':
                return 10;
            case 'B':
            case 'b':
                return 11;
            case 'C':
            case 'c':
                return 12;
            case 'D':
            case 'd':
                return 13;
            case 'E':
            case 'e':
                return 14;
            case 'F':
            case 'f':
                return 15;
            default:
                return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Masukkan input heksadesimal: ");
        String str = input.nextLine();
        int value = 0;
        boolean isTrue = true;

        for (int i = 0; i < str.length(); i++) {
            int digit = hexValue(str.charAt(i));
            if (digit == -1) {
                isTrue = false;
                break;
            }
            value = 16 * value + digit;
        }
        if (isTrue) {
            System.out.println("Nilai desimal dari " + str + " adalah " + value);

        } else {
            System.out.println("Input tidak valid");
        }
        input.close();
    }
}
