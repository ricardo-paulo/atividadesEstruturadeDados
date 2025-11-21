package ricardo_paulo.net.CircularList;

public class MyCircularList {
    private CNode head;

    private int lenght;

    public MyCircularList() {
        this.head = null;
        this.lenght = 0;
    }

    public MyCircularList(int firstElement) {
        addNode(firstElement);
    }

    public boolean isEmpty() {
        return lenght == 0;
    }

    public int getLength() {
        return lenght;
    }

    public CNode getNode(int index) {
        if (index >= lenght || index < 0)
            throw new IllegalArgumentException("Posição inválida!");

        CNode current = head;
        for (int n = 0; n < index; n++) {
            current = current.next;
        }

        return current;
    }

    public int getElement(int index) {
        return getNode(index).element;
    }

    public void addNode(int element) {
        CNode newNode = new CNode(element);
        if (isEmpty()) {
            this.head = newNode;
        } else {
            CNode lastNode = getNode(lenght - 1);
            lastNode.next = newNode;
        }
        newNode.next = head;
        lenght++;
    }

    public void removeNode(int index) {
        if (index >= lenght || index < 0)
            throw new IllegalArgumentException("Posição inválida!");

        if (lenght == 1) {
            head = null;
            lenght--;
        } else if (index == 0) {
            head = head.next;
            lenght--;
        } else {
            CNode previousNode = getNode(index - 1);
            previousNode.next = previousNode.next.next;
            lenght--;
        }
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        StringBuilder stringBuilder = new StringBuilder("[");
        CNode current = head;
        do {
            stringBuilder.append(current.element);
            if (current.next != head) {
                stringBuilder.append(", ");
            }
            current = current.next;
        } while (current != head);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
