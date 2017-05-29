package com.example.a2_password_validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    private String textToFindOnFail;
    private String textToFindOnSuccess;
    private String textInstructions;
    private String enteredPass;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void attemptTests() {
        String failPhrase = "Not strong enough, try again";
        String strongPhrase = "Strong enough!";

        //First password attempt
        onView(withId(R.id.enterPass)).perform(typeText("notgoingtowork"));
        onView(withId(R.id.valButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText(failPhrase)));
        onView(withId(R.id.enterPass)).perform(clearText());

        //Second password attempt
        onView(withId(R.id.enterPass)).perform(typeText("Yay!GoodJob4U"));
        onView(withId(R.id.valButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText(strongPhrase)));
        onView(withId(R.id.enterPass)).perform(clearText());

        //Third password attempt
        onView(withId(R.id.enterPass)).perform(typeText("NotgG-01gt0work2"));
        onView(withId(R.id.valButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText(failPhrase)));
        onView(withId(R.id.enterPass)).perform(clearText());

        //Fourth password attempt
        onView(withId(R.id.enterPass)).perform(typeText("DoneThisLabY0!"));
        onView(withId(R.id.valButton)).perform(click());
        onView(withId(R.id.resultText)).check(matches(withText(strongPhrase)));

    }


}

