package com.android.gymtogether.CompareTwoTrainingsActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
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

public class FirstDateActivity extends AppCompatActivity {

    private CalendarView firstDate;
    private LocalDate localDate;
    private Training training_;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_date);
        init();
        setDate(this);
    }

    private void init(){
        firstDate = findViewById(R.id.firstDate);
    }

    private void setDate(Context context){
        firstDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                localDate = LocalDate.of(year,month+1,dayOfMonth);
                Log.d("localDate",localDate.toString());
                getTraining(context);
            }
        });

    }

    private void goToSecondDateAct(){
        Intent intent = new Intent(this,SecondDateActivity.class);
        intent.putExtra("firstTrainingCal",training_);
        startActivity(intent);
    }

    private void getTraining(Context context){
        DatabaseManager databaseManager = new DatabaseManager(this);

        databaseManager.getTraining(new DatabaseManager.TrainingCallback() {


            @Override
            public void onCallback(Training training) {
                if(training != null) {
                    training_ = training;
                    goToSecondDateAct();
                }

            }
        }, localDate);
    }
}