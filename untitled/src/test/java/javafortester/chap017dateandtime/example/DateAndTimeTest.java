package javafortester.chap017dateandtime.example;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DateAndTimeTest {

    @Test
    public void rewriteTheTimingMethodUsingNanoTime() {
        long startTime = System.nanoTime();
        for (int x = 0; x < 10; x++) {
            System.out.println("Current time: " +
                    System.nanoTime());
        }
        long endTime = System.nanoTime();
        System.out.println("Total Time: " + (endTime - startTime));
    }

    @Test
    public void useCurrentTimeMillisToCreateAUniqueName() {
        String initialUserID = "user" + System.currentTimeMillis();
        System.out.println("Before: \t" + initialUserID);

        String userID = initialUserID;

        for (int x = 0; x < 10; x++) {
            String charReplacement = "" + ((char) ('A' + x));
            String intToReplace = String.valueOf(x);
            userID = userID.replace(intToReplace, charReplacement);
        }
        System.out.println("After:   \t" + userID);
    }

    @Test
    public void writeTheToStringToConsole(){
        Calendar calendar = Calendar.getInstance();
        String dateString = calendar.getTime().toString();

        System.out.println(dateString);
        System.out.println("Type of variable is: " + dateString.getClass().getSimpleName());
        assertTrue("calendar is not String!", dateString instanceof String);
    }

    @Test
    public void useTheOtherCalendarConstants(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(2013,Calendar.DECEMBER,15,23,49,54);
        System.out.println(calendar.getTime());

        assertThat(calendar.get(Calendar.MONTH), is(Calendar.DECEMBER));
        assertThat(calendar.get(Calendar.YEAR), is(2013));
        assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(15));
        assertThat(calendar.get(Calendar.HOUR_OF_DAY), is(23));
        assertThat(calendar.get(Calendar.MINUTE), is(49));
        assertThat(calendar.get(Calendar.HOUR), is(11));
        assertThat(calendar.get(Calendar.AM_PM), is(Calendar.PM));
    }

    @Test
    public void experimentWithOtherConstants(){
        Calendar calendar = Calendar.getInstance();

        calendar.set(2013,Calendar.DECEMBER,15);
        System.out.println(calendar.getTime());

        assertThat(calendar.get(Calendar.DAY_OF_WEEK), is(Calendar.SUNDAY));
        assertThat(calendar.get(Calendar.WEEK_OF_MONTH), is(3));
        assertThat(calendar.get(Calendar.DAY_OF_WEEK), is(1));
        assertThat(calendar.get(Calendar.WEEK_OF_YEAR), is(51));
        assertThat(calendar.get(Calendar.DAY_OF_YEAR), is(349));
    }

    @Test
    public void incrementAndDecrementOtherFields(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013,Calendar.DECEMBER,23);

        SimpleDateFormat dateFormat = new SimpleDateFormat();
        dateFormat.applyPattern("MMMM/dd/yyyy");

        System.out.print("Date before increase: \t");
        System.out.println(dateFormat.format(calendar.getTime()));

        calendar.add(Calendar.DAY_OF_MONTH,-20);
        calendar.add(Calendar.MONTH,-6);
        calendar.add(Calendar.YEAR,-2);

        System.out.print("Date after increase: \t");
        System.out.println(dateFormat.format(calendar.getTime()));

        assertThat(calendar.get(Calendar.YEAR), is(2011));
        assertThat(calendar.get(Calendar.MONTH), is(Calendar.JUNE));
        assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(3));
    }

    @Test
    public void confirmAddMovesTheYear(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2013,Calendar.DECEMBER,17);

        System.out.println(calendar.getTime().toString());

        calendar.roll(Calendar.DAY_OF_MONTH,37);
        System.out.print("Date after using roll method: \t");
        System.out.println(calendar.getTime());

        assertThat(calendar.get(Calendar.YEAR), is(2013));
        assertThat(calendar.get(Calendar.MONTH), is(Calendar.DECEMBER));
        assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(23));

        calendar.add(Calendar.DAY_OF_MONTH,31);
        System.out.print("Date after using add method: \t");
        System.out.println(calendar.getTime());

        assertThat(calendar.get(Calendar.YEAR), is(2014));
        assertThat(calendar.get(Calendar.MONTH), is(Calendar.JANUARY));
        assertThat(calendar.get(Calendar.DAY_OF_MONTH), is(23));
    }
}
