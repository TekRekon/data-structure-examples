import java.util.Scanner;
import structures.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Type to test: 1-ArrayStack, 2-ArrayQueue, 3-LinkedStack");
        Scanner f = new Scanner(System.in);
        int choice = f.nextInt();
        switch (choice) {
            case 1:
                testArrayStack();
            case 2:
                testArrayQueue();
            case 3:
                testLinkedStack();
            case 4:
                testLinkedQueue();
        }
    }

    public static void testLinkedQueue() {
        LinkedQueue<String> q = new LinkedQueue<String>();
        //Write some code here to test your LinkedQueue

    }

    public static void testLinkedStack() {
        LinkedStack<String> stack = new LinkedStack<String>();
        //Write some code here to test your LinkedStack

    }

    public static void testArrayQueue() {
        ArrayQueue<Integer> q = new ArrayQueue<Integer>(5);
        //Write some code here to test your ArrayQueue

    }

    public static void testArrayStack() {
        ArrayStack<Integer> stack = new ArrayStack<Integer>(5);
        //Write some code here to test your ArrayStack

    }
}
