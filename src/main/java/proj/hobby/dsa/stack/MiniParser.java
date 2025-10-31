package proj.hobby.dsa.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * https://leetcode.com/problems/mini-parser/description/
 */
public class MiniParser {

    public NestedInteger deserialize(String s) {

        if(s.charAt(0) != '[') {
            return new NestedIntegerImpl(Integer.parseInt(s));
        }

        Deque<NestedInteger> stack = new ArrayDeque<NestedInteger>();
        int start = 0;
        NestedInteger top = null;
        for(int i =0; i < s.length(); i++) {
            char c = s.charAt(i);

            if('['== c) {
                stack.push(new NestedIntegerImpl());
                start  = i + 1;
            } else if(',' == c) {
                if(i > start) {
                    int num = Integer.parseInt(s.substring(start, i));
                    stack.peek().add(new NestedIntegerImpl(num));
                }
                start = i + 1;
            } else if(']' == c) {
                NestedInteger last = stack.pop();
                if(i > start) {
                    int num = Integer.parseInt(s.substring(start, i));
                    last.add(new NestedIntegerImpl(num));
                }
                if(!stack.isEmpty()) stack.peek().add(last);

                top = last;
                start = i + 1;
            }
        }
        return top;
    }

    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // Set this NestedInteger to hold a single integer.
        void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        List<NestedInteger> getList();
    }


    public class NestedIntegerImpl implements NestedInteger {
        private Integer value;
        private List<NestedInteger> list;

        // Constructor for a single integer
        public NestedIntegerImpl(int value) {
            this.value = value;
            this.list = null;
        }

        // Constructor for an empty nested list
        public NestedIntegerImpl() {
            this.value = null;
            this.list = new ArrayList<>();
        }

        @Override
        public boolean isInteger() {
            return value != null;
        }

        @Override
        public Integer getInteger() {
            return value;
        }

        @Override
        public void setInteger(int value) {
            this.value = value;
            this.list = null; // clear list
        }

        @Override
        public void add(NestedInteger ni) {
            if (list == null)
                list = new ArrayList<>();
            list.add(ni);
        }

        @Override
        public List<NestedInteger> getList() {
            return list == null ? new ArrayList<>() : list;
        }

        @Override
        public String toString() {
            return isInteger() ? value.toString() : list.toString();
        }
    }
}
