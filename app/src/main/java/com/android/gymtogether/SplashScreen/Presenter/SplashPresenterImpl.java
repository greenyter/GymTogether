package com.android.gymtogether.SplashScreen.Presenter;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import com.android.gymtogether.MainActivity;
import com.android.gymtogether.SplashScreen.SplashActivity;
import com.android.gymtogether.SplashScreen.View.SplashView;



public class SplashPresenterImpl implements SplashPresenter{


    private SplashView splashView;

    public SplashPresenterImpl(SplashView splashView){
        this.splashView = splashView;
    }

    @Override
    public void checkConnection(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        if( activeNetworkInfo != null && activeNetworkInfo.isConnected()){
            splashView.connectionSuccessfully();
        }else {
            splashView.connectionFailed();
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
