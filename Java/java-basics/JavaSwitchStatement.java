import java.util.*;
import java.time.DayOfWeek;

public class JavaSwitchStatement {
    public static void main(String[] args) {
        int day = 2;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Invalid day");
                break;
        }
    }

    public static void switchExample(String[] args) {
        DayOfWeek today = DayOfWeek.SATURDAY;
        switch (today) {
            case MONDAY:
                System.out.println("Today is Monday, time to go back to work.");
                break;
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
                System.out.println("Today is a weekday, time to work.");
                break;
            case FRIDAY:
                System.out.println("Today is Friday, time to finish up and relax.");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Today is the weekend, time to have fun!");
                break;
            default:
                System.out.println("Invalid day of the week.");
                break;
        }
    }

}
