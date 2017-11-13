package com.duaruang.pnmportal.data;

/**
 * Created by way on 9/17/2017.
 */

public class News {

    private String title, description, picture, created_date, modified_date;

    public News(String title, String description, String picture, String created_date, String modified_date){
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.created_date = created_date;
        this.modified_date = modified_date;
    }

    public String getTitle(){
        return title;
    }

    public String getDescription(){
        return description;
    }

    public String getPicture(){
        return picture;
    }

    public String getCreated_date(){
        return created_date;
    }

    public String getModified_date(){
        return modified_date;
    }

    @Override
    public String toString()
    {
        return String.format(
                "[news: title=%1$s, description=%2$s, picture=%3$s, created_date=%4$s, modified_date=%5$s]",
                title, description, picture, created_date, modified_date);
    }
}
