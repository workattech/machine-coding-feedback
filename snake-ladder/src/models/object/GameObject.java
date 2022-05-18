package models.object;

public abstract class GameObject {

    private Integer head;

    private Integer tail;

    GameObject(
            final Integer head,
            final Integer tail) {
        this.head = head;
        this.tail = tail;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public void setTail(Integer tail) {
        this.tail = tail;
    }

    public Integer getHead() {
        return head;
    }

    public Integer getTail() {
        return tail;
    }

}
