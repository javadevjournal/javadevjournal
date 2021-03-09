package linkedList.singly.test;

import linkedList.singly.MySinglyLinkedList;
import org.junit.Test;

public class MySinglyLinkedListTest {
    @Test
    public void testLinkedList(){
        MySinglyLinkedList list = new MySinglyLinkedList();
        //insertion
        MySinglyLinkedList.insert(list, 1);
        MySinglyLinkedList.insert(list, 2);
        MySinglyLinkedList.insert(list, 3);
        MySinglyLinkedList.insert(list, 4);
        MySinglyLinkedList.insert(list, 5);
        MySinglyLinkedList.insert(list, 6);
        MySinglyLinkedList.insert(list, 7);
        MySinglyLinkedList.insert(list, 8);
        MySinglyLinkedList.insert(list, 9);
        MySinglyLinkedList.insert(list, 10);
        MySinglyLinkedList.insert(list, 11);
        MySinglyLinkedList.insert(list, 12);
        MySinglyLinkedList.insert(list, 13);
        MySinglyLinkedList.insert(list, 14);
        MySinglyLinkedList.insert(list, 15);
        MySinglyLinkedList.insert(list, 16);

        //size of the list
        System.out.println("size of the list at the beginning: " + list.size(list));

        //delete by key
        list.traverseAndPrintList(list);
        list.deleteByKey(list, 1);

        list.traverseAndPrintList(list);
        list.deleteByKey(list, 4);

        list.traverseAndPrintList(list);
        list.deleteByKey(list, 10);

        list.traverseAndPrintList(list);
        list.deleteByKey(list, 17);

        list.traverseAndPrintList(list);

        //delete by position
        list.deleteAtPosition(list, 0);
        list.traverseAndPrintList(list);

        list.deleteAtPosition(list, 2);
        list.traverseAndPrintList(list);

        list.deleteAtPosition(list, 10);
        list.traverseAndPrintList(list);

        list.deleteAtPosition(list, 18);
        list.traverseAndPrintList(list);

        //search
        System.out.println("searching for element with data 13");
        if (list.search(list.head, 13))
            System.out.println("Yes, given data is present in the list");
        else
            System.out.println("No, given data is not present in the list");
        list.traverseAndPrintList(list);

        //size of the list
        System.out.println("size of the list at the end: " + list.size(list));

        System.out.println("Add element 99 at 3rd position");
        list.insertAfter(list.head.next,99 );
        list.traverseAndPrintList(list);
    }

}
