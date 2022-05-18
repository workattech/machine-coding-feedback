import models.object.GameObject;
import models.object.Ladder;
import models.object.ObjectType;
import models.object.Snake;

public class SnakeLadderService {

    public static GameObject addObject(ObjectType objectType, Integer head, Integer tail) {
        switch (objectType) {
            case SNAKE:
                return new Snake(head, tail);
            case LADDER:
                return new Ladder(head, tail);
            default:
                return null;
        }
    }

}
