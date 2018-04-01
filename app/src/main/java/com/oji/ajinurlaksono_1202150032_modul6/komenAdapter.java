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
    String useremail;
    String url;
    Context context;
    List<komenModel> MainImageUploadInfoList;

    public komenAdapter(Context context, List<komenModel> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.komen_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        komenModel UploadInfo = MainImageUploadInfoList.get(position);
        holder.komentarUSer.setText(UploadInfo.getKomentar());
        holder.namaUser.setText(UploadInfo.getUserKomen());

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
