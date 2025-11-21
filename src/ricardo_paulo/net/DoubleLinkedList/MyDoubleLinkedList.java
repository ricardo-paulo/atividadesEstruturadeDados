package ricardo_paulo.net.DoubleLinkedList;

public class MyDoubleLinkedList {

    private DLNode head;
    private DLNode tail;
    private int length;

    public MyDoubleLinkedList() {
        this.head = null;
        this.length = 0;
    }

    public MyDoubleLinkedList(int firstElement) {
        this.head = new DLNode(firstElement);
        this.tail = head;
        this.length = 1;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int getLength() {
        return length;
    }

    private DLNode getNode(int index) {
        if (index < 0 || index > length)
            throw new IllegalArgumentException("Posição inválida");

        DLNode current;
        if (index < length / 2) {
            current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) {
                current = current.previous;
            }
        }
        return current;
    }

    public int getElement(int index) {
        return getNode(index).element;
    }

    public boolean contains(int element) {
        DLNode current = head;
        while (current != null) {
            if (current.element == element) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(int element) {
        DLNode current = head;
        int indice = 0;
        while (current != null) {
            if (current.element == element) {
                return indice;
            }
            current = current.next;
            indice++;
        }
        return -1;
    }

    public void addNode(int element) {
        DLNode newNode = new DLNode(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        length++;
    }

    public void addNode(int element, int index) {
        if (index < 0 || index > length)
            throw new IllegalArgumentException("Posição inválida");

        DLNode newNode = new DLNode(element);
        if (index == 0) {
            newNode.next = head;
            if (head != null)
                head.previous = newNode;
            head = newNode;
            if (tail == null)
                tail = newNode;
        } else if (index == length) {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        } else {
            DLNode current = getNode(index);
            newNode.previous = current.previous;
            newNode.next = current;
            current.previous.next = newNode;
            current.previous = newNode;
        }
        length++;
    }

    public boolean removeNode(int element) {
        DLNode current = head;
        while (current != null) {
            if (current.element == element) {
                if (current == head) {
                    head = current.next;
                    if (head != null) {
                        head.previous = null;
                    } else {
                        tail = null;
                    }
                } else if (current == tail) {
                    tail = current.previous;
                    tail.next = null;
                } else {
                    current.previous.next = current.next;
                    current.next.previous = current.previous;
                }
                length--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int removeNodeAt(int index) {
        if (!(index >= 0 && index < length)) {
            throw new IllegalArgumentException("Posição inválida");
        }

        DLNode removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
            if (head != null) {
                head.previous = null;
            } else {
                tail = null;
            }
        } else if (index == length - 1) {
            removedNode = tail;
            tail = tail.previous;
            tail.next = null;
        } else {
            removedNode = getNode(index);
            removedNode.previous.next = removedNode.next;
            removedNode.next.previous = removedNode.previous;
        }
        length--;
        return removedNode.element;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("[");
        DLNode current = head;
        while (current != null) {
            s.append(current.element);
            if (current.next != null) {
                s.append(", ");
            }
            current = current.next;
        }
        s.append("]");
        return s.toString();
    }

    // Questão 1
    public String invertToString() {
        StringBuilder s = new StringBuilder("[");
        DLNode current = tail;
        while (current != null) {
            s.append(current.element);
            if (current.previous != null) {
                s.append(", ");
            }
            current = current.previous;
        }
        s.append("]");
        return s.toString();
    }
}
