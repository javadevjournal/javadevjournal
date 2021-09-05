package stack;

class MyStack
{
    private int array[];
    private int top;
    private int capacity;

    MyStack(int size)
    {
        array = new int[size];
        capacity = size;
        top = -1;
    }

    /**
     *
     * @param item
     */
    public void push(int item)
    {
        if (isFull())
        {
            System.out.println("Can't push the element, Stack is full");
            return;
        }
        System.out.println("Pushing: " + item);
        array[++top] = item;
    }

    /**
     *
     * @return
     */
    public int pop()
    {
        if (isEmpty()) {
            System.out.println("Can't pop the element, Stack is empty");
            return -1;
        }
        System.out.println("Popping top element:"+array[top]);
        return array[top--];
    }

    /**
     * returns the size of stack
     * @return
     */
    public int size() {
        return top + 1;
    }

    /**
     * checks is stack is empty
     * @return
     */
    public Boolean isEmpty() {
        return size() == 0;
    }

    /**
     * checks if stack is full
     * @return
     */
    public Boolean isFull() {
        return size() == capacity;
    }

    public static void main (String[] args) {
        MyStack stack = new MyStack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.push(5);
        System.out.println("The stack size is " + stack.size());
        stack.pop();
        System.out.println("The stack size is " + stack.size());
    }
}
