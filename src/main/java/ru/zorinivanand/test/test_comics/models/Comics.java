package ru.zorinivanand.test.test_comics.models;

import javax.validation.constraints.NotEmpty;


public class Comics {

    @NotEmpty(message = "should not be empty")
    private static String title;
    @NotEmpty(message = "should not be empty")
    private static String Published;
    @NotEmpty(message = "should not be empty")
    private static String Penciler;
    @NotEmpty(message = "should not be empty")
    private static String CoverArtist;
    private Integer id;


    public Comics(Integer id,String title, String published, String penciler, String coverArtist) {
        this.id = id;
        this.title = title;
        Published = published;
        Penciler = penciler;
        CoverArtist = coverArtist;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static String getPublished() {
        return Published;
    }

    public void setPublished(String published) {
        Published = published;
    }

    public static String getPenciler() {
        return Penciler;
    }

    public void setPenciler(String penciler) {
        Penciler = penciler;
    }

    public static String getCoverArtist() {
        return CoverArtist;
    }

    public void setCoverArtist(String coverArtist) {
        CoverArtist = coverArtist;
    }

}
