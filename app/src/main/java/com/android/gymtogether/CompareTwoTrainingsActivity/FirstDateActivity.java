package com.android.gymtogether.CompareTwoTrainingsActivity;

import android.content.Intent;
import android.view.View;
import android.widget.CalendarView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.R;
import com.android.gymtogether.model.Training;

import java.time.LocalDate;

public class FirstDateActivity extends AppCompatActivity {

    private CalendarView firstDate;
    private LocalDate localDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_date);
        init();
        setDate();
    }

    private void init(){
        firstDate = findViewById(R.id.firstDate);
    }

    private void setDate(){
        firstDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                localDate = LocalDate.of(year,month,dayOfMonth);
                goToSecondDateAct();
            }
        });
    }

    private void goToSecondDateAct(){
        Intent intent = new Intent(this,SecondDateActivity.class);
        intent.putExtra("firstDate",localDate);
        startActivity(intent);
    }
}