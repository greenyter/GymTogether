package com.android.gymtogether.tool;

import com.android.gymtogether.model.Exercise;
import com.android.gymtogether.model.Training;
import junit.framework.TestCase;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class JSONMapperTest {

    @Test
    public void testConvertToJSON_ExpectSuccess() {
        //given
        JSONMapper<Training> exerciseJSONMapper = new JSONMapper<>();
        Exercise exercise = new Exercise("aaa", Exercise.ExerciseEnum.LEGS.name(), 5, 5, 20);

        Training training = new Training();
        training.addExercise(exercise);
        training.setDate(LocalDate.of(2000, 2, 20).toString());
        //when
        String result = exerciseJSONMapper.convertToJSON(training);

        //then
        assertThat("No day of month", result.contains("20"));
        assertThat("No month", result.contains("2"));
        assertThat("No year", result.contains("2000"));

        assertThat(training.getExercises().size(), equalTo(1));
        Exercise exResult = training.getExercises().get(0);
        assertThat("No exercise category", result.contains(Exercise.ExerciseEnum.LEGS.name()));
        assertThat("No exercise name", result.contains("aaa"));
        assertThat("No repeat number", result.contains("5"));
        assertThat("No series number", result.contains("5"));
        assertThat("No weight", result.contains("20"));

    }

    @Test
    public void testConvertFromJSON_ExpectSuccess() {
        //given
        JSONMapper<Training> toJson = new JSONMapper<>();
        Exercise exercise = new Exercise("aaa", Exercise.ExerciseEnum.LEGS.name(), 5, 5, 20);

        Training training = new Training();
        training.addExercise(exercise);
        training.setDate(LocalDate.of(2000, 2, 20).toString());
        String stringJson = toJson.convertToJSON(training);

        //when
        JSONMapper<Training> trainingJSONMapper = new JSONMapper<>();
        Training result = trainingJSONMapper.convertFromJSON(stringJson,Training.class);

        //then
        assertThat("No day", result.getDate().contains("20"));
        assertThat("No month", result.getDate().contains("2"));
        assertThat("No year", result.getDate().contains("2000"));

        assertThat(training.getExercises().size(), equalTo(1));
        Exercise exResult = training.getExercises().get(0);

        assertThat(exResult.getExerciseCategory(), equalTo(Exercise.ExerciseEnum.LEGS.name()));
        assertThat(exResult.getExerciseName(), equalTo("aaa"));
        assertThat(exResult.getSeriesNumber(), equalTo(5));
        assertThat(exResult.getRepeatNumber(), equalTo(5));
        assertThat(exResult.getWeight(), equalTo(20));
    }
}