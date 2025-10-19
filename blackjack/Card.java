/**
 * Mewakili satu kartu remi.
 * Sebuah kartu memiliki "suit" (jenis) dan "value" (nilai).
 */
public class Card {

    // Konstanta untuk jenis kartu (suit)
    public final static int SPADES = 0; // Karo
    public final static int HEARTS = 1; // Hati
    public final static int DIAMONDS = 2; // Keriting
    public final static int CLUBS = 3; // Sekop

    // Konstanta untuk nilai kartu non-numerik
    public final static int ACE = 1;
    public final static int JACK = 11;
    public final static int QUEEN = 12;
    public final static int KING = 13;

    // Properti (fields) untuk kartu
    private final int suit; // Jenis kartu (SPADES, HEARTS, DIAMONDS, CLUBS)
    private final int value; // Nilai kartu (1 untuk ACE, 2-10, 11-13 untuk J,Q,K)

    /**
     * Konstruktor. Membuat kartu dengan jenis dan nilai yang ditentukan.
     * 
     * @param theValue nilai kartu.
     * @param theSuit  jenis kartu.
     */
    public Card(int theValue, int theSuit) {
        if (theValue < 1 || theValue > 13) {
            throw new IllegalArgumentException("Nilai kartu ilegal");
        }
        if (theSuit < 0 || theSuit > 3) {
            throw new IllegalArgumentException("Jenis kartu ilegal");
        }
        value = theValue;
        suit = theSuit;
    }

    /**
     * Mengembalikan jenis kartu ini.
     * 
     * @return jenis kartu (0-3).
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Mengembalikan nilai kartu ini.
     * 
     * @return nilai kartu (1-13).
     */
    public int getValue() {
        return value;
    }

    /**
     * Mengembalikan representasi String dari jenis kartu.
     * 
     * @return String (mis. "Hati", "Sekop").
     */
    public String getSuitAsString() {
        switch (suit) {
            case SPADES:
                return "Sekop";
            case HEARTS:
                return "Hati";
            case DIAMONDS:
                return "Berlian";
            case CLUBS:
                return "Keriting";
            default:
                return "??";
        }
    }

    /**
     * Mengembalikan representasi String dari nilai kartu.
     * 
     * @return String (mis. "Ace", "7", "King").
     */
    public String getValueAsString() {
        switch (value) {
            case 1:
                return "Ace";
            case 2:
                return "2";
            case 3:
                return "3";
            case 4:
                return "4";
            case 5:
                return "5";
            case 6:
                return "6";
            case 7:
                return "7";
            case 8:
                return "8";
            case 9:
                return "9";
            case 10:
                return "10";
            case 11:
                return "Jack";
            case 12:
                return "Queen";
            case 13:
                return "King";
            default:
                return "??";
        }
    }

    /**
     * Mengembalikan representasi String penuh dari kartu.
     * 
     * @return String (mis. "King Hati").
     */
    public String toString() {
        return getValueAsString() + " " + getSuitAsString();
    }
}