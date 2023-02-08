package structures;

public class ArrayStack<T> {
    private int nextEmptyIndex; //Index of the next available slot in the array, can also be thought of as length
    private int maxSize;
    private T[] stack;

    public ArrayStack(int capacity) {
        nextEmptyIndex = 0;
        stack = (T[]) new Object[capacity];
        maxSize = capacity;
    }

    //time complexity: O(n)
    //Resize the array used to store the stack to length newSize
    private void resize(int newSize) {
        T[] resizedStack = (T[]) new Object[newSize];
        for (int i=0; i<newSize; i++) {
            resizedStack[i] = stack[i];
        }
        maxSize = newSize;
        stack = resizedStack;
    }

    //time complexity: O(1)
    //If halfSize() is called, the time complexity is O(n)
    //Remove the top element from the stack and return it
    public T pop() {
        if (isEmpty()) { return null; }
        T poppedElem = stack[nextEmptyIndex-1];
        stack[nextEmptyIndex -1] = null;
        nextEmptyIndex -= 1;
        if (nextEmptyIndex <= maxSize/4) { resize(maxSize/2); }
        return poppedElem;
    }

    //Return the top element of the stack without removing it
    public T peek() {
        if (isEmpty()) { return null; }
        return stack[nextEmptyIndex-1];
    }

    //time complexity: O(1)
    //If doubleSize() is called, the time complexity is O(n)
    //Add an element to the top of the stack
    public void push(T elem) {
        if (nextEmptyIndex >= maxSize) { resize(2*maxSize); }
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
