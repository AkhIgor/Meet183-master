package com.example.meet18;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.net.URI;
import java.net.URL;

import static android.view.View.GONE;

/**
 * Created by Игорь on 20.07.2018.
 */

public class FrescoDownloader {

    public static void getImage(Context context, String URLString, View view) {

        final Uri uri = Uri.parse(URLString);

        try {
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(R.id.draweeView);
            simpleDraweeView.setVisibility(View.VISIBLE);
            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setVisibility(GONE);
            simpleDraweeView.setImageURI(uri);
        } catch (ClassCastException ignored) {}
    }
}
