package ru.mirea.pkmn.uglovaa;

import com.fasterxml.jackson.databind.JsonNode;
import ru.mirea.pkmn.AttackSkill;
import ru.mirea.pkmn.Card;
import ru.mirea.pkmn.uglovaa.web.http.PkmnHttpClient;
import ru.mirea.pkmn.uglovaa.web.jdbc.DatabaseServiceImpl;
import ru.mirea.pkmn.uglovaa.*;


import java.io.IOException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

public class PkmnApplication {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        try {
            executeCardOperations();
        } catch (IOException | SQLException e) {
            System.err.println("Ошибка при выполнении операции: " + e.getMessage());
        }
    }

    private static void executeCardOperations() throws IOException, SQLException {
        Card loadedCard = loadCardFromFile("src\\main\\resources\\my_card.txt");

        if (loadedCard != null) {
            displayLoadedCard(loadedCard);
            displayEvolutionDetails(loadedCard);

            PkmnHttpClient pkmnHttpClient = new PkmnHttpClient();
            JsonNode cardJson = fetchCardJson(pkmnHttpClient, loadedCard);

            updateCardSkillsFromJson(loadedCard, cardJson);
            exportCard(loadedCard);
            deserializeAndDisplayCard("Kangaskhan.crd");



            DatabaseServiceImpl dbService = new DatabaseServiceImpl();

            //dbService.createPokemonOwner(loadedCard.getPokemonOwner());
            // ай на кондициях как жеска добавляем себя в таблицу
            //dbService.saveCardToDatabase(loadedCard);


            searchCardInDatabase(dbService, "Kangaskhan");
            searchStudentInDatabase(dbService, "Углов Алексей Андреевич");
        } else {
            System.out.println("Данные не найдены.");
        }
    }

    private static Card loadCardFromFile(String filePath) {
        CardImport cardImport = new CardImport(filePath);
        return cardImport.loadCard();
    }

    private static void displayLoadedCard(Card card) {
        //System.out.println("from my_card.txt"); // лаба номер 3
        //System.out.println(card);
    }

    private static void displayEvolutionDetails(Card card) {
        if (card.getEvolvesFrom() != null) {
            //System.out.println("Эволюционирует из:"); // лаба номер 3.5 из-за глеба епта
            //System.out.println(card.getEvolvesFrom());
        }
    }

    private static JsonNode fetchCardJson(PkmnHttpClient httpClient, Card card) throws IOException {
        JsonNode cardJson = httpClient.getPokemonCard(card.getName(), card.getNumber());
        //System.out.println("JSON-версия покемончика с сайтика"); // лаба 4, json
        //System.out.println(cardJson.toPrettyString());
        return cardJson;
    }

    private static void updateCardSkillsFromJson(Card card, JsonNode cardJson) {
        Set<String> attackDescriptions = extractAttackDescriptionsFromJson(cardJson);
        List<AttackSkill> skills = card.getSkills();

        int skillsToUpdate = Math.min(skills.size(), attackDescriptions.size());
        List<String> attackDescriptionsList = new ArrayList<>(attackDescriptions);

        for (int i = 0; i < skillsToUpdate; i++) {
            skills.get(i).setDescription(attackDescriptionsList.get(i));
        }

        //System.out.println("Карточка из JSON-версии покемончика"); // JSON to CARD + texts of Skills
        //System.out.println(card);
    }

    private static Set<String> extractAttackDescriptionsFromJson(JsonNode cardJson) {
        return cardJson.findValues("attacks")
                .stream()
                .flatMap(attack -> attack.findValues("text").stream())
                .map(JsonNode::toPrettyString)
                .collect(Collectors.toSet());
    }

    private static void exportCard(Card card) {
        CardExport cardExport = new CardExport();
        cardExport.saveCard(card);

        if (card.getEvolvesFrom() != null) {
            CardExport evolvesExport = new CardExport();
            evolvesExport.saveCard(card.getEvolvesFrom());
        }
    }

    private static void deserializeAndDisplayCard(String filePath) { // десериализация
        CardImport cardImport = new CardImport(filePath);
        Card deserializedCard = cardImport.deserializeCard(filePath);

        if (deserializedCard != null) {
            //System.out.println("Нагло украл карточку одногруппника? Тобой гордятся. Делаем десериализацию");
            // вот это мое невезучее место
            // когда здесь 140 пролетаеш...
            //System.out.println(deserializedCard);
        }
    }

    private static void searchCardInDatabase(DatabaseServiceImpl dbService, String cardName) throws SQLException, IOException {
        System.out.println("Покемон из БД + студент снизу"); // вынимаем из БД по имени
                                                             // достаем двойной итерацией потому что потому
        System.out.println(dbService.getCardFromDatabase(cardName));
    }

    private static void searchStudentInDatabase(DatabaseServiceImpl dbService, String studentName) throws SQLException {
        //System.out.println("Студент из БД"); // вынимаем из БД по имени
        System.out.println(dbService.getStudentFromDatabase(studentName));
    }
}
