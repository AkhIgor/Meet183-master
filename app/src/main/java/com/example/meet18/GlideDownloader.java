package com.example.meet18;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Игорь on 20.07.2018.
 */

public class GlideDownloader {

    public static void getImage(Context context, String URLString, ImageView imageView) {

        URL url = null;
        try {
            url = new URL(URLString);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        Glide.with(context)
                .load(url)
                .into(imageView);
    }
}
