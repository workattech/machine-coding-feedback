package meetingroom;

import java.util.List;

public class Calender {
    List<Interval> intervalList;

    public void setIntervalList(List<Interval> list) {
        this.intervalList = list;
    }

    public List<Interval> getIntervalList() {
        return intervalList;
    }
}

