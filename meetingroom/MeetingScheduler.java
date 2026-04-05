package meetingroom;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class MeetingScheduler {

    static MeetingRoomManager meetingRoomManager;

    public static void main(String[] args) {
        meetingRoomManager = new MeetingRoomManager();
        meetingRoomManager.addMeetingRoom(1,new Location(1,11),10);
        List<MeetingRoom> availableMeetingRooms = meetingRoomManager.getAvailableMeetingRooms(5,LocalTime.of(9, 0),LocalTime.of(10, 30),LocalDate.of(2024, 10, 11));
        System.out.println("available meeting rooms::"+availableMeetingRooms);
        if(!availableMeetingRooms.isEmpty()) {
            String s = meetingRoomManager.bookMeetingRoom(1, LocalTime.of(11, 0), LocalTime.of(12, 15), LocalDate.of(2024, 11, 19));
            System.out.println(s);
        }
        else {
            System.out.println("meeting room is not available at that schedule");
        }
       // sendNotification();
    }
}

