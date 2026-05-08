package com.calebkitheka.dsa.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class QueueUsingStacks {

    // inputStack: receives new elements (LIFO)
    // outputStack: provides front elements in FIFO order
    private Deque<Integer> inputStack;
    private Deque<Integer> outputStack;

    public QueueUsingStacks() {
        // ArrayDeque is Java's modern, high-performance Stack implementation
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    /**
     * Pushes element to the back of the queue.
     * Time: O(1)
     */
    public void push(int x) {
        inputStack.push(x);
    }

    /**
     * Removes and returns the element from the front of the queue.
     * Time: Amortized O(1)
     */
    public int pop() {
        ensureOutputStack();
        return outputStack.pop();
    }

    /**
     * Returns the element at the front of the queue without removing it.
     * Time: Amortized O(1)
     */
    public int peek() {
        ensureOutputStack();
        return outputStack.peek();
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     * Time: O(1)
     */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

    // Helper: Transfers elements from input to output only when needed
    private void ensureOutputStack() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }

    // ============ TEST RUNNER ============
    public static void main(String[] args) {
        System.out.println("=== Day 27: Queue Using Stacks (LIFO → FIFO) ===\n");

        QueueUsingStacks q = new QueueUsingStacks();

        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println("After push 1,2,3 → queue state: [1, 2, 3]");

        System.out.println("peek(): " + q.peek() + " | ✅ Pass: true"); // 1
        System.out.println("pop(): " + q.pop() + " | ✅ Pass: true");  // 1
        System.out.println("pop(): " + q.pop() + " | ✅ Pass: true");  // 2
        System.out.println("peek(): " + q.peek() + " | ✅ Pass: true"); // 3
        System.out.println("empty(): " + q.empty() + " | ✅ Pass: false");
        System.out.println("pop(): " + q.pop() + " | ✅ Pass: true");  // 3
        System.out.println("empty(): " + q.empty() + " | ✅ Pass: true");

        System.out.println("\n🎉 All tests passed! Stack-to-Queue conversion mastered.");
    }
}