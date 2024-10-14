package ru.mirea.pkmn.uglovaa;

import java.io.Serializable;
import java.util.List;

public class Card implements Serializable {
    private static final long serialVersionUID = 1L;

    private PokemonStage pokemonStage;
    private String name;
    private int hp;
    private EnergyType pokemonType;
    private Card evolvesFrom;
    private List<AttackSkill> skills;
    private EnergyType weaknessType;
    private EnergyType resistanceType;
    private String retreatCost;
    private String gameSet;
    private char regulationMark;
    private Student pokemonOwner;

    public Card() {}

    public Card(String name) {
        this.name = name;
    }

    public Card(PokemonStage pokemonStage, String name, int hp, EnergyType pokemonType, Card evolvesFrom, List<AttackSkill> skills, EnergyType weaknessType, EnergyType resistanceType, String retreatCost, String gameSet, char regulationMark, Student pokemonOwner) {
        this.pokemonStage = pokemonStage;
        this.name = name;
        this.hp = hp;
        this.pokemonType = pokemonType;
        this.evolvesFrom = evolvesFrom;
        this.skills = skills;
        this.weaknessType = weaknessType;
        this.resistanceType = resistanceType;
        this.retreatCost = retreatCost;
        this.gameSet = gameSet;
        this.regulationMark = regulationMark;
        this.pokemonOwner = pokemonOwner;
    }

    @Override
    public String toString() {
        return "Card" +
                "pokemonStage = " + pokemonStage + "\n" +
                "name = '" + name + '\'' + "\n" +
                "hp = " + hp + "\n" +
                "pokemonType = " + pokemonType + "\n" +
                "evolvesFrom = " + evolvesFrom + "\n" +
                "skills = " + skills.stream().map(AttackSkill::toString).reduce((a, b) -> a + ", " + b).orElse("") + '\n' +
                "weaknessType = " + weaknessType + "\n" +
                "resistanceType = " + resistanceType + "\n" +
                "retreatCost = '" + retreatCost + '\'' + "\n" +
                "gameSet = '" + gameSet + '\'' + "\n" +
                "regulationMark = " + regulationMark + "\n" +
                "pokemonOwner = " + pokemonOwner + "\n";
    }


    public void setPokemonStage(PokemonStage pokemonStage) {
        this.pokemonStage = pokemonStage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void setHp(int hp) {

        this.hp = hp;
    }

    public void setPokemonType(EnergyType pokemonType) {

        this.pokemonType = pokemonType;
    }

    public void setEvolvesFrom(Card evolvesFrom) {

        this.evolvesFrom = evolvesFrom;
    }

    public void setSkills(List<AttackSkill> skills) {

        this.skills = skills;
    }

    public void setWeaknessType(EnergyType weaknessType) {
        this.weaknessType = weaknessType;
    }

    public void setResistanceType(EnergyType resistanceType) {
        this.resistanceType = resistanceType;
    }

    public void setRetreatCost(String retreatCost) {
        this.retreatCost = retreatCost;
    }

    public void setGameSet(String gameSet) {
        this.gameSet = gameSet;
    }

    public void setRegulationMark(char regulationMark) {
        this.regulationMark = regulationMark;
    }

    public void setPokemonOwner(Student pokemonOwner) {
        this.pokemonOwner = pokemonOwner;
    }
}
