package com.android.gymtogether.ExercicesActivity;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.R;

public class AddExerciceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercice);
    }

    public void launchHeadExercice(View v) {
        Intent i = new Intent(this, HeadExercicesActivity.class);
        startActivity(i);
    }
    public void launchChestExercice(View v) {
        Intent i = new Intent(this, ChestExercicesActivity.class);
        startActivity(i);
    }
}