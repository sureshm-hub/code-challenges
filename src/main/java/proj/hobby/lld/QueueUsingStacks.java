package proj.hobby.lld;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 *
 * https://leetcode.com/problems/implement-queue-using-stacks/
 */
public class QueueUsingStacks {

    Deque<Integer> in = new ArrayDeque<>();
    Deque<Integer> out = new ArrayDeque<>();

    public QueueUsingStacks() {
    }

    public void push(int x) {
        in.push(x);
    }

    public int pop() {
        reverse();
        return out.pop();
    }

    public int peek() {
        reverse();
        return out.peek();
    }

    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

    private void reverse() {
        if(out.isEmpty())
            while(!in.isEmpty()) out.push(in.pop());
    }
}
