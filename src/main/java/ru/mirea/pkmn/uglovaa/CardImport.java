package ru.mirea.pkmn.uglovaa;

import ru.mirea.pkmn.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CardImport {
    public Card importCards(String filePath) {

        Card card = new Card();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            card.setPokemonStage(PokemonStage.valueOf(br.readLine().split("\\. ")[1]));
            card.setName(br.readLine().split("\\. ")[1]);
            card.setHp(Integer.parseInt(br.readLine().split("\\. ")[1]));
            card.setPokemonType(EnergyType.valueOf(br.readLine().split("\\. ")[1]));
            String line5 = br.readLine().split("\\. ")[1];
            if (!line5.equals("-")) {
                card.setEvolvesFrom(new Card(line5));
            }
            String[] line6 = br.readLine().split("\\. ")[1].split(",");
            List<AttackSkill> skills = new ArrayList<>();
            for (String i : line6) {
                String[] arr = i.split(" / ");
                AttackSkill attackSkill = new AttackSkill(arr[1], "", arr[0], Integer.parseInt(arr[2]));
                skills.add(attackSkill);
            }
            card.setSkills(skills);
            card.setWeaknessType(EnergyType.valueOf(br.readLine().split("\\. ")[1]));
            String line8 = br.readLine().split("\\. ")[1];
            if (!line8.equals("-")) {
                card.setResistanceType(EnergyType.valueOf(br.readLine().split("\\. ")[1]));
            }
            card.setRetreatCost(br.readLine().split("\\. ")[1]);
            card.setGameSet(br.readLine().split("\\. ")[1]);
            card.setRegulationMark(br.readLine().split("\\. ")[1].charAt(0));
            String line12 = br.readLine().split("\\. ")[1];
            String[] nameStudent = line12.split(" / ");
            card.setPokemonOwner(new Student(nameStudent[0], nameStudent[1], nameStudent[2], nameStudent[3]));
        }
        catch (IOException e) {
            System.err.println("Error while importing card: " + e.getMessage());
        }
        return card;
    }

    public Card importCardByte(String filename) {
        Card card = new Card();
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            card = (Card) objectIn.readObject();
        }
        catch (IOException e) {
            System.err.println("Error while importing card: " + e.getMessage());
        }
        catch (ClassNotFoundException e) {
            System.err.println("Card class not found: " + e.getMessage());
        }
        return card;
    }
}
