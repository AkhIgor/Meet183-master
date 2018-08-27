package com.example.meet18;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ImageView;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUriConnectionDownloader extends AsyncTask<URL, View, Bitmap> {

    private View view;
    private URL url;
    private ImageView imageView;

    public HttpUriConnectionDownloader(String URLString, View view) {

        try {
            URL url = new URL(URLString);
            this.url = url;

            imageView = (ImageView) view.findViewById(R.id.imageView);
        } catch (MalformedURLException ignored) {}
    }

    @Override
    protected Bitmap doInBackground(URL... urls) {
        HttpURLConnection connection = null;

        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200)
                return (BitmapFactory.decodeStream(connection.getInputStream()));
            //return BitmapFactory.decodeStream(connection.getInputStream());
        } catch (Exception ignored) {
            ignored.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageView.setImageBitmap(bitmap);
    }
}
