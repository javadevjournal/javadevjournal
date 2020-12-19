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
        9    11  54   61
       / \
      3   5 */

        bst.insert(52);
        bst.insert(15);
        bst.insert(56);
        bst.insert(9);
        bst.insert(11);
        bst.insert(54);
        bst.insert(3);
        bst.insert(5);
        bst.insert(61);
    }
}
