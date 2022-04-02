package com.android.gymtogether.SplashScreen;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.LoginGoogleActivity.LoginGoogleActivity;
import com.android.gymtogether.R;
import com.android.gymtogether.SplashScreen.presenter.SplashPresenter;
import com.android.gymtogether.SplashScreen.presenter.SplashPresenterImpl;
import com.android.gymtogether.SplashScreen.view.SplashView;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideAllBars();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashPresenter = new SplashPresenterImpl(this);
        boolean connectionStatus = splashPresenter.checkConnection(this);
        if(connectionStatus){
            splashPresenter.waitToChange(this, LoginGoogleActivity.class);
        }
    }



    @Override
    public void hideAllBars() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    @Override
    public void fadeInLogo() {

    }

    @Override
    public void connectionFailed() {
        Toast.makeText(this,"Unfortunately, there is no connection, restart app and try again :(",
                Toast.LENGTH_LONG).show();
    }

    @Override
    public void connectionSuccessfully() {
        Toast.makeText(this,"Connected! ^_^",
                Toast.LENGTH_SHORT).show();
    }
}