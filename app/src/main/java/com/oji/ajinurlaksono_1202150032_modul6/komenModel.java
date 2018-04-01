package com.oji.ajinurlaksono_1202150032_modul6;

/**
 * Created by OJI on 01/04/2018.
 */

public class komenModel {
    private static final komenModel ourInstance = new komenModel();
    public String userKomen;

    public String komentar;

    public komenModel() {

    }

    public komenModel(String userKomen, String komentar) {

        this.userKomen = userKomen;
        this.komentar= komentar;

    }

    public String getUserKomen(){
        return userKomen;

    }
    public String getKomentar(){
        return komentar;

    }
}
