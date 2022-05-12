package com.android.gymtogether.ExercisesActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.gymtogether.model.Exercise;
import com.android.gymtogether.R;

public class ChestExercisesActivity extends AppCompatActivity {

    public EditText editTextRepeatNumber, editTextSeriesNumber2;
    public Button AddExerciseButton2;
    public TextView ExerciseNameView;
    private ListView ExerciseList;
    public int id;

    private String ExerciseName; //nazwa ćwiczenia
    public int repeatNumber, seriesNumber; //liczba powtorzen/serii
    ExerciseManager exerciseManager = ExerciseManager.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_exercises);

    }


    public void ShowPopUp(View v){

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewPopupwindow = layoutInflater.inflate(R.layout.activity_pop_up_add_exercise, null);

        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;

        PopupWindow popupWindow = new PopupWindow(viewPopupwindow, width, height, true);
        popupWindow.showAtLocation(v, Gravity.CENTER,0,0);

        editTextRepeatNumber = (EditText) viewPopupwindow.findViewById(R.id.editTextRepeatNumber);
        editTextSeriesNumber2 = (EditText) viewPopupwindow.findViewById(R.id.editTextSeriesNumber2);

        Button b = (Button)v;
        ExerciseName = b.getText().toString();
        ExerciseNameView = (TextView) viewPopupwindow.findViewById(R.id.ExerciseNameView);
        ExerciseNameView.setText(ExerciseName);

        AddExerciseButton2 = (Button) viewPopupwindow.findViewById(R.id.AddExerciseButton2);

        ExerciseList = (ListView) viewPopupwindow.findViewById(R.id.ExerciseList);




        AddExerciseButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                seriesNumber = Integer.parseInt(editTextRepeatNumber.getText().toString());
                repeatNumber = Integer.parseInt(editTextSeriesNumber2.getText().toString());

                exerciseManager.add(new Exercise(0,ExerciseName,repeatNumber, seriesNumber));

                Intent myIntent = new Intent(ChestExercisesActivity.this,ExercisesActivity.class);
                startActivity(myIntent);
                popupWindow.dismiss();
            }
        });
    }



}