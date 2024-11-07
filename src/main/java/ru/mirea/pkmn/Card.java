package ru.mirea.pkmn;

import java.io.Serializable;
import java.lang.classfile.AnnotationElement;
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
    private String number;

    public Card() {}

    public Card(String name) {
        this.name = name;
    }

    public Card(PokemonStage pokemonStage, String name, int hp, EnergyType pokemonType, Card evolvesFrom, List<AttackSkill> skills, EnergyType weaknessType, EnergyType resistanceType, String retreatCost, String gameSet, char regulationMark, Student pokemonOwner, String number) {
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
        this.number = number;
    }

    @Override
    public String toString() {
        return "Card\n" +
                "pokemonStage = " + pokemonStage + "\n" +
                "name = " + name + "\n" +
                "hp = " + hp + "\n" +
                "pokemonType = " + pokemonType + "\n" +
                "evolvesFrom = " + evolvesFrom + "\n**\n" +
                "skills = " + skills + "\n" +
                "weaknessType = " + weaknessType + "\n" +
                "resistanceType = " + resistanceType + "\n" +
                "retreatCost = " + retreatCost + "\n" +
                "gameSet = " + gameSet + "\n" +
                "regulationMark = " + regulationMark + "\n" +
                "pokemonOwner = " + pokemonOwner + "\n" +
                "number = " + number + "\n";
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

    public List<AttackSkill> getSkills() {
        return skills;
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
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public Student getPokemonOwner() {
        return pokemonOwner;
    }

    public Card getEvolvesFrom() {
        return evolvesFrom;
    }

    public int getHp() {
        return hp;
    }

    public Object getGameSet() {
        return gameSet;
    }

    public PokemonStage getPokemonStage() {
        return pokemonStage;
    }

    public String getRetreatCost() {
        return retreatCost;
    }

    public EnergyType getWeaknessType() {
        return weaknessType;
    }

    public EnergyType getResistanceType() {
        return resistanceType;
    }

    public EnergyType getPokemonType() {
        return pokemonType;
    }

    public char getRegulationMark() {
        return regulationMark;
    }
}
