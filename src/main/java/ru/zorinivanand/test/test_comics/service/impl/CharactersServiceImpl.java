package ru.zorinivanand.test.test_comics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zorinivanand.test.test_comics.dao.ModelsDAO;
import ru.zorinivanand.test.test_comics.models.Characters;
import ru.zorinivanand.test.test_comics.service.CharactersService;

import java.util.List;
@Service
public class CharactersServiceImpl implements CharactersService {

    @Autowired
    private ModelsDAO modelsDAO;


    @Override
    public List<Characters> indexCharacters() {
        return modelsDAO.indexCharacters();
    }

    @Override
    public Characters showCharacters(int id) {
        return modelsDAO.showCharacters(id);
    }

    @Override
    public void saveCharacters(Characters characters) {
        modelsDAO.saveCharacters(characters);

    }

    @Override
    public void updateCharacters(int id, Characters charactersUpdated) {
        modelsDAO.updateCharacters(id, charactersUpdated);
    }


    @Override
    public void deleteCharacters(int id) {
        modelsDAO.deleteCharacters(id);
    }
}
