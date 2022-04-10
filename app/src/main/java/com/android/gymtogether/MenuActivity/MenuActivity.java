package com.android.gymtogether.MenuActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.LoginGoogleActivity.LoginGoogleActivity;
import com.android.gymtogether.LoginGoogleActivity.model.User;
import com.android.gymtogether.MenuActivity.presenter.MenuPresenter;
import com.android.gymtogether.MenuActivity.presenter.MenuPresenterImpl;
import com.android.gymtogether.MenuActivity.view.MenuView;
import com.android.gymtogether.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import de.hdodenhof.circleimageview.CircleImageView;

public class MenuActivity extends AppCompatActivity implements MenuView {

    private CircleImageView profileImage;
    private MenuPresenter menuPresenter;
    private GoogleSignInClient mGoogleSignInClient;
    private Intent intent;
    private TextView details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle bundle = getIntent().getExtras();
        User user = (User) bundle.get("userDetails");
        menuPresenter = new MenuPresenterImpl(this);
        initControllers();

        String userDetails = String.format("Name: %s\nemail: %s",
                                            user.getName(),user.getEmail());

        menuPresenter.convertUriToImage(user.getPhotoUrl());
        menuPresenter.getDetailsUser(userDetails);

    }

    public void button(View v){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mGoogleSignInClient.signOut()
                    .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                             backToPrevAct();
                        }

                    });

    }


    private void backToPrevAct(){
        intent = new Intent(this,LoginGoogleActivity.class);
        startActivity(intent);
    }

    private void initControllers(){
        profileImage = findViewById(R.id.profile_image);
        details = findViewById(R.id.userDetails);
    }

    @Override
    public void setImageView(Bitmap photoBitmap) {
        profileImage.setImageBitmap(photoBitmap);
    }

    @Override
    public void getImageFailed() {
        Toast.makeText(this,"failed",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void getConnectionFailed() {
        Toast.makeText(this,"failedConnection",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setText(String userDetails) {
        details.setText(userDetails);
    }

    @Override
    public void goToAddTrainingActivity() {
        
    }


}