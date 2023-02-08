package structures;

public class LinkedQueue<T> {
    private Node<T> first = null;
    private Node<T> last = null;
    private int length = 0; //number of nodes excluding the initial null node

    private class Node<T> {
        private Node<T> next;
        private T item;
    }

    //time complexity: O(1)
    //Add a node to the tail of the queue
    public void enqueue(T elem) {
        Node<T> newLast = last;
        last = new Node<T>();
        last.item = elem;
        last.next = newLast;
        if (isEmpty()) {
            first = last;
        }
        length++;
    }

    //time complexity: O(1)
    //Remove the head node and return its item
    public T dequeue() {
        if (isEmpty()) { return null; }
        Node<T> newFirst = first.next;
        T dequeuedItem = first.item;
        first = newFirst;
        length--;
        return dequeuedItem;
    }

    //Return the item of the head node without removing it
    public T peek() {
        if (isEmpty()) { return null; }
        return first.item;
    }

    public int size() {
        return length;
    }

    public boolean isEmpty() {
        return length<=0;
    }

    public void printString() {
        Node<T> currNode = first;
        int i = 0;
        while (i<length) {
            if ((length-1)==i) { System.out.print("TAIL: "); }
            if (i==0) { System.out.print("HEAD: "); }
            System.out.print(currNode.item);
            System.out.print(" | ");
            currNode = currNode.next;
        }
    }
}
