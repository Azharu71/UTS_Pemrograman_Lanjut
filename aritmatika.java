
/*karena tidak ada library textIo pada java standar, maka saya akan tetap menggunakan util scanner untuk menerima input user */
import java.util.Scanner;

public class aritmatika {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b;
        char op;

        while (true) {
            System.out.print("Masukkan ekspresi: ");
            a = input.nextDouble();

            if (a == 0) {
                System.out.println("Program selesai.");
                break;
            }

            op = input.next().charAt(0);
            b = input.nextDouble();

            double hasil = 0;

            switch (op) {
                case '+':
                    hasil = a + b;
                    break;
                case '-':
                    hasil = a - b;
                    break;
                case '*':
                    hasil = a * b;
                    break;
                case '/':
                    hasil = a / b;
                    break;

                default:
                    break;
            }
            System.out.println("Hasil: " + hasil);
        }
        input.close();
    }

}
