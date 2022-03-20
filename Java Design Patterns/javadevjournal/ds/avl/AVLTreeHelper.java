package javadevjournal.ds.avl;

import java.util.Scanner;

public class AVLTreeHelper{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        AVLTree avlTree = new AVLTree();

        char ch;
        do{
            System.out.println("\nAVLTree Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. search");
            System.out.println("3. count nodes");
            int choice = scanner.nextInt();
            switch (choice)
            {
                case 1 :
                    System.out.println("Enter integer element to insert");
                    avlTree.insert( scanner.nextInt() );
                    break;
                case 2 :
                    System.out.println("Enter integer element to search");
                    System.out.println("Search result : "+ avlTree.search( scanner.nextInt()));
                    break;
                case 3 :
                    System.out.println("Nodes = "+ avlTree.countNodes());
                    break;
                default :
                    System.out.println("Wrong Entry \n ");
                    break;
            }

            System.out.print("\nIn order : ");
            avlTree.inorder();

            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scanner.next().charAt(0);
        } while (ch == 'Y'|| ch == 'y');
    }
}
