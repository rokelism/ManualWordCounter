package com.example.manualwordcounter;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
public class WordCounterUiTest {

    @Rule
    public ActivityScenarioRule<MainActivity> rule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void calculate_twoWords_displaysTwo() {

        onView(withId(R.id.editInputText))
                .perform(replaceText("Hello World"), closeSoftKeyboard());

        onView(withId(R.id.spinnerCountType)).perform(click());

        onData(is("Words")).perform(click());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withId(R.id.textResult)).check(matches(withText("2")));
    }
    @Test
    public void calculate_twoNumbers_displaysTwo() {
        onView(withId(R.id.editInputText))
                .perform(replaceText("1234 56789"), closeSoftKeyboard());
        onView(withId(R.id.spinnerCountType)).perform(click());

        onData(is("Numbers")).perform(click());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withId(R.id.textResult)).check(matches(withText("2")));
    }
    @Test
    public void calculate_threeSentences_displaysThree() {

        onView(withId(R.id.editInputText))
                .perform(replaceText("Hello! How are you? Goodbye."),
                        closeSoftKeyboard());

        onView(withId(R.id.spinnerCountType)).perform(click());

        onData(is("Sentences")).perform(click());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withId(R.id.textResult)).check(matches(withText("3")));
    }

    @Test
    public void calculate_twoPunctuationMarks_displaysTwo() {

        onView(withId(R.id.editInputText))
                .perform(replaceText("Hello, World!"), closeSoftKeyboard());

        onView(withId(R.id.spinnerCountType)).perform(click());

        onData(is("Punctuation")).perform(click());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withId(R.id.textResult)).check(matches(withText("2")));
    }
    @Test
    public void calculate_emptyText_thenValidText_displaysTwo() {

        onView(withId(R.id.editInputText))
                .perform(replaceText(""), closeSoftKeyboard());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withId(R.id.textResult))
                .check(matches(withText(R.string.result_placeholder)));

        onView(withId(R.id.editInputText))
                .perform(replaceText("Hello World"), closeSoftKeyboard());

        onView(withId(R.id.spinnerCountType)).perform(click());

        onData(is("Words")).perform(click());

        onView(withId(R.id.buttonCalculate)).perform(click());

        onView(withId(R.id.textResult)).check(matches(withText("2")));
    }
}