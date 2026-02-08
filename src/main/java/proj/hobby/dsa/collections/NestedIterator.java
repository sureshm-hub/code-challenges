package proj.hobby.dsa.collections;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class NestedIterator implements Iterator<Integer> {
    private Queue<Integer> dq = new ArrayDeque<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        addInteger(nestedList);
    }

    @Override
    public Integer next() {
        return dq.poll();
    }

    @Override
    public boolean hasNext() {
        return  !dq.isEmpty();
    }

    private void addInteger(List<NestedInteger> nestedList) {
        for(NestedInteger ni : nestedList) {
            if(ni.isInteger())
                dq.offer(ni.getInteger());
            else
                addInteger(ni.getList());
        }
    }
}
