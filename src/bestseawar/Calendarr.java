package bestseawar;

import java.util.Calendar;

public class Calendarr {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2013, Calendar.DECEMBER, 13, 11, 10, 5);
        System.out.println(cal);


        long day1 = cal.getTimeInMillis();
        day1 += 1000 * 60 * 60;
        cal.setTimeInMillis(day1);
        System.out.println("Новый час " + cal.get(Calendar.HOUR_OF_DAY));
        cal.add(cal.DATE, 35);
        System.out.println("Добавить 35 дней " + cal.getTime());
        cal.roll(cal.DATE, 35);
        System.out.println("Прокрутить 35 дней (месяц не меняется) " + cal.getTime());
        cal.set(cal.DATE, 1);
        System.out.println("Установить дату в 1 " + cal.getTime());

    }
}
