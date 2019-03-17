package ua.napps.scorekeeper.app.Dice;


import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import ua.com.napps.scorekeeper.R;
import ua.napps.scorekeeper.app.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isOneOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DiceTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest3() {

        // Added a sleep statement to match the app's execution delay.

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction fixedBottomNavigationTab = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.bottom_navigation_bar_item_container),
                                childAtPosition(
                                        withId(R.id.bottom_navigation_bar_container),
                                        1)),
                        1),
                        isDisplayed()));
        fixedBottomNavigationTab.perform(click());

        // Added a sleep statement to match the app's execution delay.

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction fixedBottomNavigationTab2 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.bottom_navigation_bar_item_container),
                                childAtPosition(
                                        withId(R.id.bottom_navigation_bar_container),
                                        1)),
                        2),
                        isDisplayed()));
        fixedBottomNavigationTab2.perform(click());

        // Added a sleep statement to match the app's execution delay.

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction fixedBottomNavigationTab3 = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.bottom_navigation_bar_item_container),
                                childAtPosition(
                                        withId(R.id.bottom_navigation_bar_container),
                                        1)),
                        1),
                        isDisplayed()));
        fixedBottomNavigationTab3.perform(click());

        // Added a sleep statement to match the app's execution delay.

        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction constraintLayout = onView(
                allOf(withId(R.id.container),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withClassName(is("android.widget.LinearLayout")),
                                                0)),
                                0),
                        isDisplayed()));
        constraintLayout.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.dice),
                        childAtPosition(
                                allOf(withId(R.id.container),
                                        childAtPosition(
                                                withId(R.id.container),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText(isOneOf("1", "2", "3", "4", "5", "6"))));
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
