package ricardo_paulo.net.DoubleLinkedCircularList;

public class MyDoubleLinkedCircularList {

    DLCNode head;
    DLCNode tail;
    int length;

    public MyDoubleLinkedCircularList() {
        head = null;
        tail = null;
        length = 0;
    }

    public MyDoubleLinkedCircularList(String element) {
        this.head = new DLCNode(element);
        this.tail = head;
        head.next = head;
        head.previous = head;
        this.length = 1;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public DLCNode getNode(int index) {
        if (!(index >= 0 && index < length))
            throw new IllegalArgumentException("Index inválido!");

        DLCNode current = head;

        for (int i = 0; i <= length; i++) {
            if (i == index)
                return current;

            current = current.next;
        }

        return current;
    }

    public void addNode(String element) {
        DLCNode newNode = new DLCNode(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            head.previous = newNode;
            tail.next = newNode;
            tail = newNode;
        }

        newNode.next = head;
        newNode.previous = tail;

        length++;
    }

    public void addNode(String element, int index) {
        if (index < 0 || index > length)
            throw new IllegalArgumentException("Posição inválida");

        DLCNode newNode = new DLCNode(element);
        
        if (isEmpty()) {
            addNode(element);
        } else if (index == 0) {
            newNode.next = head;
            newNode.previous = tail;
            head.previous = newNode;
            tail.next = newNode;
            head = newNode;
        } else {
            DLCNode current = getNode(index);
            newNode.next = current;
            newNode.previous = current.previous;
            current.previous.next = newNode;
            current.previous = newNode;
        }

        length++;
    }

    public void removeNode(String element) {
        DLCNode current = head.next;
        do {
            if (current.element.equals(element)) {
                if (current == head) {
                    tail.next = head.next;
                    head.next.previous = tail;
                    head = head.next;
                } else if (current == tail) {
                    tail.previous.next = head;
                    head.previous = tail.previous;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                length--;
            }
            current = current.next;
        } while (current != head);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        DLCNode current = head;
        while (current.next != head) {
            s.append(current.element);
            if (current.next != head) {
                s.append(", ");
            }
            current = current.next;
        }
        s.append("]");
        return s.toString();
    }
}
