package ru.mirea.pkmn.uglovaa.web.jdbc;

import ru.mirea.pkmn.Card;
import ru.mirea.pkmn.Student;

public interface DatabaseService {

    Card getCardFromDatabase(String cardName);

    Student getStudentFromDatabase(String studentFullName);

    void saveCardToDatabase(Card card);

    void createPokemonOwner(Student owner);
}