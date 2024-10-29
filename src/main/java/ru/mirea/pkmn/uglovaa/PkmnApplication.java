package ru.mirea.pkmn.uglovaa;
import ru.mirea.pkmn.Card;

import java.util.Scanner;

public class PkmnApplication {
    public static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        CardImport imp = new CardImport();
        CardExport exp = new CardExport();
        Card card;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите метод импорта карты:");
        System.out.println("1 - Импорт из текстового файла");
        System.out.println("2 - Импорт из бинарного файла");

        int choice = scanner.nextInt();

        if (choice == 1) {
            // Импорт из текстового файла
            card = imp.importCards(".\\src\\main\\resources\\my_card.txt");
            exp.exportCard(card);
        } else if (choice == 2) {
            // Импорт из бинарного файла
            card = imp.importCardByte("Magmortar.crd");
        } else {
            System.out.println("Неверный выбор. Завершение программы.");
            return;
        }

        System.out.printf(card.toString());

        scanner.close();
    }
}