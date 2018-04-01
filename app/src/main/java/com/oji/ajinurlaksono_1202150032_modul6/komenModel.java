package com.oji.ajinurlaksono_1202150032_modul6;

/**
 * Created by OJI on 01/04/2018.
 */

public class komenModel {
    private static final komenModel ourInstance = new komenModel();
    public String userKomen; //membuat variable

    public String komentar; //membuat variable

    public komenModel() {

    }

    public komenModel(String userKomen, String komentar) {

        this.userKomen = userKomen; //refrensi variable
        this.komentar= komentar; //refrensi variable

    }

    public String getUserKomen(){
        return userKomen;

    }
    public String getKomentar(){
        return komentar;

    }
}
