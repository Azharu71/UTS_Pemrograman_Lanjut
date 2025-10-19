import java.util.ArrayList;
import java.util.Collections;

/**
 * Mewakili setumpuk (deck) kartu remi.
 */
public class Deck {

    private ArrayList<Card> deck; // Daftar kartu dalam tumpukan

    /**
     * Konstruktor. Membuat tumpukan 52 kartu yang terurut.
     */
    public Deck() {
        deck = new ArrayList<Card>();
        for (int suit = 0; suit <= 3; suit++) {
            for (int value = 1; value <= 13; value++) {
                deck.add(new Card(value, suit));
            }
        }
    }

    /**
     * Mengocok tumpukan kartu ke urutan acak.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Mengembalikan jumlah kartu yang tersisa di tumpukan.
     * 
     * @return jumlah kartu.
     */
    public int cardsLeft() {
        return deck.size();
    }

    /**
     * Mengambil dan mengembalikan satu kartu dari atas tumpukan.
     * 
     * @return Kartu teratas. Mengembalikan null jika tumpukan kosong.
     */
    public Card dealCard() {
        if (deck.isEmpty()) {
            return null; // Seharusnya tidak terjadi jika kita mengelola tumpukan dgn baik
        } else {
            return deck.remove(0);
        }
    }
}