package proj.hobby.dsa.stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 */
public class MyStack {

    Queue<Integer> q1 = new ArrayDeque<>();
    Queue<Integer> q2 = new ArrayDeque<>();

    public MyStack() {
    }

    // O(N)
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // O(1)
    public int pop() {
        return q1.poll();
    }

    // O(1)
    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
