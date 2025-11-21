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

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    public DLCNode getNode(int index) {
        if (index < 0 || index >= length)
            throw new IllegalArgumentException("Index inválido");

        DLCNode current = head;
        for (int i = 0; i < index; i++)
            current = current.next;

        return current;
    }

    public void addNode(String element) {
        DLCNode newNode = new DLCNode(element);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            newNode.next = newNode;
            newNode.previous = newNode;
        } else {
            newNode.previous = tail;
            newNode.next = head;
            tail.next = newNode;
            head.previous = newNode;
            tail = newNode;
        }

        length++;
    }

    public void addNode(String element, int index) {
        if (index < 0 || index > length)
            throw new IllegalArgumentException("Posição inválida");

        if (index == length) {
            addNode(element);
            return;
        }

        DLCNode newNode = new DLCNode(element);

        if (index == 0) {
            if (isEmpty()) {
                head = newNode;
                tail = newNode;
                newNode.next = newNode;
                newNode.previous = newNode;
            } else {
                newNode.next = head;
                newNode.previous = tail;
                tail.next = newNode;
                head.previous = newNode;
                head = newNode;
            }
            length++;
            return;
        }

        DLCNode current = getNode(index);

        newNode.next = current;
        newNode.previous = current.previous;
        current.previous.next = newNode;
        current.previous = newNode;

        length++;
    }

    public String removeNode(String element) {
        if (isEmpty())
            return null;

        if (head == tail && head.element.equals(element)) {
            head = null;
            tail = null;
            length = 0;
            return element;
        }

        if (head.element.equals(element)) {
            head = head.next;
            head.previous = tail;
            tail.next = head;
            length--;
            return element;
        }

        if (tail.element.equals(element)) {
            tail = tail.previous;
            tail.next = head;
            head.previous = tail;
            length--;
            return element;
        }

        DLCNode current = head.next;

        while (current != tail) {
            if (current.element.equals(element)) {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                length--;
                return element;
            }
            current = current.next;
        }

        return null;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder s = new StringBuilder("[");
        DLCNode current = head;

        for (int i = 0; i < length; i++) {
            s.append(current.element);
            if (i < length - 1)
                s.append(", ");
            current = current.next;
        }

        s.append("]");
        return s.toString();
    }
}
