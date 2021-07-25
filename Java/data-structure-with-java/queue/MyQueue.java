package queue;

class MyQueue {
    private int[] array;
    private int front;
    private int rear;
    private int capacity;
    private int size;

    MyQueue(int size) {
        array = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        this.size = 0;
    }

    /**
     * dequeue from queue
     */
    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Can't dequeue, Queue is empty");
            return;
        }
        System.out.println("Dequeue:" + array[front]);
        front = (front + 1) % capacity;
        size--;
    }

    /**
     * enqueue an item to the queue
     * @param item
     */
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Can't enqueue, Queue is full");
            return;
        }
        System.out.println("Enqueuing:" + item);
        rear = (rear + 1) % capacity;
        array[rear] = item;
        size++;
    }

    /**
     * @return the size of the queue
     */
    public int size() {
        return size;
    }

    /**
     * checks if queue is empty
     * @return
     */
    public Boolean isEmpty() {
        return (size() == 0);
    }

    /**
     * check if queue is full
     * @return
     */
    public Boolean isFull() {
        return (size() == capacity);
    }

    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        MyQueue queue = new MyQueue(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        System.out.println("The queue size is " + queue.size());
        queue.enqueue(5);
        System.out.println("The queue size is " + queue.size());
        queue.dequeue();
        System.out.println("The queue size is " + queue.size());
    }
}