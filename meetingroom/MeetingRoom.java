package meetingroom;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;

public class MeetingRoom {
    int id;

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "id=" + id +
                ", location=" + location +
                ", isBooked=" + isBooked +
                ", capacity=" + capacity +
                '}';
    }

    Location location;
    boolean isBooked;

    public void setId(int id) {
        this.id = id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public Location getLocation() {
        return location;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCalender(Calender calender) {
        this.calender = calender;
    }

    public Calender getCalender() {
        return calender;
    }

    int capacity;

    Calender calender;

    public void bookRoom(int meetingRoomId, LocalTime start, LocalTime end, LocalDate date, Map<MeetingRoom, Calender> meetingRoomCalenderMap) {
        // Retrieve or create a calendar for the meeting room
        Calender calendar = meetingRoomCalenderMap.getOrDefault(this, new Calender());

        // Check for overlapping intervals
        boolean isOverlapping = calendar.getIntervalList().stream().anyMatch(interval ->
                interval.getDate().equals(date) &&
                        (start.isBefore(interval.getEnd()) && end.isAfter(interval.getStart()))
        );

        // If there's an overlap, return an error or handle it appropriately
        if (isOverlapping) {
            System.out.println("Meeting room is already booked for the requested time interval.");
            return;
        }

        // Add the new interval if no overlap is found
        Interval newInterval = new Interval(date,start,end);
        calendar.getIntervalList().add(newInterval);

        // Update the calendar in the map if it's new
        meetingRoomCalenderMap.put(this, calendar);

        // Mark the room as booked
        this.setBooked(true);
        System.out.println("Meeting room " + meetingRoomId + " booked successfully from " + start + " to " + end + " on " + date);
    }

}
