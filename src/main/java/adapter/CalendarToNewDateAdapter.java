package adapter;

import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {
    private Calendar calendar;

    public  CalendarToNewDateAdapter() {
        calendar = Calendar.getInstance();
    }

    public void setDay(int day) {
        calendar.set(Calendar.DAY_OF_MONTH, day);
    }


    // Calendar thinks January is 0, February is 1...
    // But normally months are 1-12 -> subtract 1 when setting the month
    // For example set February but don’t subtract 1, Calendar would treat it as March.
    public void setMonth(int month) {
        calendar.set(Calendar.MONTH, month - 1);
    }

    public void setYear(int year) {
        calendar.set(Calendar.YEAR, year);
    }

   public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
   }

    // To convert month to normal months (1–12) -> add 1 after getting value
    // For Example Calendar.MONTH returns 1 (February) -> add 1: 1 + 1 = 2 → correct month is displayed
   public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
   }

   public int getYear() {
        return calendar.get(Calendar.YEAR);
   }

   public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
   }




}
