package com.example.meet18;

import android.provider.MediaStore;

import java.util.List;

import retrofit2.http.GET;

/**
 * Created by Игорь on 20.07.2018.
 */

public interface ServerApi {

        @GET("getImages")
        List<MediaStore.Images> getImages();
}
