package com.oji.ajinurlaksono_1202150032_modul6;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailGambar extends AppCompatActivity {
    ImageView img;
    TextView dNama,tUseremail;
    Context c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gambar);
        dNama = (TextView) findViewById(R.id.detailName);
        tUseremail = (TextView) findViewById(R.id.useremail);
        Intent i = getIntent();
        String url = i.getStringExtra("url");
        String nama = i.getStringExtra("nama");
        String useremail = i.getStringExtra("useremail");

        img = (ImageView) findViewById(R.id.detailGambar);
        tUseremail.setText(useremail);
        dNama.setText(nama);
        Glide.with(this).load(url).into(img);
    }

    public void post(View view) {
        Toast.makeText(this, "Fitur Ini berbayar, Hubungi LINE: ajilaks33 :P", Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Fitur Ini berbayar, Hubungi LINE: ajilaks33 :P", Toast.LENGTH_LONG).show();
    }
}
