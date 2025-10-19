import java.util.Scanner;

public class telur {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int gross = 144;
        int lusin = 12;

        System.out.print("Masukan jumlah telur: ");
        int telur = input.nextInt();
        int jumlahGross = telur / gross;
        int sisaGross = telur % gross;
        int jumlahLusin = sisaGross / lusin;
        int sisa = sisaGross % lusin;

        System.out.println("Jumlah telur Anda adalah " + jumlahGross + " gross " + jumlahLusin + " lusin, dan " + sisa);

        input.close();

    }
}
