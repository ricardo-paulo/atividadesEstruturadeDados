package ricardo_paulo.net.DoubleLinkedList;

// Classe project-protected
class DLNode {

    public int element;
    public DLNode next;
    public DLNode previous;

    public DLNode(int element) {
        this.element = element;
        this.next = null;
        this.previous = null;
    }
}
