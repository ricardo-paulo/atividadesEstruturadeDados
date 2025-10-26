package ricardo_paulo.net;

public class Main {
    public static void main (String[] args) {
        LinkedList firstList = new LinkedList(new Node(2));
        firstList.addNode(4);
        firstList.addNode(5);
        firstList.addNode(6);
        firstList.addNode(7);

        System.out.printf("Número de pares: %d\n", countPairs(firstList));

        System.out.printf("Maior número ímpar: %d\n", largestOddNumber(firstList));

        System.out.println("Primeira lista: " + firstList);
        System.out.println("Primeira lista reversa: " + reverseNodesOrder(firstList));

        orderedInsert(firstList, 3);
        orderedInsert(firstList, 1);
        orderedInsert(firstList, 8);
        System.out.println("Elemento inserido de maneira ordenada: " + firstList);

        System.out.printf("Lista clonada: %s\n", cloneLinkedList(firstList));

        LinkedList secondList = new LinkedList();
        secondList.addNode(1);
        secondList.addNode(3);
        secondList.addNode(5);
        secondList.addNode(7);
        secondList.addNode(9);
        System.out.printf("Intercessão das listas: %s\n", listsIntercession(firstList, secondList));

        LinkedList[] splitList = splitListByParity(firstList);
        System.out.println("Listas separadas por paridade:");
        for (LinkedList l : splitList) {
            System.out.println(l);
        }
    }

    // Questão 1
    public static int countPairs (LinkedList list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("A lista está vazia.");

        int pairs = 0;
        Node currentNode = list.getNodeAt(0);

        while (currentNode != null) {
            if (currentNode.element % 2 == 0)
                pairs++;
            currentNode = currentNode.next;
        }

        return pairs;
    }

    // Questão 2
    public static int largestOddNumber (LinkedList list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("A lista está vazia.");

        Node largestOdd = null;
        Node current = list.getNodeAt(0);

        while (current != null) {
            if (current.element % 2 != 0) {
                if (largestOdd == null) {
                    largestOdd = current;
                } else {
                    if (largestOdd.element < current.element)
                        largestOdd = current;
                }
            }

            current = current.next;
        }

        if (largestOdd != null) {
            return largestOdd.element;
        } else {
            return 0;
        }
    }

    // Questão 3
    public static LinkedList reverseNodesOrder (LinkedList list) {
        Node current = list.getNodeAt(0);
        LinkedList reverseList = new LinkedList();

        while (current != null) {
            reverseList.addNode(current.element, 0);
            current = current.next;
        }

        return reverseList;
    }

    // Questão 4
    public static void orderedInsert (LinkedList list, int element) {
        Node current = list.getNodeAt(0);
        int index = 0;

        while (current != null) {
            if (current.element > element && current.next != null) {
                list.addNode(element, index);
                return;
            } else if (current.next == null) {
                list.addNode(element);
                return;
            }

            index++;
            current = current.next;
        }
    }

    // Questão 5
    public static LinkedList cloneLinkedList (LinkedList list) {
        LinkedList newList = new LinkedList();

        for (int n = 0; n < list.getLength(); n++) {
            newList.addNode(list.getNodeAt(n).element);
        }

        return newList;
    }

    // Questão 6
    public static LinkedList listsIntercession (LinkedList list1, LinkedList list2) {
        LinkedList resultList = new LinkedList();
        Node current = list1.getNodeAt(0);

        while (current != null) {
            if (list2.contains(current.element))
                resultList.addNode(current.element);

            current = current.next;
        }

        return resultList;
    }

    // Questão 7
    public static LinkedList[] splitListByParity(LinkedList list) {
        LinkedList pairs = new LinkedList();
        LinkedList odd = new LinkedList();
        Node current = list.getNodeAt(0);

        while (current != null) {
            if (current.element % 2 == 0) {
                pairs.addNode(current.element);
            } else {
                odd.addNode(current.element);
            }

            current = current.next;
        }

        return new LinkedList[]{pairs, odd};
    }
}
