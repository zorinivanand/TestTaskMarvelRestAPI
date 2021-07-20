package ru.zorinivanand.test.test_comics.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.zorinivanand.test.test_comics.models.Characters;
import ru.zorinivanand.test.test_comics.models.Comics;

import java.util.List;
@Component
public class ModelsDAO {
    private final JdbcTemplate jdbcTemplate;


    public ModelsDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public  List<Comics> index1(){
        return jdbcTemplate.query("SELECT * FROM Comics",new BeanPropertyRowMapper<>(Comics.class));
    }

    public  Comics show1(final int id){
        return jdbcTemplate.query("SELECT * FROM Comics WHERE id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Comics.class))
                .stream().findAny().orElse(null);
    }
    public void save1(Comics comics){
        jdbcTemplate.update("INSERT INTO Comics VALUES(1,?,?,?,?)", comics.getTitle(),comics.getPublished(),comics.getPenciler(),comics.getCoverArtist());


    }

    public void update1(int id, Comics comicsUpdated) {
        jdbcTemplate.update("UPDATE Comics SET title =?,published = ?,penciler = ?,coverArtist = ? WHERE id = ?",comicsUpdated.getTitle(),comicsUpdated.getPublished(),comicsUpdated.getPenciler(),comicsUpdated.getCoverArtist(),id);
    }


    public void delete1(int id) {
        jdbcTemplate.update("DELETE FROM Comics WHERE id=?",id);
    }




    public List<Character> index2(){
        return jdbcTemplate.query("SELECT * FROM Characters",new BeanPropertyRowMapper<>(Character.class));
    }

    public Character show2(final int id){
        return jdbcTemplate.query("SELECT * FROM Characters WHERE id=?",new Object[]{id}, new BeanPropertyRowMapper<>(Character.class))
                .stream().findAny().orElse(null);
    }
    public void save2(Characters characters){
        jdbcTemplate.update("INSERT INTO Comics VALUES(1,?,?)", characters.getName1(), characters.getPower());




    }

    public void update2(int id, Characters charactersUpdated) {
        jdbcTemplate.update("UPDATE Characters SET Name1 = ?,Power = ? WHERE id = ?",charactersUpdated.getName1(),charactersUpdated.getPower(),id);
    }

    public void delete2(int id) {
        jdbcTemplate.update("DELETE FROM Characters WHERE id=?",id);
    }
}
