package com.android.gymtogether.MenuActivity.presenter;

import android.net.Uri;
import com.android.gymtogether.LoginGoogleActivity.model.User;

public interface MenuPresenter {

    void convertUriToImage(String url);

    void getDetailsUser(String details);

}
