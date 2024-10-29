package ru.mirea.pkmn.uglovaa;
import com.fasterxml.jackson.databind.JsonNode;
import ru.mirea.pkmn.Card;
import ru.mirea.pkmn.uglovaa.web.http.PkmnHttpClient;

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PkmnApplication {
    public static final long serialVersionUID = 1L;

    public static void main(String[] args) throws IOException {
        CardImport imp = new CardImport();
        CardExport exp = new CardExport();
        Card cardEI;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите метод импорта карты:");
        System.out.println("0 - Ничево");
        System.out.println("1 - Импорт из текстового файла");
        System.out.println("2 - Импорт из бинарного файла");

        int choice = scanner.nextInt();
        if (choice == 0){
            System.out.println("\n");
        }
        else if (choice == 1) {
            // Импорт из текстового файла
            cardEI = imp.importCards(".\\src\\main\\resources\\my_card.txt");
            exp.exportCard(cardEI);
            System.out.printf(cardEI.toString());
        } else if (choice == 2) {
            // Импорт из бинарного файла
            cardEI = imp.importCardByte("Magmortar.crd");
            System.out.printf(cardEI.toString());
        } else {
            System.out.println("Неверный выбор. Завершение программы.");
            return;
        }


        scanner.close();

        PkmnHttpClient pkmnHttpClient = new PkmnHttpClient();

        JsonNode cardJson = pkmnHttpClient.getPokemonCard("Pikachu V", "86");
        System.out.println(cardJson.toPrettyString());

        System.out.println(cardJson.findValues("attacks")
                .stream()
                .map(JsonNode::toPrettyString)
                .collect(Collectors.toSet()));
    }
}