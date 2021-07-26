package ru.zorinivanand.test.test_comics.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.zorinivanand.test.test_comics.models.Characters;
import ru.zorinivanand.test.test_comics.models.Comics;
import sun.jvm.hotspot.debugger.Page;

import java.awt.print.Pageable;
@Component
public class ModelsDAO {
    private final JdbcTemplate jdbcTemplate;


    public ModelsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }




    public Page<Comics> indexComics(Pageable pageable){
        Page comicsPage = (Page<Comics>) jdbcTemplate.query("SELECT * FROM Comics", new BeanPropertyRowMapper<>(Comics.class));
        return comicsPage;
    }

    public  Comics showComics(final int id){
        return jdbcTemplate.query("SELECT * FROM Comics WHERE id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Comics.class))
                .stream().findAny().orElse(null);
    }
    public void saveComics(Comics comics){
        jdbcTemplate.update("INSERT INTO Comics VALUES(1,?,?,?,?)", comics.getTitle(),comics.getPublished(),comics.getPenciler(),comics.getCoverArtist());


    }

    public void updateComics(int id, Comics comicsUpdated) {
        jdbcTemplate.update("UPDATE Comics SET title =?,published = ?,penciler = ?,coverArtist = ? WHERE id = ?",comicsUpdated.getTitle(),comicsUpdated.getPublished(),comicsUpdated.getPenciler(),comicsUpdated.getCoverArtist(),id);
    }


    public void deleteComics(int id) {
        jdbcTemplate.update("DELETE FROM Comics WHERE id=?",id);
    }




    public Page<Characters> indexCharacters(Pageable pageable){
        Page charactersPage = (Page<Characters>) jdbcTemplate.query("SELECT * FROM Characters", new BeanPropertyRowMapper<>(Characters.class));
        return charactersPage;
    }

    public Characters showCharacters(final int id){
        return jdbcTemplate.query("SELECT * FROM Characters WHERE id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Characters.class))
                .stream().findAny().orElse(null);
    }
    public void saveCharacters(Characters characters){
         jdbcTemplate.update("INSERT INTO Comics VALUES(1,?,?)", characters.getName1(), characters.getPower());
    }

    public void updateCharacters(int id, Characters charactersUpdated) {
         jdbcTemplate.update("UPDATE Characters SET Name1 = ?,Power = ? WHERE id = ?",charactersUpdated.getName1(),charactersUpdated.getPower(),id);
    }

    public void deleteCharacters(int id) {
         jdbcTemplate.update("DELETE FROM Characters WHERE id=?",id);
    }
}
