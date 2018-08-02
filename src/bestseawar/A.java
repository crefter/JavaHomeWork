package bestseawar;


import java.util.Date;

public class A {
    Integer i;
    Integer j;

    public static void main(String[] args) {
        A a = new A();
        a.go();
        Date today = new Date();
        String format = String.format("Мне нужно исправить %,.2f ошибки из %,d ошибок"
                                      ,476578.09756, 999999);
        String data = String.format("%tr", new Date());
        System.out.println(format);
        System.out.println(data);
        String todayFormat = String.format("%tA, %td %tB", today, today, today);
        System.out.println(todayFormat);
        String todayFormatBest = String.format("%tA, %<td %<tB", today);
        System.out.println(todayFormatBest);
    }

    public void go(){
        j=i;
        System.out.println(j);
        System.out.println(i);
    }
}
