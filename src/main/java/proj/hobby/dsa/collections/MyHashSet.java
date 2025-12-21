package proj.hobby.dsa.collections;

/**
 *
 * https://leetcode.com/problems/design-hashset/description
 */
public class MyHashSet {

    private boolean[] set;

    public MyHashSet() {
        this.set = new boolean[1000001]; // 1 MB
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    public boolean contains(int key) {
        return set[key];
    }
}
