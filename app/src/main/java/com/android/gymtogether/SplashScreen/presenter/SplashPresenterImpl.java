package com.android.gymtogether.SplashScreen.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.android.gymtogether.SplashScreen.view.SplashView;



public class SplashPresenterImpl implements SplashPresenter{


    private SplashView splashView;

    public SplashPresenterImpl(SplashView splashView){
        this.splashView = splashView;
    }

    @Override
    public boolean checkConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        if( activeNetworkInfo != null && activeNetworkInfo.isConnected()){
            splashView.connectionSuccessfully();
            return true;
        }else {
            splashView.connectionFailed();
            return false;
        }
    }

    @Override
    public void waitToChange(AppCompatActivity activity, Class<?> c) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Intent intent = new Intent(activity, c);
                activity.startActivity(intent);
            }
        }, 3500);
    }
}
