package structures;

public class ArrayQueue<T> {
    private T[] q;
    private int length;
    private int head; //Index of the starting element
    private int tail; //Index of the next empty space
    private int maxSize;

    public ArrayQueue(int capacity) {
        q = (T[]) new Object[capacity];
        length = 0;
        head = 0;
        tail = 0;
        maxSize = capacity;
    }

    //Time-complexity: O(n)
    //Space-complexity: O(n)
    //Double the size of the array used to store the queue
    private void resize(int newSize) {
        T[] resizedQueue = (T[]) new Object[newSize];
        int index = 0;
        do {                               //head=tail initially, so do once before checking for head=tail
            if (head>=maxSize) {
                head=0; //Reset head to account for wrapped elements
                continue;
            }
            resizedQueue[index] = q[head];
            index++;
            head++;
        }
        while (!(head==tail));
        maxSize = newSize;
        head = 0;
        tail = length;
        q = resizedQueue;
    }

    //Time-complexity: O(1)
    //Space-complexity: O(1)
    //If resize is called, then the time and space complexity is O(n)
    //Adds elem to the queue at q[tail]
    public void enqueue(T elem) {
        if (tail==maxSize) { tail = 0; }
        if ((tail==head && length>0)) { resize(2*maxSize); }
        q[tail] = elem;
        tail++;
        length++;
    }

    //Time-complexity: O(1)
    //Space-complexity: O(1)
    //Remove elem at q[head] and return it
    public T dequeue() {
        if (isEmpty()) { return null; }
        T dequeuedElem = q[head];
        q[head] = null;
        head++;
        length--;
        return dequeuedElem;
    }

    //Return elem at q[head] without returning it
    public T peek() {
        if (isEmpty()) { return null; }
        return q[head];
    }

    public boolean isEmpty() {
        return length<=0;
    }

    public boolean isFull() {
        return length>=maxSize;
    }

    public int size() {
        return length;
    }

    public void printString() {
        for (int i=0; i<maxSize; i++) {
            if (i==head) { System.out.print("HEAD: "); };
            if (i==tail) { System.out.print("TAIL: "); };
            System.out.print(q[i]);
            System.out.print(" | ");
        }
    }
}
