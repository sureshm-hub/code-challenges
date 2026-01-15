package proj.hobby.lld;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/implement-stack-using-queues/
 *
 */
public class MyStack {

    Queue<Integer> in = new ArrayDeque<>();
    Queue<Integer> out = new ArrayDeque<>();

    public MyStack() {
    }

    // O(N)
    public void push(int x) {
        in.offer(x);
        while(!out.isEmpty()) {
            in.offer(out.poll());
        }
        Queue temp = out;
        out = in;
        in = temp;
    }

    // O(1)
    public int pop() {
        return out.poll();
    }

    // O(1)
    public int top() {
        return out.peek();
    }

    public boolean empty() {
        return out.isEmpty();
    }
}
