package proj.hobby.dsa.collections;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> itr;
    private Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        itr = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peek == null) {
            peek = itr.next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(peek == null) {
            return itr.next();
        }
        Integer next = peek;
        peek = null;
        return next;
    }

    @Override
    public boolean hasNext() {
        return peek != null || itr.hasNext();
    }
}
