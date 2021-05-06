package com.example.yr_youramigos.ui.gallery;

public class Model {
    private String title;
    private int id;
    private int progress;

    public Model(String title, int id,int progress) {
        this.title = title;
        this.id = id;
        this.progress=progress;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
