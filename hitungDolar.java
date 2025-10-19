import java.util.Scanner;

public class hitungDolar {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Input
        System.out.print("Banyaknya koin 25 sen: ");
        int koin25Sen = input.nextInt();
        
        System.out.print("Banyaknya koin 10 sen: ");
        int koin10Sen = input.nextInt();
        
        System.out.print("Banyaknya koin 5 sen ");
        int koin5Sen = input.nextInt();
        
        // tambahkan nilai pada variabel dengan jumlah yang dimiliki
        int totalSen = (koin25Sen * 25) + (koin10Sen * 10) + (koin5Sen * 5);
        
        //konversi ke dollar
        double totalDolar = totalSen / 100.0;
        
        // Hasil dalam bentuk dolar
        System.out.printf("Total uang yang dimiliki adalah $" +totalDolar);
        
        input.close();
    }
}
