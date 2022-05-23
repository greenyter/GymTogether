package com.android.gymtogether.model;


import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Training implements Serializable {

    private List<Exercise> exercises = new ArrayList<>();
    private String date;
    private String emailUser;

    public void addExercise(Exercise exercise){
        exercises.add(exercise);
    }



}
