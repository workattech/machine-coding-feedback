import java.util.HashMap;
import java.util.Map;

public enum DisplayType {
    FREE_COUNT("free_count"),
    FREE_SLOTS("free_slots"),
    OCCUPIED_SLOTS("occupied_slots");

    private String label;
    private static final Map<String, DisplayType> labels = new HashMap<>();
    static {
        for(DisplayType displayType : values()){
            labels.put(displayType.label, displayType);
        }
    }

    private DisplayType(String label){
        this.label = label;
    }

    public static DisplayType valueOfLabel(String label){
        return labels.get(label);
    }
}
