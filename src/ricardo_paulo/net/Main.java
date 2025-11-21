package ricardo_paulo.net;

import ricardo_paulo.net.CircularList.MyCircularList;
import ricardo_paulo.net.DoubleLinkedCircularList.MyDoubleLinkedCircularList;
import ricardo_paulo.net.DoubleLinkedList.MyDoubleLinkedList;

public class Main {
    public static void main (String[] args) {

        MyDoubleLinkedList doubleLinkedList = new MyDoubleLinkedList(10);
        doubleLinkedList.addNode(16);
        doubleLinkedList.addNode(1);
        doubleLinkedList.addNode(4);
        doubleLinkedList.addNode(2);
        doubleLinkedList.addNode(15);
        System.out.println(doubleLinkedList.invertToString());

        removeOddIndexes(doubleLinkedList);
        System.out.println(doubleLinkedList);

        doubleLinkedList.addNode(40);
        doubleLinkedList.addNode(20);
        doubleLinkedList.addNode(14);
        System.out.println("Atual: " + doubleLinkedList);
        removePairIndexes(doubleLinkedList);
        System.out.println(doubleLinkedList);

        doubleLinkedList.addNode(40);
        doubleLinkedList.addNode(14);
        doubleLinkedList.addNode(14);
        int element = 14;
        System.out.printf("Repetições do elemento %d: %d\n",
                element, getRepetitions(doubleLinkedList, element));

        System.out.println("Lista original: " + doubleLinkedList);
        System.out.println("Lista invertida: " + revertList(doubleLinkedList));

        MyCircularList circularList = new MyCircularList(11);
        circularList.addNode(15);
        circularList.addNode(20);
        circularList.addNode(17);
        circularList.addNode(5);
        System.out.println("Lista Circular: " + circularList);
        MyCircularList[] circularLists = splitListsInHalf(circularList);
        System.out.println("Primeira metade: " + circularLists[0]);
        System.out.println("Segunda metade: " + circularLists[1]);

        MyCircularList list1 = new MyCircularList(5);
        list1.addNode(8);
        list1.addNode(9);
        list1.addNode(12);
        list1.addNode(15);

        MyCircularList list2 = new MyCircularList(6);
        list2.addNode(7);
        list2.addNode(10);
        list2.addNode(11);
        list2.addNode(13);
        list2.addNode(14);

        System.out.println("Listas fundidas: " + mergeLists(list1, list2));

        //Questão 8
        MyDoubleLinkedCircularList dlcList = new MyDoubleLinkedCircularList();
        dlcList.addNode("Paulo");
        dlcList.addNode("Sérgio");
        dlcList.addNode("Bruna");
        dlcList.addNode("Luana");
        System.out.println(dlcList);

        System.out.println(dlcList.getNode(2).element);

        System.out.println(dlcList.removeNode("Bruna"));
        System.out.println(dlcList);
    }

    // Questão 2
    private static void removeOddIndexes(MyDoubleLinkedList list) {
        int initIndex;

        if (list.getLength() % 2 == 0) {
            initIndex = list.getLength() - 1;
        } else {
            initIndex = list.getLength() - 2;
        }

        for (int i = initIndex; i > 0; i -= 2) {
            System.out.print("Elemento: " + list.removeNodeAt(i));
            System.out.println(" - Index: " + i);
        }
    }

    // Questão 3
    private static void removePairIndexes(MyDoubleLinkedList list) {
        int initIndex;

        if (list.getLength() % 2 == 0) {
            initIndex = list.getLength() - 2;
        } else {
            initIndex = list.getLength() - 1;
        }

        for (int i = initIndex; i >= 0; i -= 2) {
            System.out.print("Elemento: " + list.removeNodeAt(i));
            System.out.println(" - Index: " + i);
        }
    }

    // Questão 4
    private static int getRepetitions(MyDoubleLinkedList list, int element) {
        int counter = 0;

        for (int n = 0; n < list.getLength(); n++) {
            if (list.getElement(n) == element)
                counter++;
        }

        return counter;
    }

    // Questão 5
    private static MyDoubleLinkedList revertList(MyDoubleLinkedList list) {
        MyDoubleLinkedList revertedList = new MyDoubleLinkedList();

        for (int n = list.getLength() - 1; n >= 0; n--) {
            revertedList.addNode(list.getElement(n));
        }

        return revertedList;
    }

    // Questão 6
    private static MyCircularList[] splitListsInHalf(MyCircularList list) {
        int middleIndex = list.getLength() / 2;
        MyCircularList firstList = new MyCircularList();
        MyCircularList secondList = new MyCircularList();

        for (int n = 0; n <= middleIndex; n++) {
            firstList.addNode(list.getNode(n).element);
        }

        for (int n = middleIndex + 1; n < list.getLength(); n++) {
            secondList.addNode(list.getNode(n).element);
        }

        return new MyCircularList[]{firstList, secondList};
    }

    // Questão 7
    private static MyCircularList mergeLists(MyCircularList list1, MyCircularList list2) {
        MyCircularList mergedList = new MyCircularList();
        int totalComparisons = list1.getLength() + list2.getLength() - 1;

        for (int i = 0; i < totalComparisons; i++) {
            int element1 = list1.getElement(0);
            int element2 = list2.getElement(0);

            if (element1 < element2) {
                mergedList.addNode(element1);
                list1.removeNode(0);
            } else {
                mergedList.addNode(element2);
                list2.removeNode(0);
            }
        }

        if (!list1.isEmpty()) {
            mergedList.addNode(list1.getElement(0));
        } else if (!list2.isEmpty()) {
            mergedList.addNode(list2.getElement(0));
        }

        return mergedList;
    }
}
