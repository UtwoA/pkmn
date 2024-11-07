package ru.mirea.pkmn.uglovaa;
import com.fasterxml.jackson.databind.JsonNode;
import ru.mirea.pkmn.AttackSkill;
import ru.mirea.pkmn.Card;
import ru.mirea.pkmn.uglovaa.web.http.PkmnHttpClient;
import ru.mirea.pkmn.uglovaa.web.jdbc.DatabaseServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PkmnApplication {
    public static final long serialVersionUID = 1L;

    public static void main(String[] args) throws IOException, SQLException {
        CardImport imp = new CardImport();
        CardExport exp = new CardExport();
        Card cardEI;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите метод импорта карты:");
        System.out.println("0 - Ничево");
        System.out.println("1 - Импорт из текстового файла");
        System.out.println("2 - Импорт из бинарного файла");
        System.out.println("3 - PARSE MODE");

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
            cardEI = imp.importCardByte(".\\src\\main\\resources\\Kangaskhan.crd");
            System.out.printf(cardEI.toString());
        } else if (choice == 3) {
            DatabaseServiceImpl db = new DatabaseServiceImpl();
            Card card = imp.importCards(".\\src\\main\\resources\\my_card.txt");
            // вот та ебала которую делал
            PkmnHttpClient pkmnHttpClient = new PkmnHttpClient();
            JsonNode card1 = pkmnHttpClient.getPokemonCard(card.getName(), card.getNumber());
            System.out.println(card1.toPrettyString());


            Stream<JsonNode> stream = card1.findValues("attacks").stream();
            JsonNode attacks = stream.toList().getFirst();
            stream.close();
            for(JsonNode attack : attacks) {
                for(AttackSkill skill : card.getSkills()) {
                    if(skill.getName().equals(attack.findValue("name").asText())) {
                        skill.setDescription(attack.findValue("text").asText());
                    }
                }
            }

            CardExport cardExport = new CardExport();
            cardExport.exportCard(card);

            db.saveCardToDatabase(card);
            System.out.println("имя покемона введи да");
            String selectedPokemon = scanner.next();

            Card card2 = db.getCardFromDatabase(selectedPokemon);
            System.out.println(card2);
        }
        else {
            System.out.println("Неверный выбор. Завершение программы.");
            return;
        }
        scanner.close();
    }
}