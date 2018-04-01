package com.oji.ajinurlaksono_1202150032_modul6;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab2 extends Fragment {

    // Creating DatabaseReference.
    DatabaseReference databaseReference;
    TextView user;
    FirebaseAuth firebaseAuth ;
    FirebaseUser firebaseUser;
    // Creating RecyclerView.
    RecyclerView recyclerView;

    // Creating RecyclerView.Adapter.
    RecyclerView.Adapter adapter ;

    // Creating Progress dialog
    ProgressDialog progressDialog;

    // Creating List of ImageUploadInfo class.
    List<FeedData> list = new ArrayList<>();


    public Tab2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Assign id to RecyclerView.

        View rootView = inflater.inflate(R.layout.fragment_tab2, container, false);
       // View layout = inflater.inflate(R.layout.feed_item, container, true);

        //RelativeLayout r = ()
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView2);
        //user = (TextView) layout.findViewById(R.id.user);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        // Setting RecyclerView size true.
        recyclerView.setHasFixedSize(true);

        // Setting RecyclerView layout as LinearLayout.
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        // Assign activity this to progress dialog.
        progressDialog = new ProgressDialog(getContext());

        // Setting up message in Progress dialog.
        progressDialog.setMessage("Loading Images From Firebase.");

        // Showing progress dialog.
        progressDialog.show();

        // Setting up Firebase image upload folder path in databaseReference.
        // The path is already defined in MainActivity.
        databaseReference = FirebaseDatabase.getInstance().getReference("popotoanoji");

//       user.setText(Dasboard.emailUser);
    //    Toast.makeText(getContext(), Dasboard.emailUser, Toast.LENGTH_LONG).show();

        // Adding Add Value Event Listener to databaseReference.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                list.clear();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                    FeedData feedData = postSnapshot.getValue(FeedData.class);

                    String user = Dasboard.emailUser;
                    String data = String.valueOf(feedData.getUserImage());

                    if(data.equals(user)){
                        //Toast.makeText(getContext(), feedData.getUserImage()+" "+Dasboard.emailUser, Toast.LENGTH_LONG).show();
                        list.add(feedData);}
                }

                adapter = new FeedAdapter(getContext(), list);
                recyclerView.setAdapter(adapter);

                // Hiding the progress dialog.
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

                // Hiding the progress dialog.
                progressDialog.dismiss();

            }
        });
        return rootView;
    }

}
