package com.oji.ajinurlaksono_1202150032_modul6;

/**
 * Created by OJI on 30/03/2018.
 */

public class ImageUploadInfo {

    public String imageName; //inisiasi variable

    public String imageURL; //inisiasi variable
    public String userImage; //inisiasi variable

    public ImageUploadInfo() {

    }

    public ImageUploadInfo(String name, String url, String user) {

        this.imageName = name; //refrensi variable
        this.imageURL= url; //refrensi variable
        this.userImage = user;//refrensi variable
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
