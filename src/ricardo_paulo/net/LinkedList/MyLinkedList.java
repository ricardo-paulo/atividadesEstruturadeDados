package ricardo_paulo.net.LinkedList;

public class MyLinkedList {

    private Node head;
    private int length;

    public MyLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public MyLinkedList(Node firstNode) {
        this.head = firstNode;
        this.length = 1;
    }

    public int getLength () {
        return length;
    }

    public Node getNodeAt (int pos) {
        if (pos < 0 || pos > length)
            throw new IllegalArgumentException("Posição inválida.");

        Node current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }

        return current;
    }

    public int getNodeIndex (char element) {
        Node current = head;

        for (int j = 0; j < length; j++) {
            if (current != null && current.element == element)
                return j;
        }

        return -1;
    }

    public boolean isEmpty () {
        return length == 0;
    }

    public void addNode (char newElement) {
        Node newNode = new Node(newElement);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node lastNode = getNodeAt(length - 1 );
            lastNode.next = newNode;
        }

        length++;
    }

    public void addNode (char newElement, int pos) {
        if (pos < 0 || pos > length)
            throw new IllegalArgumentException("Posição inválida.");

        Node newNode = new Node(newElement);

        if (pos == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node previousNode = getNodeAt(pos - 1);
            newNode.next = previousNode.next;
            previousNode.next = newNode;
        }

        length++;
    }

    public char removeNodeAt (int pos) {
        if (pos < 0 || pos > length)
            throw new IllegalArgumentException("Posição inválida.");

        Node current;
        if (pos == 0) {
            current = head;
            head = head.next;
        } else {
            current = getNodeAt(pos - 1);
            current.next = current.next.next;
        }

        length--;
        return current.element;
    }

    public boolean contains (char element) {
        Node current = head;

        while (current != null) {
            if (current.element == element)
                return true;

            current = current.next;
        }

        return false;
    }

    @Override
    public String toString () {
        StringBuilder s = new StringBuilder("[");
        Node current = head;

        while (current != null) {
            s.append(current.element);
            if (current.next != null) {
                s.append(",");
            }
            current = current.next;
        }

        s.append("]");
        return s.toString();
    }
}