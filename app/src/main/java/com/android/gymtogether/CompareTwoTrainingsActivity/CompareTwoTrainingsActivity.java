package com.android.gymtogether.CompareTwoTrainingsActivity;

import android.content.Intent;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.MenuActivity.MenuActivity;
import com.android.gymtogether.R;
import com.android.gymtogether.model.Training;
import com.android.gymtogether.model.User;

import java.time.LocalDate;
import java.util.List;

public class CompareTwoTrainingsActivity extends AppCompatActivity {

    private TextView firstTraining;
    private TextView secondTraining;
    private Training firstDate;
    private Training secondDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_two_trainings);

        Bundle bundle = getIntent().getExtras();
        firstDate = (Training) bundle.get("firstTrainingCal");
        secondDate = (Training) bundle.get("secondTrainingCal");

        init();
        setTexts();
    }


    private void init(){
        firstTraining = findViewById(R.id.firstTrainingView);
        secondTraining = findViewById(R.id.secondTrainingView);
    }

    private void setTexts(){
      firstTraining.setText(firstDate.toString());
      secondTraining.setText(secondDate.toString());
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}