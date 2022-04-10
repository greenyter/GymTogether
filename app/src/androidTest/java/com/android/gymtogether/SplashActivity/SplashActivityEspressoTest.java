package com.android.gymtogether.SplashActivity;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import com.android.gymtogether.R;
import com.android.gymtogether.SplashScreen.SplashActivity;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;


@RunWith(AndroidJUnit4.class)
public class SplashActivityEspressoTest {

    @Rule
    public ActivityScenarioRule<SplashActivity> activityRule =
            new ActivityScenarioRule<>(SplashActivity.class);

    @Test
    public void checkIfLogoIsShown() {
        onView(withId(R.id.logoImage))
                .check(matches(isDisplayed()));
    }

}
