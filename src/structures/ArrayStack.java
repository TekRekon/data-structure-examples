package structures;

public class ArrayStack<T> {
    private int nextEmptyIndex; //Index of the next available slot in the array
    private int maxSize;
    private T[] stack;

    public ArrayStack(int capacity) {
        nextEmptyIndex = 0;
        stack = (T[]) new Object[capacity];
        maxSize = capacity;
    }

    //time complexity: O(n)
    //space complexity: O(n)
    //Double the size of the array used to store the stack
    private void doubleSize() {
        T[] biggerStack = (T[]) new Object[2*maxSize];
        for (int i=0; i<maxSize; i++) {
            biggerStack[i] = stack[i];
        }
        maxSize *= 2;
        stack = biggerStack;
    }

    //time complexity: O(1)
    //space complexity: O(1)
    //Remove the top element from the stack and return it
    public T pop() {
        if (isEmpty()) { return null; }
        T poppedElem = stack[nextEmptyIndex-1];
        stack[nextEmptyIndex -1] = null;
        nextEmptyIndex -= 1;
        return poppedElem;
    }

    //Return the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) { return null; }
        return stack[nextEmptyIndex-1];
    }

    //time complexity: O(1)
    //space complexity: O(1)
    //If doubleSize() is called, the time and space complexity is O(n)
    //Add an element to the top of the stack
    public void push(T elem) {
        if (nextEmptyIndex >= maxSize) { doubleSize(); }
        stack[nextEmptyIndex] = elem;
        nextEmptyIndex++;
    }

    public boolean isEmpty() {
        return nextEmptyIndex <= 0;
    }

    public boolean isFull() {
        return nextEmptyIndex >= maxSize;
    }

    public int size() {
        return nextEmptyIndex;
    }

    public void printString() {
        System.out.println("BOTTOM");
        for (int i=0; i<nextEmptyIndex; i++) {
            System.out.println(stack[i]);
        }
        System.out.println("TOP");
        System.out.println("There are " + (maxSize-nextEmptyIndex) + " empty spaces left in the current array");
    }
}
