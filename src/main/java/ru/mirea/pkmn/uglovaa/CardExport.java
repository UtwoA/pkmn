package ru.mirea.pkmn.uglovaa;

import ru.mirea.pkmn.Card;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class CardExport {
    public void exportCard(Card card) {
        String filename = card.getName() + ".crd";

        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {

            objectOut.writeObject(card);
            System.out.println("Card exported as " + filename);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
