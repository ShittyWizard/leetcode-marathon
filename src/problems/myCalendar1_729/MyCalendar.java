package problems.myCalendar1_729;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyCalendar {
    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private List<Interval> intervals = new ArrayList<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        Interval interval = new Interval(start, end);
        if (intervals.isEmpty()) {
            intervals.add(interval);
            return true;
        } else {
            intervals.add(interval);
            intervals.sort(Comparator.comparingInt(inter -> inter.start));
            for (int i = 0; i < intervals.size() - 1; i++) {
                if (intervals.get(i).end > intervals.get(i+1).start) {
                    intervals.remove(interval);
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
