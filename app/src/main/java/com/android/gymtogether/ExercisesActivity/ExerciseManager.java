package com.android.gymtogether.ExercisesActivity;

import com.android.gymtogether.model.Exercise;

import java.util.ArrayList;
import java.util.Observable;

public class ExerciseManager extends Observable {

    ArrayList<Exercise> exercises = new ArrayList<Exercise>();

    private ExerciseManager(){

    }


    public void add(Exercise exercise) {
        exercises.add(exercise);
        setChanged();
        notifyObservers();
    }


    public ArrayList<Exercise> list() {
        return exercises;
    }


    public Exercise get(int id) {
        return exercises.get(id);
    }


    private static final ExerciseManager instance = new ExerciseManager();

    public static ExerciseManager getInstance(){
        return instance;
    }

}
