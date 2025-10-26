package proj.hobby.dsa.collections;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/flatten-nested-list-iterator/description/
 */
public class NestedIterator  implements Iterator<Integer> {

    private final Deque<Iterator<NestedInteger>> dq = new ArrayDeque<>();
    private Integer next = null;

    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList != null) {
            dq.push(nestedList.iterator());
        }
    }

    private boolean advance() {
        while(!dq.isEmpty()) {
            Iterator<NestedInteger> top = dq.peek();
            if(!top.hasNext()) {
                dq.pop();
                continue;
            }

            NestedInteger cur = top.next();
            if(cur.isInteger()) {
                next = cur.getInteger();//cache
                return true;
            } else {
                dq.push(cur.getList().iterator());
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new NoSuchElementException();
        Integer ans = next;
        next = null;
        return ans;
    }

    @Override
    public boolean hasNext() {
        if(next != null) return true;
        return advance();
    }
}
