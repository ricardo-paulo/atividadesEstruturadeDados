package ricardo_paulo.net.DoubleLinkedCircularList;

public class DLCNode {
    public String element;
    public DLCNode next;
    public DLCNode previous;

    public DLCNode(String element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }
}
