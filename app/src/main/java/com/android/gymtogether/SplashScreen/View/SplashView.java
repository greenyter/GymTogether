package com.android.gymtogether.SplashScreen.View;

public interface SplashView {

    //UI view
    void hideAllBars();
    void fadeInLogo();

    //network connection
    void connectionSuccessfully();
    void connectionFailed();

}
