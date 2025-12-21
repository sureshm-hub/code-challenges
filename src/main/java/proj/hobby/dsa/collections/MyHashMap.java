package proj.hobby.dsa.collections;

import java.util.Arrays;

/**
 *
 * https://leetcode.com/problems/design-hashmap/description
 *
 */
public class MyHashMap {

    private int[] data;
    private static final int MAX_KEY_VAL = 1000001;
    private static final int EMPTY_VAL = -1;

    public MyHashMap() {
        data = new int[MAX_KEY_VAL]; // 4 MB
        Arrays.fill(data, EMPTY_VAL);
    }

    public void put(int key, int value) {
        data[key] = value;
    }

    public int get(int key) {
        return data[key];
    }

    public void remove(int key) {
        data[key] = EMPTY_VAL;
    }
}
