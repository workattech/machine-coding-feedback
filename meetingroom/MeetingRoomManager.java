package meetingroom;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MeetingRoomManager {
    public MeetingRoomManager() {
        this.meetingRoomList = new ArrayList<>();
        this.meetingRoomCalenderMap = new HashMap<>();
    }

    List<MeetingRoom> meetingRoomList ;
    Map<MeetingRoom,Calender> meetingRoomCalenderMap;

      List<MeetingRoom> getAvailableMeetingRooms(int capacity, LocalTime startTime, LocalTime endTime, LocalDate date){
          return meetingRoomList.stream()
                  .filter(room -> !room.isBooked
                          && room.getCapacity() >= capacity
                          && room.getCalender().getIntervalList().stream()
                          .anyMatch(interval -> interval.getDate().equals(date)
                                  && (interval.getStart().isBefore(endTime) && interval.getEnd().isAfter(startTime))
                          )
                  ).toList();

      }

    void addMeetingRoom(int id, Location location, int capacity) {
        MeetingRoom meetingRoom = new MeetingRoom();
        meetingRoom.setId(id);
        meetingRoom.setLocation(location);
        meetingRoom.setCapacity(capacity);
        meetingRoom.setBooked(false);

        // Create and add initial intervals to simulate existing bookings
        Calender calendar = new Calender();
        List<Interval> initialIntervals = new ArrayList<>();

        // Example: Booked on 2024-10-11 from 9:00 to 10:30
        Interval interval1 = new Interval(LocalDate.of(2024, 10, 11),LocalTime.of(9, 0),LocalTime.of(10, 30));

        initialIntervals.add(interval1);

        // Example: Booked on 2024-10-12 from 14:00 to 15:30
        Interval interval2 = new Interval(LocalDate.of(2024, 10, 12),
      LocalTime.of(14, 0),
       LocalTime.of(15, 30));

        initialIntervals.add(interval2);

        calendar.setIntervalList(initialIntervals); // Set intervals to the calendar
        meetingRoomCalenderMap.put(meetingRoom, calendar); // Add to calendar map
       meetingRoom.setCalender(calendar);
        meetingRoomList.add(meetingRoom);
    }
       String bookMeetingRoom(int meetingRoomId, LocalTime start, LocalTime end, LocalDate date){

           List<Integer> list = meetingRoomList.stream().map(e -> e.getId()).toList();
           if(list.contains(meetingRoomId)) {
               MeetingRoom meetingRoom = meetingRoomList.stream().filter(e->e.getId()==meetingRoomId).findFirst().get();
               meetingRoom.bookRoom(meetingRoomId, start, end, date, meetingRoomCalenderMap);
               return meetingRoomId + "booked sucessfully ";
           }

          return "invalid meetingRoomId";
       }
}

