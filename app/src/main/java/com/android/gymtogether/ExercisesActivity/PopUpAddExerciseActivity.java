package com.android.gymtogether.ExercisesActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.gymtogether.R;
import com.android.gymtogether.model.Exercise;
import com.android.gymtogether.model.Training;

public class PopUpAddExerciseActivity extends AppCompatActivity {


    private TextView exerciseNameTextEdit;
    private EditText repeatTextEdit;
    private EditText seriesTextEdit;
    private EditText weightTextEdit;
    private Button addDetailsExerciseButton;
    private Training training;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_add_exercise);
        Bundle bundle = getIntent().getExtras();
        training = (Training) bundle.get("training");
        init();
    }

    private void init(){
        exerciseNameTextEdit = findViewById(R.id.exerciseNameTextEdit);
        repeatTextEdit = findViewById(R.id.repeatTextEdit);
        seriesTextEdit = findViewById(R.id.seriesTextEdit);
        weightTextEdit = findViewById(R.id.weightTextEdit);
        addDetailsExerciseButton = findViewById(R.id.addDetailsExerciseButton);
    }

    public void setDetailsExercise(View view){
        Bundle bundle = getIntent().getExtras();
        Exercise exercise = (Exercise) bundle.get("exercise");

        if(repeatTextEdit.getText().toString().isEmpty() ||
                seriesTextEdit.getText().toString().isEmpty() ||
                weightTextEdit.getText().toString().isEmpty()){
            Toast.makeText(this,"Hold up... values cannot be empty '_'",Toast.LENGTH_SHORT).show();
            return;
        }

            exercise.setRepeatNumber(Integer.parseInt(repeatTextEdit.getText().toString()));
            exercise.setSeriesNumber(Integer.parseInt(seriesTextEdit.getText().toString()));
            exercise.setWeight(Integer.parseInt(weightTextEdit.getText().toString()));
            training.addExercise(exercise);

            Log.d("trainingDate",training.getDate().toString());
            Intent intent = new Intent(this,TrainingMenuActivity.class);
            intent.putExtra("training",(Training) training);
            startActivity(intent);

            
    }

}