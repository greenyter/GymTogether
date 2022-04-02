package com.android.gymtogether.SplashScreen.presenter;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

public interface SplashPresenter {

    //network connection
    boolean checkConnection(Context context);


    void waitToChange(AppCompatActivity activity, Class<?> c);

}
