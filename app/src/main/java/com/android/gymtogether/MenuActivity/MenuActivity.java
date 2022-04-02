package com.android.gymtogether.MenuActivity;

import android.graphics.Bitmap;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.LoginGoogleActivity.model.User;
import com.android.gymtogether.MenuActivity.presenter.MenuPresenter;
import com.android.gymtogether.MenuActivity.presenter.MenuPresenterImpl;
import com.android.gymtogether.MenuActivity.view.MenuView;
import com.android.gymtogether.R;
import de.hdodenhof.circleimageview.CircleImageView;

public class MenuActivity extends AppCompatActivity implements MenuView {

    private CircleImageView profileImage;
    private MenuPresenter menuPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle bundle = getIntent().getExtras();
        User user = (User) bundle.get("userDetails");
        menuPresenter = new MenuPresenterImpl(this);
        initControllers();

        menuPresenter.convertUriToImage(user.getPhotoUrl());

    }

    private void initControllers(){
        profileImage = findViewById(R.id.profile_image);
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
    
    
}