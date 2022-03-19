public class Player {
    private String mName;
    private int mPos;

    Player(String name) {
        setName(name);
        setPos(1);
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setPos(int pos) {
        mPos = pos;
    }

    public int getPos() {
        return mPos;
    }
}
