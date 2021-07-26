package ru.zorinivanand.test.test_comics.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.zorinivanand.test.test_comics.dao.ModelsDAO;
import ru.zorinivanand.test.test_comics.models.Comics;
import ru.zorinivanand.test.test_comics.service.ComicsService;

import java.util.List;
@Service
public class ComicsServiceImpl implements ComicsService {

    @Autowired
    private ModelsDAO modelsDAO;


    @Override
    public List<Comics> indexComics() {
        return modelsDAO.indexComics();
    }

    @Override
    public Comics showComics(int id) {
        return modelsDAO.showComics(id);
    }

    @Override
    public void saveComics(Comics comics) {
        modelsDAO.saveComics(comics);

    }

    @Override
    public void updateComics(int id, Comics comicsUpdated) {
        modelsDAO.updateComics(id, comicsUpdated);

    }

    @Override
    public void deleteComics(int id) {
        modelsDAO.deleteComics(id);

    }
}
