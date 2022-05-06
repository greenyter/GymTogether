package com.android.gymtogether.LoginGoogleActivity.presenter;

import android.app.Activity;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.Task;

public interface LoginGooglePresenter {

    void loginUser(Activity activity);

    void getUserDetails(Task<GoogleSignInAccount> completedTask);
}
