import lombok.Getter;

public class Ticket {
    @Getter
    private String id;
    @Getter
    private Slot slot;

    public Ticket(String lotId, int floorNum, Slot slot){
        this.id = lotId + "_" + floorNum + "_" + slot.getSlotNum();
        this.slot = slot;
    }
}
