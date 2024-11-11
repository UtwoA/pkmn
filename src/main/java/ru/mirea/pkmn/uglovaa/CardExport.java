package ru.mirea.pkmn.uglovaa;

import ru.mirea.pkmn.Card;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CardExport {
    private static final long serialVersionUID = 1L;

    public void saveCard(Card card) {
        String fileName = card.getName() + ".crd";

        try (FileOutputStream fileOut = new FileOutputStream(fileName); // try-with-resources xd
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

            out.writeObject(card);
            System.out.println("Card exported as " + fileName);
        } catch (IOException e) {
            System.err.println("Shit happends:\n " + e.getMessage());
            e.printStackTrace();
        }
    }
}
