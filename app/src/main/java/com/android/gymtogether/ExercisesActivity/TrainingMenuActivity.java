package com.android.gymtogether.ExercisesActivity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.MenuActivity.MenuActivity;
import com.android.gymtogether.R;
import com.android.gymtogether.model.Training;
import com.android.gymtogether.model.User;
import com.android.gymtogether.tool.JSONMapper;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDate;
import java.util.List;

public class TrainingMenuActivity extends AppCompatActivity {

    private Button addNewExerciseButton;
    private Button finishButton;
    private Training training;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_menu);
        Bundle bundle = getIntent().getExtras();
        training = (Training) bundle.get("training");
        init();


    }

    private void init(){
        addNewExerciseButton = findViewById(R.id.addNewExerciseButton);
        finishButton = findViewById(R.id.finishButton);
    }

    public void addExerciseActivity(View view){
        Intent intent = new Intent(this,ExercisesActivity.class);
        intent.putExtra("training",training);
        JSONMapper<Training> trainingJSONMapper = new JSONMapper<>();
        Log.d("training",training.getDate().toString());
        startActivity(intent);

    }

    public void finishAddingExercise(View vIew){
        Intent intent = new Intent(this, MenuActivity.class);
        intent.putExtra("training",training);
        startActivity(intent);


    }


}