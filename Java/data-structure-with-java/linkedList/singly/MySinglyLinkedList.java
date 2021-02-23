package linkedList.singly;

public class MySinglyLinkedList {

    /**
     * Head of the LinkedList
     */
    public Node head;

    /**
     *  This is a method static class defining a LinkedList Node.
     *  since it is static, main() method  can access it
     */
    public static class Node {
        public int data;
        public Node next;
        Node(int data)
        {
            this.data = data;
            next = null;
        }
    }

    /**
     * Insert a node to the given LinkedList
     * This method will insert at head if the list is empty
     * Or else, it will inset at last
     * @param list - LinkedList
     * @param data - node data
     */
    public static void  insert(MySinglyLinkedList list, int data)
    {
        Node node = new Node(data);
        node.next = null;

        // If the LinkedList is empty, then make the new node as head.
        if (list.head == null) {
            list.head = node;
        }
        else {// else traverse the list till the last node and insert at the last.
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            // Insert the new node at last node
            last.next = node;
        }
    }

    /**
     * This method will insert the new node after any given node.
     * @param previousNode
     * @param dataToBeInserted
     */
    public void insertAfter(Node previousNode, int dataToBeInserted)
    {
        if (previousNode == null)
        {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(dataToBeInserted);
        newNode.next = previousNode.next;
        previousNode.next = newNode;
    }


    /**
     * Delete a node by given data at the node.
     * @param list - LinkedList
     * @param data - node data
     */
    public void deleteByKey(MySinglyLinkedList list, int data)
    {
        System.out.println("trying to delete node with data:" + data);
        // Store head node
        Node currentNode = list.head;
        Node prev = null;

        if(currentNode!=null){
            if(currentNode.data==data){
                list.head = currentNode.next; // Changed head
                System.out.println("element " + data + " has been deleted");
            }else{
                while (currentNode != null && currentNode.data != data) {
                    prev = currentNode;
                    currentNode = currentNode.next;
                }
                if (currentNode != null) {
                    prev.next = currentNode.next;
                    System.out.println("element " + data  + " has been deleted");
                }else{
                    System.out.println("no node found with data:" + data);
                }
            }
        }
    }

    /**
     * Delete a node by given position.
     * @param list - LinkedList
     * @param pos - position of the node
     */
    public void deleteAtPosition(MySinglyLinkedList list, int pos)
    {
        System.out.println("trying to delete node at position:"+ pos);

        Node currentNode = list.head;
        Node prev = null;
        int counter = 0;

        if(currentNode!=null){
            if(pos==0){
                list.head = currentNode.next;
                System.out.println("element at position" + pos + " has been deleted");
            }else{
                // Count for the pos to be deleted, keep track of the previous node as it is needed to change currentNode.next
                while (currentNode != null) {
                    if (counter == pos) {
                        prev.next = currentNode.next;
                        System.out.println("element at " + pos + " has been deleted");
                        break;
                    } else {
                        prev = currentNode;
                        currentNode = currentNode.next;
                        counter++;
                    }
                }
            }
        }
        if(pos>counter){
            System.out.println("no node found at position:"+ pos + " ,as it greater than the size of the list");
        }

    }

    /**
     * Recursive Searching
     * find a node with given data in the LinkedList
     * @param head - head node
     * @param data - node data
     * @return - boolean value (true/false)
     */
    public boolean search(Node head, int data)
    {
        if (head == null)
            return false;
        if (head.data == data)
            return true;
        return search(head.next, data);
    }


    /**
     * Traverse and print the list
     * @param list
     */
    public void traverseAndPrintList(MySinglyLinkedList list)
    {
        Node currNode = list.head;
        System.out.print("LinkedList: ");
        while (currNode != null) {
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
        System.out.println();
    }

    /**
     *
     * @param list
     * @return the size of the list
     */
    public int size(MySinglyLinkedList list){
        int count=0;
        Node currNode = list.head;
        while (currNode != null) {
            count++;
            currNode = currNode.next;
        }
        return count;
    }
}
