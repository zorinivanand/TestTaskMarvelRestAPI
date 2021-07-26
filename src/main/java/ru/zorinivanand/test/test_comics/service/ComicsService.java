package ru.zorinivanand.test.test_comics.service;

import ru.zorinivanand.test.test_comics.models.Comics;

import java.util.List;

public interface ComicsService {

    List<Comics> indexComics();
    Comics showComics(final int id);
    void saveComics(Comics comics);
    void updateComics(int id, Comics comicsUpdated);
    void deleteComics(int id);
}
