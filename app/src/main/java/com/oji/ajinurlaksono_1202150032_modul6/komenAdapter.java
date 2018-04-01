package com.oji.ajinurlaksono_1202150032_modul6;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by OJI on 01/04/2018.
 */

public class komenAdapter extends RecyclerView.Adapter<komenAdapter.ViewHolder> {
    String useremail; //inisiasi variable
    String url; //inisiasi variable
    Context context; //inisiasi variable
    List<komenModel> MainImageUploadInfoList; //inisiasi variable

    public komenAdapter(Context context, List<komenModel> TempList) {

        this.MainImageUploadInfoList = TempList; //refrensi variable

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.komen_item, parent, false);  //refrensi variable

        ViewHolder viewHolder = new ViewHolder(view); //refrensi variable ke holder

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        komenModel UploadInfo = MainImageUploadInfoList.get(position);
        holder.komentarUSer.setText(UploadInfo.getKomentar()); //inisiasi ke holder
        holder.namaUser.setText(UploadInfo.getUserKomen()); //inisiasi ke holder

        //Loading image from Glide library.
        //Glide.with(context).load(url).into(holder.imageView);
    }


    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView namaUser;
        public TextView komentarUSer;

        public ViewHolder(View itemView) {
            super(itemView);

            //imageView = (ImageView) itemView.findViewById(R.id.imageView);
            namaUser = (TextView) itemView.findViewById(R.id.namaUSer);
            komentarUSer = (TextView) itemView.findViewById(R.id.komentarUSer);

        }



    }
}
