package com.example.mystruct.bean;

import java.util.List;

public class StoriesBean {
    private int type;
    private int id;
    private String ga_prefix;
    private String title;
    private boolean multipic;
    private List images;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGa_prefix() {
        return ga_prefix;
    }

    public void setGa_prefix(String ga_prefix) {
        this.ga_prefix = ga_prefix;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isMultipic() {
        return multipic;
    }

    public void setMultipic(boolean multipic) {
        this.multipic = multipic;
    }

    public List getImages() {
        return images;
    }

    public void setImages(List images) {
        this.images = images;
    }
}
