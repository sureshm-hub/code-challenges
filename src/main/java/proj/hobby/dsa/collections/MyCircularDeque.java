package proj.hobby.dsa.collections;

/**
 *
 * https://leetcode.com/problems/design-circular-deque/description
 *
 */
public class MyCircularDeque {

    private int[] q;
    private int head = 0;
    private int tail;
    private int size = 0;
    private int k;


    public MyCircularDeque(int k) {
        this.k = k;
        this.q = new int[k];
        this.tail = k - 1;
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;

        head = (--head + k ) % k;
        q[head] = value;
        ++size;
        return true;
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;

        tail = (++tail) % k;
        q[tail] = value;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;

        head = (++head) % k;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;

        tail = (--tail + k) % k;
        size--;
        return true;


    }

    public int getFront() {
        return isEmpty() ? -1 : q[head];
    }

    public int getRear() {
        return isEmpty() ? -1 : q[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == k;
    }

}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */