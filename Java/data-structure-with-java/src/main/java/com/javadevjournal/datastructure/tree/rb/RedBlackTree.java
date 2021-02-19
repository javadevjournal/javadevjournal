package com.javadevjournal.datastructure.tree.rb;

/**
 * Red and black tree in Java
 */
public class RedBlackTree {

    private Node root;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public boolean insert(int data) {
        Node n = add(data);
        if (root == null) {
            root = n;
        }
        fixTree(n);
        return true;
    }

    private Node add(int data) {
        Node x = root;
        Node y = null;
        Node n = new Node(data);
        while (x != null) {
            y = x;
            if (x.data > data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        if (y == null) {
            y = n;
        } else if (y.data > data) {
            n.parent = y;
            y.left = n;
        } else {
            n.parent = y;
            y.right = n;
        }
        return n;
    }


    private void fixTree(Node n) {
        n.color = RED;

        while (n != null && n != root && n.parent.color == RED) {
            if (parentOf(n) == leftOf(parentOf(parentOf(n)))) {
                Node y = rightOf(parentOf(parentOf(n)));
                if (colorOf(y) == RED) {
                    // we do color flip.
                    setColor(parentOf(n), BLACK);
                    setColor(parentOf(parentOf(n)), RED);
                    setColor(y, BLACK);
                    n = parentOf(parentOf(n));
                } else {
                    // we do rotate
                    if (rightOf(parentOf(n)) == n) {
                        //right child
                        n = parentOf(n);
                        leftRotate(parentOf(n));

                    }
                    setColor(parentOf(n), BLACK);
                    setColor(parentOf(parentOf(n)), RED);
                    rightRotate(parentOf(parentOf((n))));
                }
            } else {

                Node y = leftOf(parentOf(parentOf(n)));
                if (colorOf(y) == RED) {
                    // we do color flip.
                    setColor(parentOf(n), BLACK);
                    setColor(parentOf(parentOf(n)), RED);
                    setColor(y, BLACK);
                    n = parentOf(parentOf(n));
                } else {
                    // we do rotate
                    if (leftOf(parentOf(n)) == n) {
                        //right child
                        n = parentOf(n);
                        rightRotate(parentOf(n));

                    }
                    setColor(parentOf(n), BLACK);
                    setColor(parentOf(parentOf(n)), RED);
                    leftRotate(parentOf(parentOf((n))));
                }
            }
        }

        root.color = BLACK;
    }

    private boolean colorOf(Node n) {
        return n != null ? n.color : BLACK;
    }

    private Node leftOf(Node n) {
        return n != null ? n.left : null;
    }

    private Node rightOf(Node n) {
        return n != null ? n.right : null;
    }

    private Node parentOf(Node n) {
        return n != null ? n.parent : null;
    }

    private void setColor(Node n, boolean color) {
        if (n != null) {
            n.color = color;
        }
    }

    private void leftRotate(Node n) {
        if (n != null) {
            Node temp = n.right;
            n.right = temp.left;
            if (leftOf(temp) != null) {
                temp.left.parent = n;
            }
            temp.parent = n.parent;
            if (parentOf(n) == null) {
                root = temp;
            } else if (leftOf(parentOf(n)) == n) {
                n.parent.left = temp;
            } else {
                n.parent.right = temp;
            }
            temp.left = n;
            n.parent = temp;
        }
    }

    private void rightRotate(Node n) {
        if (n != null) {
            Node temp = n.left;
            n.left = temp.right;

            if (rightOf(temp) != null) {
                temp.right.parent = n;
            }
            temp.parent = n.parent;
            if (parentOf(n) == null) {
                root = temp;
            } else if (rightOf(parentOf(n)) == n) {
                n.parent.right = temp;
            } else {
                n.parent.left = temp;
            }
            temp.right = n;
            n.parent = temp;

        }
    }


    public class Node {
        Node left, right, parent;
        int data;
        boolean color;

        public Node(int data) {
            this.data = data;
        }
    }

}