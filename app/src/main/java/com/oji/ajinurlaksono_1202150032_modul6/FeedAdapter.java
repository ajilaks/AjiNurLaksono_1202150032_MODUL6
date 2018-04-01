package com.oji.ajinurlaksono_1202150032_modul6;

/**
 * Created by OJI on 31/03/2018.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by AndroidJSon.com on 6/18/2017.
 */

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.ViewHolder> {
    String useremail;
    Context context;
    List<FeedData> MainImageUploadInfoList;

    public FeedAdapter(Context context, List<FeedData> TempList) {

        this.MainImageUploadInfoList = TempList;

        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FeedData UploadInfo = MainImageUploadInfoList.get(position);
        holder.imageNameTextView.setText(UploadInfo.getImageName());
        holder.user.setText(Dasboard.emailUser);
        useremail = UploadInfo.getUserImage();
        //Loading image from Glide library.
        Glide.with(context).load(UploadInfo.getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView user;
        public ImageView imageView;
        public TextView imageNameTextView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView1);
            user = (TextView) itemView.findViewById(R.id.user);
            imageNameTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView1);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
// Use that to access the affected item in mWordList.
            String element = MainImageUploadInfoList.get(mPosition).toString();
            String uri = MainImageUploadInfoList.get(mPosition).getImageURL();
            String nama = MainImageUploadInfoList.get(mPosition).getImageName();
            Intent i = new Intent(view.getContext(), DetailGambar.class);
            i.putExtra("useremail",useremail);
            i.putExtra("url",uri);
            i.putExtra("nama",nama);
            view.getContext().startActivity(i);
        }
    }
}
