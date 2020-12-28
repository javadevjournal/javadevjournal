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
        9    16 54   65
       / \          /  \
      3   10       61   72 */

        bst.insert(52);
        bst.insert(15);
        bst.insert(56);
        bst.insert(9);
        bst.insert(16);
        bst.insert(54);
        bst.insert(3);
        bst.insert(10);
        bst.insert(65);
        bst.insert(72);
        bst.insert(61);

        System.out.println("Search result:: "+bst.search(72));
        System.out.println("Search result:: "+bst.search(200));
        System.out.println("Search result:: "+bst.search(9));
        System.out.println("Search result:: "+bst.search(567));
    }
}
