import java.util.Scanner;

/**
 * Program ini memungkinkan pengguna bermain Blackjack melawan komputer
 * (bandar).
 * Program mengelola uang pengguna dan taruhan.
 */
public class BlackjackGame {

    private static Deck deck; // Satu tumpukan kartu untuk semua permainan
    private static int money; // Jumlah uang yang dimiliki pengguna
    private static Scanner scanner; // Scanner untuk input pengguna

    public static void main(String[] args) {

        money = 100; // Mulai dengan $100
        deck = new Deck();
        deck.shuffle();
        scanner = new Scanner(System.in);

        System.out.println("Selamat datang di permainan Blackjack!");
        System.out.println("Anda memiliki $100.");
        System.out.println("-------------------------------------");

        boolean playAgain = true;

        while (playAgain && money > 0) {

            // 1. Dapatkan taruhan pengguna
            int bet = getBet();

            // 2. Mainkan satu putaran
            boolean userWins = playHand();

            // 3. Sesuaikan uang
            if (userWins) {
                System.out.println("Anda memenangkan $" + bet);
                money = money + bet;
            } else {
                System.out.println("Anda kehilangan $" + bet);
                money = money - bet;
            }

            System.out.println("Uang Anda sekarang: $" + money);

            // 4. Cek apakah masih punya uang
            if (money <= 0) {
                System.out.println("Anda kehabisan uang! Terima kasih sudah bermain.");
                break;
            }

            // 5. Tanya apakah ingin main lagi
            System.out.print("Main lagi? (Y/N): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("Y")) {
                playAgain = false;
            }
            System.out.println("-------------------------------------");

        }

        System.out.println("Permainan selesai. Anda pergi dengan $" + money);
        scanner.close();
    }

    /**
     * Meminta pengguna untuk memasukkan taruhan yang valid.
     * 
     * @return jumlah taruhan yang valid.
     */
    private static int getBet() {
        int bet;
        while (true) {
            System.out.print("Masukkan taruhan Anda (1 - " + money + "): $");
            if (scanner.hasNextInt()) {
                bet = scanner.nextInt();
                if (bet > 0 && bet <= money) {
                    return bet; // Taruhan valid
                } else {
                    System.out.println("Taruhan Anda harus antara $1 dan $" + money);
                }
            } else {
                System.out.println("Input tidak valid. Masukkan angka.");
                scanner.next(); // Bersihkan input yang salah
            }
        }
    }

    /**
     * Memainkan satu putaran (hand) Blackjack.
     * 
     * @return true jika pengguna menang, false jika bandar menang.
     */
    private static boolean playHand() {

        // Pastikan tumpukan kartu cukup, kocok ulang jika hampir habis
        if (deck.cardsLeft() < 10) {
            deck = new Deck();
            deck.shuffle();
            System.out.println("Tumpukan kartu menipis. Mengocok tumpukan baru.");
        }

        BlackjackHand userHand = new BlackjackHand();
        BlackjackHand dealerHand = new BlackjackHand();

        // 1. Pembagian awal
        userHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        userHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());

        System.out.println("\n--- Kartu Dibagikan ---");

        // Tampilkan kartu bandar (satu terbuka)
        System.out.println("Kartu Bandar (Terbuka): " + dealerHand.getCard(0));

        // Tampilkan kartu pengguna
        System.out.print("Kartu Anda: ");
        System.out.print(userHand.getCard(0) + " / " + userHand.getCard(1));
        System.out.println(" (Total: " + userHand.getBlackjackValue() + ")");

        // 2. Cek Blackjack instan
        if (dealerHand.getBlackjackValue() == 21) {
            System.out.println("Bandar mendapatkan Blackjack! " + dealerHand.getCard(1));
            System.out.println("Bandar menang.");
            return false; // Bandar menang (seri dihitung kalah)
        }
        if (userHand.getBlackjackValue() == 21) {
            System.out.println("Anda mendapatkan Blackjack! Anda menang.");
            return true;
        }

        // 3. Giliran Pengguna (Hit atau Stand)
        while (true) {
            System.out.print("Pilihan Anda: Hit (H) atau Stand (S)? ");
            String choice = scanner.next();

            if (choice.equalsIgnoreCase("S")) {
                // Pengguna memilih Stand
                break;
            } else if (choice.equalsIgnoreCase("H")) {
                // Pengguna memilih Hit
                Card newCard = deck.dealCard();
                userHand.addCard(newCard);
                System.out.println("Anda Hit dan mendapatkan: " + newCard);
                System.out.println("Total Anda sekarang: " + userHand.getBlackjackValue());

                if (userHand.getBlackjackValue() > 21) {
                    System.out.println("Bust! Anda melewati 21.");
                    return false; // Pengguna kalah
                }
            } else {
                System.out.println("Input tidak valid. Masukkan H atau S.");
            }
        }

        // 4. Giliran Bandar (setelah pengguna Stand)
        System.out.println("\n--- Giliran Bandar ---");
        System.out.println("Kartu Bandar lainnya: " + dealerHand.getCard(1));
        System.out.println("Total Bandar: " + dealerHand.getBlackjackValue());

        // Aturan: Bandar harus Hit jika total <= 16
        while (dealerHand.getBlackjackValue() <= 16) {
            Card newCard = deck.dealCard();
            dealerHand.addCard(newCard);
            System.out.println("Bandar Hit dan mendapatkan: " + newCard);
            System.out.println("Total Bandar sekarang: " + dealerHand.getBlackjackValue());
        }

        // 5. Tentukan Pemenang
        System.out.println("\n--- Hasil Akhir ---");
        System.out.println("Total Anda: " + userHand.getBlackjackValue());
        System.out.println("Total Bandar: " + dealerHand.getBlackjackValue());

        if (dealerHand.getBlackjackValue() > 21) {
            System.out.println("Bandar Bust! Anda menang.");
            return true;
        } else if (dealerHand.getBlackjackValue() >= userHand.getBlackjackValue()) {
            System.out.println("Bandar menang (atau seri).");
            return false;
        } else {
            System.out.println("Anda menang!");
            return true;
        }
    }
}