package com.android.gymtogether.SplashScreen;

import android.content.Intent;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.MainActivity;
import com.android.gymtogether.R;
import com.android.gymtogether.SplashScreen.Presenter.SplashPresenter;
import com.android.gymtogether.SplashScreen.Presenter.SplashPresenterImpl;
import com.android.gymtogether.SplashScreen.View.SplashView;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        hideAllBars();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashPresenter = new SplashPresenterImpl(this);
        splashPresenter.checkConnection(this);
        splashPresenter.waitToChange(this, MainActivity.class);
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