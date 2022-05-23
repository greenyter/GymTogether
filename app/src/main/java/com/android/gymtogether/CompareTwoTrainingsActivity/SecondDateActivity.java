package com.android.gymtogether.CompareTwoTrainingsActivity;

import android.content.Intent;
import android.widget.CalendarView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.R;

import java.time.LocalDate;

public class SecondDateActivity extends AppCompatActivity {

    private CalendarView firstDate;
    private LocalDate localDate1;
    private LocalDate localDate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_date);
        Bundle bundle = getIntent().getExtras();
        localDate1 = (LocalDate) bundle.get("firstDate");

        init();
        setDate();
    }

    private void init(){
        firstDate = findViewById(R.id.firstDate2);
    }

    private void setDate(){
        firstDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                localDate2 = LocalDate.of(year,month,dayOfMonth);
                goToCompareAct();
            }
        });
    }

    private void goToCompareAct(){
        Intent intent = new Intent(this,CompareTwoTrainingsActivity.class);
        intent.putExtra("secondDate",localDate2);
        intent.putExtra("firstDate",localDate1);
        startActivity(intent);
    }
}