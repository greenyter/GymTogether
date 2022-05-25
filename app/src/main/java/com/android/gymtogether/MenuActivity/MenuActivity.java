package com.android.gymtogether.MenuActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.android.gymtogether.AddInfoAboutUserSelfActivity.AddInfoAboutUserSelfActivity;
import com.android.gymtogether.CompareTwoTrainingsActivity.FirstDateActivity;
import com.android.gymtogether.ExercisesActivity.TrainingMenuActivity;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.LoginGoogleActivity.LoginGoogleActivity;
import com.android.gymtogether.ExercisesActivity.TrainingActivity;
import com.android.gymtogether.UserListActivity.UserListActivity;
import com.android.gymtogether.model.Training;
import com.android.gymtogether.model.User;
import com.android.gymtogether.MenuActivity.presenter.MenuPresenter;
import com.android.gymtogether.MenuActivity.presenter.MenuPresenterImpl;
import com.android.gymtogether.MenuActivity.view.MenuView;
import com.android.gymtogether.R;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import de.hdodenhof.circleimageview.CircleImageView;

import java.time.LocalDate;
import java.util.List;

import static android.app.PendingIntent.getActivity;

public class MenuActivity extends AppCompatActivity implements MenuView {

    private CircleImageView profileImage;
    private MenuPresenter menuPresenter;
    private GoogleSignInClient mGoogleSignInClient;
    private Intent intent;
    private TextView details;
    private Button toAddTrainingActivity;
    private Training training;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle bundle = getIntent().getExtras();
        try {
            training = (Training) bundle.get("training");
        }catch (NullPointerException e){
            Log.d("nullTraining","Null training bundle");
        }
        menuPresenter = new MenuPresenterImpl(this);
        initControllers();
        User user = new User();

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);

        user.setEmail(acct.getEmail());
        user.setName(acct.getDisplayName());
        user.setPhotoUrl(acct.getPhotoUrl().toString());

        String  userDetails = String.format("Name: %s\nemail: %s",
                                            user.getName(),user.getEmail());



        menuPresenter.convertUriToImage(user.getPhotoUrl());
        menuPresenter.getDetailsUser(userDetails);

        DatabaseManager databaseManager = new DatabaseManager(this);
        databaseManager.addUser(user);
        if(training!= null){
            databaseManager.addTraining(training,this);
        }

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

    public void goToUserList(View view){
        Intent intent = new Intent(this, UserListActivity.class);
        startActivity(intent);
    }

    public void goToUserDetails(View view){
        Intent intent = new Intent(this, AddInfoAboutUserSelfActivity.class);
        startActivity(intent);
    }

    public void goToCompareTwoTrainings(View view){
        Intent intent = new Intent(this, FirstDateActivity.class);
        startActivity(intent);
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
    public void goToAddTrainingActivity(View view) {
        Intent intent = new Intent(this, TrainingActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {

    }
}