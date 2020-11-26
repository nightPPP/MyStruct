package com.example.mystruct.bean;

import java.util.List;

/**
 *
 * @author smart
 */
public class DailyBean{
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
