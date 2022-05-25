package com.android.gymtogether.AddInfoAboutUserSelfActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.MenuActivity.MenuActivity;
import com.android.gymtogether.R;
import com.android.gymtogether.model.UserInfo;

public class AddInfoAboutUserSelfActivity extends AppCompatActivity {

    private EditText userInfoText;
    private Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_info_about_user_self);

        init();
    }


    private void init(){
        userInfoText = findViewById(R.id.userInfoEditText);
        confirmButton = findViewById(R.id.confirmButton);
    }

    public void confirmInfo(View view){
        if(userInfoText.getText().toString().isEmpty()){
            Toast.makeText(this,"You should write something, don't you?",Toast.LENGTH_SHORT).show();
            return;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setUserInfo(userInfoText.getText().toString());

        DatabaseManager databaseManager = new DatabaseManager(this);
        databaseManager.addUserInfo(userInfo);
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}