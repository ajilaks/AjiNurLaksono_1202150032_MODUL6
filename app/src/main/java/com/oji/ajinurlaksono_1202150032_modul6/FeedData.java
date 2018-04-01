package com.oji.ajinurlaksono_1202150032_modul6;

/**
 * Created by OJI on 31/03/2018.
 */

public class FeedData {
    private static final FeedData ourInstance = new FeedData();

    public String imageName;//membuat variable

    public String imageURL; //membuat variable
    public String userImage; //membuat variable

    public FeedData() {

    }

    public FeedData(String name, String url, String user) {

        this.imageName = name; //refrensi variable
        this.imageURL= url; //refrensi variable
        this.userImage = user; //refrensi variable
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageURL() {
        return imageURL;
    }
    public String getUserImage() {
        return userImage;
    }
}
