package com.android.gymtogether.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Exercise implements Serializable {


    private String exerciseName;
    private String exerciseCategory;
    private int repeatNumber;
    private int seriesNumber;
    private int weight;

    @Override
    public String toString(){
        return " Exercise name - " + exerciseName +
                " | Exercise category - " + exerciseCategory +
                " | Repeat number - " + repeatNumber +
                " | Series number - " + seriesNumber +
                " | Weight - " + weight;
    }
    
    
    public enum ExerciseEnum{
        CHEST("Chest"),
        SHOULDERS("Shoulders"),
        STOMACH("Stomach"),
        LEGS("Legs");

        private final String value;

        ExerciseEnum(String value) {
            this.value = value;
        }

        public static ExerciseEnum valueOfEnum(String value) {
            for (ExerciseEnum e : values()) {
                if (e.value.equals(value)) {
                    return e;
                }
            }
            return null;
        }
    }
}
