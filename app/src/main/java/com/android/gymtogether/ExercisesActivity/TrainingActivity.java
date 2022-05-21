package com.android.gymtogether.ExercisesActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.ExercisesActivity.ExercisesActivity;
import com.android.gymtogether.R;
import com.android.gymtogether.model.Training;

import java.time.LocalDate;

public class TrainingActivity extends AppCompatActivity {

    private CalendarView trainingDateCalendarView;
    private Button goToNextAct;
    private Training training;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);
        intent = new Intent(this,ExercisesActivity.class);
        init();
        setDate();
    }

    private void init(){
        trainingDateCalendarView = findViewById(R.id.trainingDateCalendar);
        goToNextAct = findViewById(R.id.addTrainingButton);

    }

    private void setDate(){
        trainingDateCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                training = new Training();
                training.setDate(LocalDate.of(year,month,dayOfMonth));
                goToNextAct.setVisibility(View.VISIBLE);
            }
        });
    }

    public void goToExerciseActivity(View view){
        intent.putExtra("training",(Training) training);
        startActivity(intent);
    }
}