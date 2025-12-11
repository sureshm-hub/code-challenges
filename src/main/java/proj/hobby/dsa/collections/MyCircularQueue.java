package proj.hobby.dsa.collections;

/**
 *
 * https://leetcode.com/problems/design-circular-queue
 */
public class MyCircularQueue {

    private int capacity;
    private int[] data;
    private int head;
    private int size;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.data = new int[k];
    }

    public boolean enQueue(int value) {
        if(isFull()) return false;
        int tail = (head + size) % capacity;  // next free slot
        data[tail] = value;
        ++size;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()) return false;
        head = (head + 1) % capacity;
        --size;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : data[head];
    }

    public int Rear() {
        if(isEmpty()) {
            return -1;
        }
        int tail = (head + size - 1) % capacity;
        return data[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */