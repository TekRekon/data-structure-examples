package structures;

public class LinkedStack<T> {

    private Node<T> first = null;
    private int length = 0; //number of nodes excluding the initial null node

    private class Node<T> {
        private Node<T> next;
        private T item;
    }

    public boolean isEmpty() {
        return length<=0;
    }

    //time complexity: O(1)
    //Add a node to the head of the stack (before the first node)
    public void push(T elem) {
        Node<T> pushedNode = first;
        first = new Node<T>();
        first.item = elem;
        first.next = pushedNode;
        length++;
    }

    //time complexity: O(1)
    //Remove the first node and return its item
    public T pop() {
        if (isEmpty()) { return null; }
        Node<T> newFirst = first.next;
        T poppedItem = first.item;
        first = newFirst;
        length--;
        return poppedItem;
    }

    //Return the item of the first node without removing it
    public T peek() {
        if (isEmpty()) { return null; }
        return first.item;
    }

    public int size() {
        return length;
    }

    public void printString() {
        Node<T> currNode = first;
        int i = 0;
        System.out.println("BOTTOM");
        while (i<length) {
            System.out.println(currNode.item);
            currNode = currNode.next;
        }
        System.out.println("TOP");
    }
}
