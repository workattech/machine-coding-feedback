package bookmyshow;


public class Seat {
    private Integer seatId;
    private String seatNumber;
    private SeatType seatType;
    private SeatStatus seatStatus;
    private boolean isLocked = false;

    public synchronized boolean lockSeat() {
        if (seatStatus == SeatStatus.AVAILABLE && !isLocked) {
            isLocked = true;
            return true;
        }
        return false;
    }

    public synchronized void unlockSeat() {
        isLocked = false;
    }

    public synchronized boolean bookSeat() {
        if (isLocked) {
            seatStatus = SeatStatus.BOOKED;
            isLocked = false;
            return true;
        }
        return false;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
