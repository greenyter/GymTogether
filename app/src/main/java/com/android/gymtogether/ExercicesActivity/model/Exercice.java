package com.android.gymtogether.ExercicesActivity.model;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
public class Exercice implements Serializable {

    private int id;
    private String exerciceName;
    private int repeatNumber;
    private int seriesNumber;
    String exerciceDate;


}
