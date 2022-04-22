package com.android.gymtogether.ExercicesActivity;

import android.content.Intent;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.R;

public class ExercicesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercices);
    }

    public void launchAddExercice(View v) {
        Intent i = new Intent(this, AddExerciceActivity.class);
        startActivity(i);
    }

}