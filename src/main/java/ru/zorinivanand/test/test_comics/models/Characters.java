package ru.zorinivanand.test.test_comics.models;

import javax.validation.constraints.NotEmpty;

public class Characters {



    private Integer id;
    @NotEmpty(message = "should not be empty")
    private static String Name1;
    @NotEmpty(message = "should not be empty")
    private static String Power;



    public Characters(Integer id, String name, String power) {
        this.id = id;
        Name1 = name;
        Power = power;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName1() {
        return Name1;
    }

    public void setName(String name) {
        Name1 = name;
    }

    public String getPower() {
        return Power;
    }

    public void setPower(String power) {
        Power = power;
    }
}
