package com.android.gymtogether.SplashScreen.view;

public interface SplashView {

    //UI view
    void hideAllBars();
    void fadeInLogo();

    //network connection
    void connectionSuccessfully();
    void connectionFailed();

}
