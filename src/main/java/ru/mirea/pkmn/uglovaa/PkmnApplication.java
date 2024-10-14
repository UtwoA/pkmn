package ru.mirea.pkmn.uglovaa;
import java.io.IOException;

public class PkmnApplication {
    public static final long serialVersionUID = 1L;
    public static void main(String[] args) throws IOException {

        CardImport imp = new CardImport();
        Card card = imp.importCards(".\\src\\main\\resources\\my_card.txt");

        CardExport exp = new CardExport();
        exp.exportCard(card);

        card = imp.importCardByte(".\\Kangaskhan.crd");
        System.out.printf(card.toString());
    }
}