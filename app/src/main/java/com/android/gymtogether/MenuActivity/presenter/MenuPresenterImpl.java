package com.android.gymtogether.MenuActivity.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Log;
import com.android.gymtogether.MenuActivity.view.MenuView;

import java.net.URL;

public class MenuPresenterImpl implements MenuPresenter{

    private MenuView menuView;

    public MenuPresenterImpl(MenuView menuView){
        this.menuView = menuView;
    }
    @Override
    public void convertUriToImage(String url) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Log.d("profile",url);
        try {
            URL urlString = new URL(url);
            Bitmap bmp = BitmapFactory.decodeStream(urlString.openConnection().getInputStream());
            menuView.setImageView(bmp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getDetailsUser(String details) {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Log.d("profile",details);
        try {
            menuView.setText(details);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
