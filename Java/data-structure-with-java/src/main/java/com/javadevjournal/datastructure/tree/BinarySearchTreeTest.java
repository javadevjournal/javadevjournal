package com.javadevjournal.datastructure.tree;

import com.javadevjournal.datastructure.tree.bst.BinarySearchTree;

public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

         /* We are building a BST as below
             52
           /    \
          15     56
         /  \    /  \
        9    16 54   61
       / \
      3   10 */

        bst.insert(52);
        bst.insert(15);
        bst.insert(56);
        bst.insert(9);
        bst.insert(16);
        bst.insert(54);
        bst.insert(3);
        bst.insert(10);
        bst.insert(61);

        //inorder traversal
        bst.inOrderTraversal();
        System.out.println("*****************");
        //pre-order
        bst.preOrderTraversal();
        System.out.println("*****************");
        //post-order
        bst.postOrderTraversal();
    }
}
