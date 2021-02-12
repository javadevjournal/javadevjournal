package arrays;

import java.util.Arrays;

public class MyDynamicArray {
    private int array[];
    private int size;
    private int capacity;

    /**
     * Constructor with initial capacity of 2
     */
    public MyDynamicArray(){
        array = new int[2];
        size=0;
        capacity=2;
    }

    /**
     * check for capacity and if there is capacity add the element at the end of the array.
     * @param element
     */
    public void addElement(int element){
        if (size == capacity){
            try{
                increaseCapacity(2);
            }catch(Exception e){
                System.out.println("unable to increase the capacity of the array");
                e.printStackTrace();
            }
        }
        array[size++] = element;
    }

    /**
     * Adding element at a given index
     * @param index
     * @param element
     */
    public void addElement(int index, int element){
        //check if the array has capacity to add element.
        if (size == capacity){
            try{
                increaseCapacity(2);
            }catch(Exception e){
                System.out.println("unable to increase the capacity of the array");
                e.printStackTrace();
            }
        }
        // shift all elements from the given index to right
        for(int i=size-1;i>=index;i--){
            array[i+1] = array[i];
        }
        // insert the element at the specified index
        array[index] = element;
        size++;
    }

    /**
     * get an element from given index, O(1) time complexity
     * @param index
     * @return
     */
    public int getElement(int index){
        return array[index];
    }

    /**
     * Remove an element at the last index
     */
    public void remove(){
        if(size>1){
            array[size--]=0;
        }
    }

    /**
     * Remove an element from given index
     * @param index
     */
    public void removeAt(int index){
        if(index>=size || index<0){
            System.out.println("No element at this index");
        }else{//shifting
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=0;
            size--;
        }
    }


    /**
     * If there is no place to insert a new element,
     * double the capacity for the array by creating
     * a new array and copy exiting elements.
     * @param minCapacity
     */
    public void increaseCapacity(int minCapacity){
        int tempArray[] = new int[capacity*minCapacity];
        for (int i=0; i < capacity; i++){
            tempArray[i] = array[i];
        }
        array = tempArray;
        capacity = capacity * minCapacity;
    }

    /*
     *  Trim the capacity of dynamic array to the current size. i.e. remove unused space
     */
    public void trimToSize(){
        System.out.println("Trimming the array");
        int tempArray[] = new int[size];
        //we can use libraries as well to copy the array elements to temparray.
        for (int i=0; i < size; i++){
            tempArray[i] = array[i];
        }
        array = tempArray;
        capacity = array.length;

    }

    /**
     * return the size of the array
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * return the capacity of the array
     * @return
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * Print the array elements
     */
    public void printElements(){
        System.out.println("elements in array are :"+ Arrays.toString(array));
    }


    /**
     * main method
     * @param args
     */
    public static void main(String args[]){
        MyDynamicArray array = new MyDynamicArray();
        // adding two elements to the array
        array.addElement(1);
        array.addElement(2);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());

        array.addElement(3);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        // add element at index 1
        array.addElement(1,5);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        // add element at index 2
        array.addElement(2,6);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        array.removeAt(2);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        array.removeAt(2);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        array.removeAt(1);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        array.removeAt(2);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        array.removeAt(1);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        // Trim the array
        array.trimToSize();
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        array.addElement(2);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();

        array.addElement(3);
        System.out.println("The array size is :"+array.getSize() + " and the array capacity is :"+array.getCapacity());
        array.printElements();
    }
}
