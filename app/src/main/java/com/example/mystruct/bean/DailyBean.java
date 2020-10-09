package com.example.mystruct.bean;

import com.example.mvplib.BaseModel;

import java.util.List;

public class DailyBean implements BaseModel {
    private String date;
    private List stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List getStories() {
        return stories;
    }

    public void setStories(List stories) {
        this.stories = stories;
    }
}
