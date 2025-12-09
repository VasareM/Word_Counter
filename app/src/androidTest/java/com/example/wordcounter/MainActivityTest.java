package com.example.wordcounter;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.containsString;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    private void typeTextInInput(String text) {
        onView(withId(R.id.edUserInput))
                .perform(clearText(), typeText(text), closeSoftKeyboard());
    }

    private void selectSpinnerOption(String optionText) {
        onView(withId(R.id.spOptions)).perform(click());
        onView(withText(containsString(optionText))).perform(click());
    }

    private void clickCountButton() {
        onView(withId(R.id.btnCount)).perform(click());
    }

    private void checkResult(String expected) {
        onView(withId(R.id.tvCountResult)).check(matches(withText(expected)));
    }

    @Test
    public void testCharacterCounting() {
        typeTextInInput("Hello");
        selectSpinnerOption("Characters");
        clickCountButton();
        checkResult("5");
    }

    @Test
    public void testWordCounting() {
        typeTextInInput("Hello world");
        selectSpinnerOption("Words");
        clickCountButton();
        checkResult("2");
    }

    @Test
    public void testNumberCounting() {
        typeTextInInput("A1 B22 C333");
        selectSpinnerOption("Numbers");
        clickCountButton();
        checkResult("3");
    }

    @Test
    public void testSentenceCounting() {
        typeTextInInput("Hi! How are you? I am fine.");
        selectSpinnerOption("Sentences");
        clickCountButton();
        checkResult("3");
    }

}
