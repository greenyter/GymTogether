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
    private LocalDate firstDate;
    private LocalDate secondDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_two_trainings);

        Bundle bundle = getIntent().getExtras();
        firstDate = (LocalDate) bundle.get("firstDate");
        secondDate = (LocalDate) bundle.get("secondDate");

        init();
        setTexts();
    }


    private void init(){
        firstTraining = findViewById(R.id.firstTrainingView);
        secondTraining = findViewById(R.id.secondTrainingView);
    }

    private void setTexts(){
        DatabaseManager databaseManager = new DatabaseManager(this);

        databaseManager.getTraining(new DatabaseManager.MyCallback() {
            @Override
            public void onCallback(List<User> value) {

            }

            @Override
            public void onCallback(Training training) {
                if(training != null)
                    firstTraining.setText(training.toString());
            }
        }, firstDate);

        databaseManager.getTraining(new DatabaseManager.MyCallback() {
            @Override
            public void onCallback(List<User> value) {

            }

            @Override
            public void onCallback(Training training) {
                if(training != null)
                    secondTraining.setText(training.toString());
            }
        }, secondDate);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, MenuActivity.class);
        startActivity(intent);
    }
}