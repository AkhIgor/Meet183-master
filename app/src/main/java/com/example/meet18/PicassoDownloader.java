package com.example.meet18;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.net.MalformedURLException;
import java.net.URL;

public class PicassoDownloader {

    public static void getImage(String URLString, ImageView imageView) {

        URL url = null;
        try {
            url = new URL(URLString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Picasso.get()
                .load(String.valueOf(url))
                .into(imageView);
    }
}
