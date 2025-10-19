/**
 * Mewakili tangan (Hand) dalam permainan Blackjack.
 * Mewarisi dari kelas Hand dan menambahkan metode untuk menghitung nilai
 * Blackjack.
 */
public class BlackjackHand extends Hand {

    /**
     * Menghitung dan mengembalikan nilai dari tangan ini dalam permainan Blackjack.
     * Kartu J, Q, K bernilai 10.
     * Kartu Ace bernilai 1 atau 11, dipilih nilai yang terbaik (sedekat mungkin
     * dengan 21 tanpa melewatinya).
     * 
     * @return nilai Blackjack dari tangan.
     */
    public int getBlackjackValue() {
        int val; // Nilai total tangan
        int aceCount; // Jumlah Ace di tangan
        boolean aceIs11; // Apakah satu Ace dihitung sebagai 11?

        val = 0;
        aceCount = 0;

        // Hitung nilai, anggap semua Ace sebagai 1
        for (int i = 0; i < hand.size(); i++) {
            Card card = hand.get(i);
            int cardVal = card.getValue(); // Nilai dari Card (1-13)

            if (cardVal == 1) { // Jika Ace
                aceCount++;
                val = val + 1;
            } else if (cardVal > 10) { // Jika Jack, Queen, atau King
                val = val + 10;
            } else { // Jika 2-10
                val = val + cardVal;
            }
        }

        // Sekarang, coba ubah nilai Ace dari 1 menjadi 11
        // Selama masih ada Ace dan total nilai <= 11 (menambah 10 tidak akan bust)
        if (aceCount > 0 && val <= 11) {
            // Tambahkan 10 (mengubah satu Ace dari 1 menjadi 11)
            val = val + 10;
        }

        return val;
    }
}