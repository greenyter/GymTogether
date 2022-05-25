package com.android.gymtogether.CompareTwoTrainingsActivity;

import android.content.Context;
import android.content.Intent;
import android.widget.CalendarView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.FireBaseDatabase.DatabaseManager;
import com.android.gymtogether.R;
import com.android.gymtogether.model.Training;
import com.android.gymtogether.model.User;

import java.time.LocalDate;
import java.util.List;

public class SecondDateActivity extends AppCompatActivity {

    private CalendarView firstDate;
    private Training training1;
    private Training training2;
    private LocalDate firstDate_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_date);
        Bundle bundle = getIntent().getExtras();
        training1 = (Training) bundle.get("firstTrainingCal");

        init();
        setDate(this);
    }

    private void init(){
        firstDate = findViewById(R.id.firstDate2);
    }

    private void setDate(Context context){
        firstDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                firstDate_ = LocalDate.of(year,month+1,dayOfMonth);
                getTraining(context);
            }
        });

    }

    private void goToCompareAct(){
        Intent intent = new Intent(this,CompareTwoTrainingsActivity.class);
        intent.putExtra("firstTrainingCal",training1);
        intent.putExtra("secondTrainingCal",training2);
        startActivity(intent);
    }

    private void getTraining(Context context){
        DatabaseManager databaseManager = new DatabaseManager(this);

        databaseManager.getTraining(new DatabaseManager.TrainingCallback() {

            @Override
            public void onCallback(Training training) {
                if(training != null){
                    training2 = training;
                    goToCompareAct();
                }

            }
        }, firstDate_);
    }
}