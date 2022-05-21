package com.android.gymtogether.MenuActivity.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.StrictMode;
import android.util.Log;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.MenuActivity.view.MenuView;
import com.android.gymtogether.model.Training;
import com.android.gymtogether.model.User;
import com.android.gymtogether.tool.ImageConverter;

import java.net.URL;

public class MenuPresenterImpl implements MenuPresenter{

    private MenuView menuView;

    public MenuPresenterImpl(MenuView menuView){
        this.menuView = menuView;
    }
    @Override
    public void convertUriToImage(String url) {
        Bitmap bitmap = ImageConverter.convertFromUrlToBmp(url);
        menuView.setImageView(bitmap);

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
