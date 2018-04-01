package com.oji.ajinurlaksono_1202150032_modul6;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.ArrayList;
import java.util.List;

public class DetailGambar extends AppCompatActivity {
    DatabaseReference databaseReference; //inisiasi variable
    RecyclerView.Adapter adapter; //inisiasi variable
    RecyclerView recyclerView; //inisiasi variable
    ImageView img; //inisiasi variable
    EditText kom; //inisiasi variable
    TextView dNama,tUseremail; //inisiasi variable
    String nama; //inisiasi variable
    String useremail; //inisiasi variable
    String userKomen; //inisiasi variable
    Context c; //inisiasi variable
    List<komenModel> komenList = new ArrayList<>(); //inisiasi variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_gambar);
        dNama = (TextView) findViewById(R.id.detailName); //referensi variable
        tUseremail = (TextView) findViewById(R.id.useremail); //referensi variable
        kom = (EditText)findViewById(R.id.komentr); //referensi variable


        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewKomen); //referensi variable

        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true); //referensi variable

        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(DetailGambar.this)); //referensi variable
        Toast.makeText(DetailGambar.this, Dasboard.emailUser, Toast.LENGTH_SHORT).show(); //referensi variable
        //
        Intent i = getIntent(); //referensi variable
        String url = i.getStringExtra("url"); //referensi variable dari intent
        nama = i.getStringExtra("nama"); //referensi variable dari intent
        databaseReference = FirebaseDatabase.getInstance().getReference("komen/"+nama); //referensi variable dari intent
        useremail = i.getStringExtra("useremail"); //referensi variable dari intent
        userKomen = Dasboard.emailUser; //referensi variable
        img = (ImageView) findViewById(R.id.detailGambar); //referensi variable
        tUseremail.setText(useremail); //set textview
        dNama.setText(nama); //set textview
        Glide.with(this).load(url).into(img);//menampilkan gambar
        showData();//memanggil method
    }

    public void post(View view) { //onClicked button
        komenModel k = new komenModel(userKomen,kom.getText().toString()); //refrensikan variable

       String id = databaseReference.push().getKey(); //refrensikan variable ke id
        databaseReference.child(id).setValue(k); //set child firebase

    kom.setText(""); //set Textview
        View v = this.getCurrentFocus();
        if (v != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

    }
        Toast.makeText(DetailGambar.this, "Komentar di Post", Toast.LENGTH_SHORT).show();
    }

    public void showData(){ //Method untuk menampilkan data

        databaseReference.addValueEventListener(new ValueEventListener() {//eksekusi data dari firebase
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                komenList.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) { //foreach memanggil data

                    komenModel imageUploadInfo = postSnapshot.getValue(komenModel.class); //get data dari firebase
                    //Toast.makeText(DetailGambar.this, imageUploadInfo.getUserKomen(), Toast.LENGTH_LONG).show();
                    komenList.add(imageUploadInfo); //add data ke listviews
                }

                adapter = new komenAdapter(DetailGambar.this,komenList);

                recyclerView.setAdapter(adapter);

                // Hiding the progress dialog.

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.


            }
        });
    }
}
