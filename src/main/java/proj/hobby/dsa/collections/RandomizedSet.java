package proj.hobby.dsa.collections;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/insert-delete-getrandom-o1/
 */
public class RandomizedSet {

    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) return false;

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;

        int idx  = map.get(val);
        int last = list.get(list.size() - 1);
        list.set(idx, last);
        map.put(last, idx);

        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int idx = rand.nextInt(list.size());
        return list.get(idx);
    }
}
