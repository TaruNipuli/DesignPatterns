package adapter;

public class Main {
    public static void main(String[] args) {
        NewDateInterface date = new CalendarToNewDateAdapter();

        // Set date
        date.setYear(2025);
        date.setMonth(2);
        date.setDay(28);

        System.out.println("Original date: " + date.getDay()+"."+date.getMonth()+"."+date.getYear());

        // Advance date
        date.advanceDays(3);

        System.out.println("Date after advancing: " +  date.getDay()+"."+date.getMonth()+"."+date.getYear());
    }
}
