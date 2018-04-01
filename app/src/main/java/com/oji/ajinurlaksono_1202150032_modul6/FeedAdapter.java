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
    String useremail; //inisiasi variable
    Context context; //inisiasi variable
    List<FeedData> MainImageUploadInfoList; //inisiasi variable

    public FeedAdapter(Context context, List<FeedData> TempList) {

        this.MainImageUploadInfoList = TempList; //inisiasi variable

        this.context = context; //inisiasi variable
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.feed_item, parent, false);//refrensi variable

        ViewHolder viewHolder = new ViewHolder(view);//refrensi variable

        return viewHolder; //return holder
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FeedData UploadInfo = MainImageUploadInfoList.get(position); //refrensi variable
        holder.imageNameTextView.setText(UploadInfo.getImageName()); //refrensi variable
        holder.user.setText(Dasboard.emailUser); //refrensi variable
        useremail = UploadInfo.getUserImage(); //refrensi variable
        //Loading image from Glide library.
        Glide.with(context).load(UploadInfo.getImageURL()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {

        return MainImageUploadInfoList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView user; //set variable
        public ImageView imageView; //set variable
        public TextView imageNameTextView; //set variable

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.imageView1); //refrensi variable
            user = (TextView) itemView.findViewById(R.id.user); //refrensi variable
            imageNameTextView = (TextView) itemView.findViewById(R.id.ImageNameTextView1); //refrensi variable
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int mPosition = getLayoutPosition();
// Use that to access the affected item in mWordList.
            String element = MainImageUploadInfoList.get(mPosition).toString(); //refrensi variable
            String uri = MainImageUploadInfoList.get(mPosition).getImageURL(); //refrensi variable
            String nama = MainImageUploadInfoList.get(mPosition).getImageName(); //refrensi variable
            Intent i = new Intent(view.getContext(), DetailGambar.class); //refrensi variable
            i.putExtra("useremail",useremail); //put extra
            i.putExtra("url",uri); //put extra
            i.putExtra("nama",nama); //put extra
            view.getContext().startActivity(i); //put extra
        }
    }
}
