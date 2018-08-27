package com.example.meet18;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import retrofit2.http.Url;

public class MyRecyclerView extends RecyclerView.Adapter{

    private Context context;
    String url = "http://mks-onlain.ru/wp-content/uploads/2016/10/Klassifikatsii-galaktik.jpg";

    public MyRecyclerView(Context context) {
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_list, viewGroup, false);

        if(viewType == TypesOfViewHolder.HTTP_URI_CONNECTOR) {
            return new HttpUriConnectorViewHolder(view);
        }
        if(viewType == TypesOfViewHolder.PICASSO) {
            return new PicassoViewHolder(view);
        }
        if(viewType == TypesOfViewHolder.GLIDE) {
            return new GlideViewHolder(view);
        }
        if(viewType == TypesOfViewHolder.FRESCO) {
            return new FrescoViewHolder(view);
        }
        else
            return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(i == TypesOfViewHolder.HTTP_URI_CONNECTOR)
        {
            ((HttpUriConnectorViewHolder) viewHolder).text.setText("It was downloaded by HttpUriConnection");
            HttpUriConnectionDownloader httpUriConnectionDownloader = new HttpUriConnectionDownloader(url, viewHolder.itemView);
            httpUriConnectionDownloader.execute();
        }
        else if(i == TypesOfViewHolder.PICASSO)
        {
            ((PicassoViewHolder) viewHolder).text.setText("It was downloaded by Picasso");
            PicassoDownloader.getImage(url, ((PicassoViewHolder) viewHolder).image);
        }
        else if(i == TypesOfViewHolder.GLIDE)
        {
            ((GlideViewHolder) viewHolder).text.setText("It was downloaded by Glide");
            GlideDownloader.getImage(context, url, ((GlideViewHolder) viewHolder).image);
        }
        else if(i == TypesOfViewHolder.FRESCO)
        {
            ((FrescoViewHolder) viewHolder).text.setText("It was downloaded by Fresco");
            FrescoDownloader.getImage(context, url, viewHolder.itemView);
        }
    }


    @Override
    public int getItemCount() {
        return 4;
    }

    public class HttpUriConnectorViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;

        public HttpUriConnectorViewHolder(@NonNull View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public class PicassoViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;

        public PicassoViewHolder(@NonNull View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public class GlideViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;

        public GlideViewHolder(@NonNull View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }

    public class FrescoViewHolder extends RecyclerView.ViewHolder{

        private TextView text;
        private ImageView image;

        public FrescoViewHolder(@NonNull View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.textView);
            image = (ImageView) itemView.findViewById(R.id.imageView);
        }
    }
}
