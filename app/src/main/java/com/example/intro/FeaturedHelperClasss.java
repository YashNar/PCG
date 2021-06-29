package com.example.intro;

public class FeaturedHelperClasss {

    int image;
    String title,description;


    public FeaturedHelperClasss(int image, String title, String description) {
        this.image = image;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
