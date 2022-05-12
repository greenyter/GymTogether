package com.android.gymtogether.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class Exercise implements Serializable {


    private int id;
    private String ExerciseName;
    private int repeatNumber;
    private int seriesNumber;
    //String ExerciseDate;
    //private List<Exercise> ExerciseList;

    //int id, , String ExerciseDate
    public Exercise(int id, String ExerciseName, int repeatNumber, int seriesNumber){
        this.id = id;
        this.ExerciseName = ExerciseName;
        this.repeatNumber = repeatNumber;
        this.seriesNumber = seriesNumber;
    }

    void introduce(){
        System.out.println("Id - " + id + " Exercise name - " + ExerciseName + " | Repeat number - " + repeatNumber + " | Series number - " + seriesNumber);
    }
}
