package com.oji.ajinurlaksono_1202150032_modul6;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Dasboard extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    public static String emailUser; //inisiasi variable
    private ViewPager mViewPager; //inisiasi variable
    private SectionsPageAdapter mSectionsPageAdapter; //inisiasi variable
    FirebaseAuth firebaseAuth ; //inisiasi variable
    FirebaseUser firebaseUser; //inisiasi variable


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);
        firebaseAuth = FirebaseAuth.getInstance(); //referensi variable
        firebaseUser = firebaseAuth.getCurrentUser(); //referensi variable
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); //referensi variable
        setSupportActionBar(toolbar); //referensi variable
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.


        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container); //referensi variable
setupViewPager(mViewPager); //referensi variable
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs); //referensi variable
        tabLayout.setupWithViewPager(mViewPager); //referensi variable

        //mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);// button ke tambah gambar
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Dasboard.this, TambahGambar.class);
                startActivity(i);

            }
        });
        firebaseUser = firebaseAuth.getCurrentUser(); //referensi variable
        emailUser = firebaseUser.getEmail().toString(); //referensi variable


    }
        //method untuk Tabbed Fragment
    public void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new Tab1(),"Terbaru");
        adapter.addFragment(new Tab2(),"Poto Saya");
        viewPager.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dasboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            //Destroying login season.
                    firebaseAuth.signOut();

            // Finishing current User Profile activity.
            finish();

            // Redirect to Login Activity after click on logout button.
            Intent intent = new Intent(Dasboard.this, Login.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    }

