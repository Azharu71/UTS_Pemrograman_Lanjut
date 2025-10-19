import java.util.ArrayList;

/**
 * Mewakili sekumpulan kartu (Hand) yang dipegang oleh pemain.
 */
public class Hand {

    protected ArrayList<Card> hand; // Kartu-kartu di tangan

    /**
     * Konstruktor. Membuat tangan kosong.
     */
    public Hand() {
        hand = new ArrayList<Card>();
    }

    /**
     * Menghapus semua kartu dari tangan.
     */
    public void clear() {
        hand.clear();
    }

    /**
     * Menambahkan kartu ke tangan.
     * 
     * @param c kartu yang akan ditambahkan.
     */
    public void addCard(Card c) {
        if (c != null) {
            hand.add(c);
        }
    }

    /**
     * Mengembalikan jumlah kartu di tangan.
     * 
     * @return jumlah kartu.
     */
    public int getCardCount() {
        return hand.size();
    }

    /**
     * Mengembalikan kartu pada posisi tertentu di tangan.
     * 
     * @param position indeks kartu yang diinginkan.
     * @return kartu pada posisi tersebut.
     */
    public Card getCard(int position) {
        if (position >= 0 && position < hand.size()) {
            return hand.get(position);
        } else {
            return null;
        }
    }
}