package com.android.gymtogether.LoginGoogleActivity.presenter;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import com.android.gymtogether.model.User;
import com.android.gymtogether.LoginGoogleActivity.view.LoginGoogleView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import java.util.Objects;

import static androidx.constraintlayout.widget.ConstraintLayoutStates.TAG;

public class LoginGooglePresenterImpl implements  LoginGooglePresenter{

    private LoginGoogleView loginGoogleView;
    private GoogleSignInClient mGoogleSignInClient;
    private User user;

    public LoginGooglePresenterImpl(LoginGoogleView loginGoogleView){
        this.loginGoogleView =loginGoogleView;
        user = new User();
    }

    @Override
    public void loginUser(Activity activity) {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso);
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, 1);
    }

    @Override
    public void getUserDetails(Task<GoogleSignInAccount> completedTask) {

        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            user.setName(account.getDisplayName());
            user.setEmail(account.getEmail());
            user.setPhotoUrl(Objects.requireNonNull(account.getPhotoUrl()).toString());

        } catch (ApiException e) {
            // The ApiException status code indicates the detailed failure reason.
            // Please refer to the GoogleSignInStatusCodes class reference for more information.
            Log.w(TAG, "signInResult:failed code=" + e.getStatusCode());
        }
        loginGoogleView.setUserDetails(user);
    }



}
