package com.example.app.models;

public class Photo {
    private Integer id;
    private String title;
    private String date;

    public Photo(Integer id, String date, String title) {
        this.id = id;
        this.date = date;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
