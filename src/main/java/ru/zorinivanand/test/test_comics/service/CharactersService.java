package ru.zorinivanand.test.test_comics.service;

import ru.zorinivanand.test.test_comics.models.Characters;

import java.util.List;

public interface CharactersService {

    List<Characters> indexCharacters();
    Characters showCharacters(final int id);
    void saveCharacters(Characters characters);
    void updateCharacters(int id, Characters charactersUpdated);
    void deleteCharacters(int id);
}
