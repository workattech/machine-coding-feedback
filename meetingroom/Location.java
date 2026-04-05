package meetingroom;

public class Location {
    int floorNo;

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public void setBuildingNo(int buildingNo) {
        BuildingNo = buildingNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public int getBuildingNo() {
        return BuildingNo;
    }

    public Location(int floorNo, int buildingNo) {
        this.floorNo = floorNo;
        BuildingNo = buildingNo;
    }

    int BuildingNo;
}

