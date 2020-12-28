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
     * In order BST traversal allows to traverse tree in the sorted order.
     * This traversal follow left->current-right pattern.
     * <li>left sub-tree will be viisted first.</li>
     * <li> Current node will be viisted after left traversal</li>
     * <li>Right subtree will be visited in the end.</li>
     */
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
    }


    // Delete the node from binary search tree
    public boolean delete(int data){
        return delete(root, data)!=null? true: false;
    }

    public boolean search(int data){
        return search(data, root) !=null? true: false;
    }

    /**
     * Internal method for searching element in the BST
     * @param data
     * @param root
     * @return
     */
    private Node search(int data, Node root){

        /*
         This is the base case for coming out of recursion. We will return if
         the node is null (not found) or if the node value is equal to the
         search element (key found)
         */
        if(root ==null || root.data== data){
            return root;
        }

        /*
         We will keep moving to the left sub-tree recursively if the key is
         less than the node value.
         */
        else if(data< root.data){
            return search(data, root.left);
        }

        /*
         We will moving to the right sub-tree if the key is greater than the node value.
         */
        return search(data, root.right);
    }


    /*
    Internal private method to do in order traversal.We will pass the
    root node to start with and will visit the tree recursively using the following
    path left-current-right
   */
    private void inOrderTraversal(Node node){

        //We will continue until null or empty node is found
        if(node!=null){

            //visit the left subtree until the leaf node
            inOrderTraversal(node.left);

            //Print the node
            System.out.println(node.data);

            //process the same step for the right node
            inOrderTraversal(node.right);
        }
    }


    /*
     Internal private method to do pre order traversal.We will pass the
     root node to start with and will visit the tree recursively using the following
     path current-left-right
    */
    private void preOrderTraversal(Node node){

        //We will continue until null or empty node is found
        if(node!=null){

            //Print the node
            System.out.println(node.data);

            //visit the left subtree until the leaf node
            preOrderTraversal(node.left);

            //process the same step for the right node
            preOrderTraversal(node.right);
        }
    }


    /*
     Internal private method to do post-order traversal.We will pass the
     root node to start with and will visit the tree recursively using the following
     path right-left-current
    */
    private void postOrderTraversal(Node node){

        //We will continue until null or empty node is found
        if(node!=null){

            //visit the left subtree until the leaf node
            postOrderTraversal(node.left);

            //process the same step for the right node
            postOrderTraversal(node.right);

            //Print the node
            System.out.println(node.data);
        }
    }

    private Node delete(Node root, int data){
        //this is the termination condition for our recursion call
        if(root ==null){
            return root;
        }
        //we will keep traversing the left subtree until the element is less than node data.
        else if(root.data>data){
            root.left = delete(root.left, data);
        }
        //we will keep traversing the right subtree until the element is greater than node data.
        else if(root.data< data){
            root.right = delete(root.right, data);
        }
        else{
            /*we have found a potential match, mow we need to check
            the 3 different cases to see which one should be executed.*/

            // we are dealing with situation, where we have either one child or no child
            if(root.left ==null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            /*this is the complex use case where element contains both left and right sub-tree
            We will go with our algorithm to find the minimum element in the right sub-tree and
            replace it followed by deletion
            */
            root.data = findMin(root.right);

            root.right= delete(root.right, root.data);
        }
        return root;
    }

    private int findMin(Node node){
        //we are assuming that it's the minimum value
        int min = node.data;

        //remember left sub-tree will have the minimum value.You can also use the same logic to implement BST without recursion.
        while(node.left!=null){
            min = node.left.data;
            node = node.left;
        }
        return min;
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
