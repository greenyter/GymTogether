package com.android.gymtogether.ExercisesActivity;

import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.R;

public class TrainingMenuActivity extends AppCompatActivity {

    private Button addNewExerciseButton;
    private Button finishButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_menu);
    }

    private void init(){
        addNewExerciseButton = findViewById(R.id.addNewExerciseButton);
        finishButton = findViewById(R.id.finishButton);
    }
}