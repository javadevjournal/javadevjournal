package com.javadevjournal.datastructure.tree.bst;


public class BinarySearchTree {

    private Node root;

    /**
     * Our main insert method which takes the integer as input and will pass
     * the parameter to internal insert method with the root node;
     * @param data
     * @return boolean status.
     */
    public boolean insert(int data) {
        root = insert(root, data);
        return true;
    }

    private Node insert(Node node, int data) {

        /**
         * If Node is null, either tree is empty or this is the
         * leaf node and we can create the node and return the new node.
         */
        if (node == null) {
            return new Node(data);
        }

        /**
         * if data is less than the current element,
         * let's go to the left side of the tree. We are giving a recursive call to the insert method
         * and will wait until response is back.
         */
        if (node.data > data) {
            node.left = insert(node.left, data);
        }

        /**
         * If data is greater than the current element,
         * let's go the right side of the tree.We are giving a recursive call to the insert method
         * and will wait until response is back. Other option is to use while loop.
         */
        if (node.data < data) {
            node.right = insert(node.right, data);
        }
        /**
         * Element already exist is the tree. Please note there are multiple variations for this step.
         * Few implementation do not allow duplicate element in BST (we are using same approach).
         * while other allow duplicate in BST and they can go either to left or right of the tree.
         */
        else{
            return node;
        }
        return node;
    }

    /**
     * Internal node class representing the node of the BST. This contains the following information
     * <li>data- actual data stored in the Tree</li>
     * <li>left - Left child of the node</li>
     * <li>right - right child of the node</li>
     */
    class Node {

        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            //this just for reading.they will be null by default
            this.left = null;
            this.right = null;
        }
    }
}
