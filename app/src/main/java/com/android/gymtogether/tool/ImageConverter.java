package com.android.gymtogether.tool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Log;

import java.net.URL;

public class ImageConverter {

    public static Bitmap convertFromUrlToBmp(String url){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Log.d("profile",url);
        try {
            URL urlString = new URL(url);
            Bitmap bmp = BitmapFactory.decodeStream(urlString.openConnection().getInputStream());
            return bmp;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
