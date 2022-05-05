package com.android.gymtogether.ExercicesActivity;

import android.app.Dialog;
import android.content.Intent;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.android.gymtogether.R;

public class ChestExercicesActivity extends AppCompatActivity {

    public EditText editTextRepeatNumber, editTextSeriesNumber2;
    public Button AddExerciceButton2;
    public TextView exerciceNameView;
    private ListView list;
    private String[] exercices;

    private String exerciceName; //nazwa ćwiczenia
    private int repeatNumber, seriesNumber; //liczba powtorzen/serii


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chest_exercices);
    }


    public void ShowPopUp(View v){

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View viewPopupwindow = layoutInflater.inflate(R.layout.activity_pop_up_add_exercice, null);

        int width = ConstraintLayout.LayoutParams.WRAP_CONTENT;
        int height = ConstraintLayout.LayoutParams.WRAP_CONTENT;

        PopupWindow popupWindow = new PopupWindow(viewPopupwindow, width, height, true);
        popupWindow.showAtLocation(v, Gravity.CENTER,0,0);

        editTextRepeatNumber = (EditText) viewPopupwindow.findViewById(R.id.editTextRepeatNumber);
        editTextSeriesNumber2 = (EditText) viewPopupwindow.findViewById(R.id.editTextSeriesNumber2);

        Button b = (Button)v;
        exerciceName = b.getText().toString();
        exerciceNameView = (TextView) viewPopupwindow.findViewById(R.id.ExerciseNameView);
        exerciceNameView.setText(exerciceName);

        AddExerciceButton2 = (Button) viewPopupwindow.findViewById(R.id.AddExerciceButton2);

        list = (ListView) viewPopupwindow.findViewById(R.id.exerciceList);

        AddExerciceButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seriesNumber = Integer.parseInt(editTextRepeatNumber.getText().toString());
                repeatNumber = Integer.parseInt(editTextSeriesNumber2.getText().toString());
                Intent myIntent = new Intent(ChestExercicesActivity.this,ExercicesActivity.class);
                startActivity(myIntent);
                popupWindow.dismiss();
            }
        });
    }



}