package com.android.gymtogether.ExercisesActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.ExercisesActivity.model.Exercise;
import com.android.gymtogether.R;

import java.util.ArrayList;
import java.util.List;

public class AddExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_exercise);

    }

    public void launchHeadExercise(View v) {
        Intent i = new Intent(this, HeadExercisesActivity.class);
        startActivity(i);
    }
    public void launchChestExercise(View v) {
        Intent i = new Intent(this, ChestExercisesActivity.class);
        startActivity(i);
    }
}