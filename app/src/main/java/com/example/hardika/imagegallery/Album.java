package com.example.hardika.imagegallery;

/**
 * Created by hardika on 4/5/17.
 */

public class Album {
private  String id,title;

    public Album()
    {}
    public Album(String id,String title)
    {
        this.setId(id);
        this.setTitle(title);
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
