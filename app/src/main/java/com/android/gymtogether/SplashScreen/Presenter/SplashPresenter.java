package com.android.gymtogether.SplashScreen.Presenter;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;

public interface SplashPresenter {

    //network connection
    void checkConnection(Context context);


    void waitToChange(AppCompatActivity activity, Class<?> c);

}
