package com.android.gymtogether.ExercisesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.android.gymtogether.R;
import com.android.gymtogether.model.Exercise;

import java.io.Serializable;

public class ExercisesActivity extends AppCompatActivity {

    private Button addExerciseButton;
    private EditText exerciseNameTextEdit;
    private Spinner exerciseCategoryMenu;
    private Exercise exercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        init();

    }

    private void init(){
        addExerciseButton = findViewById(R.id.addExerciseButton);
        exerciseNameTextEdit = findViewById(R.id.exerciseNameTextEdit);
        exerciseCategoryMenu = findViewById(R.id.exerciseCategoryDropdowmMenu);

        setExerciseCategoryMenu();
    }

    public void setExercise(View view){
        exercise = new Exercise();

        if(exerciseNameTextEdit.getText().toString().isEmpty()){
            Toast.makeText(this,"Hold up... values cannot be empty '_'",Toast.LENGTH_SHORT).show();
            return;
        }

            exercise.setExerciseName(exerciseNameTextEdit.getText().toString());
            exercise.setExerciseCategory(exerciseCategoryMenu.getSelectedItem().toString());
            goToDetailsExercise();



    }

    private void setExerciseCategoryMenu(){
        String[] items = new String[]
                {Exercise.ExerciseEnum.CHEST.name(),
                Exercise.ExerciseEnum.LEGS.name(),
                Exercise.ExerciseEnum.SHOULDERS.name(),
                Exercise.ExerciseEnum.STOMACH.name(),
                };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        exerciseCategoryMenu.setAdapter(adapter);
    }

    private void goToDetailsExercise(){
        Intent intent = new Intent(this, PopUpAddExerciseActivity.class);
        Log.d("exercise",exercise.toString());
        intent.putExtra("exercise", (Serializable) exercise);
        startActivity(intent);
    }

}