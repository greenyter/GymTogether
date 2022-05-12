package com.android.gymtogether.LoginGoogleActivity;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.ExercisesActivity.ExercisesActivity;
import com.android.gymtogether.model.User;
import com.android.gymtogether.LoginGoogleActivity.presenter.LoginGooglePresenter;
import com.android.gymtogether.LoginGoogleActivity.presenter.LoginGooglePresenterImpl;
import com.android.gymtogether.LoginGoogleActivity.view.LoginGoogleView;
import com.android.gymtogether.MenuActivity.MenuActivity;
import com.android.gymtogether.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.tasks.Task;

import java.io.Serializable;

public class LoginGoogleActivity extends AppCompatActivity implements LoginGoogleView {

    private LoginGooglePresenter loginGooglePresenter;
    private SignInButton button;
    private User user;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginGooglePresenter = new LoginGooglePresenterImpl(this);

        button = findViewById(R.id.sign_in_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                signIn();

            }
        });
    }

    private void signIn() {
        loginGooglePresenter.loginUser(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        loginGooglePresenter.getUserDetails(task);

    }

    @Override
    public void setUserDetails(User user) {
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("userDetails", (Serializable) user);
       startActivity(intent);
    }

}