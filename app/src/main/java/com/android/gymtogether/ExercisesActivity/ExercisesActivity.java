package com.android.gymtogether.ExercisesActivity;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.android.gymtogether.ExercisesActivity.model.Exercise;
import com.android.gymtogether.R;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class ExercisesActivity extends AppCompatActivity implements Observer {

    ExerciseManager exerciseManager = ExerciseManager.getInstance();
    ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        listView = (ListView) findViewById(R.id.ExerciseList);
        exerciseManager.addObserver(this);


    }

    public void launchAddExercise(View v) {
        Intent i = new Intent(this, AddExerciseActivity.class);
        startActivity(i);
    }

    @Override
    public void update(Observable o, Object arg) {

        adapter = new ArrayAdapter<String>(this, R.layout.row, (String[]) exerciseManager.list().stream().map(Object::toString).toArray());

        listView.setAdapter(adapter);
    }
}