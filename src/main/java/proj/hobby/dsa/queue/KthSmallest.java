package proj.hobby.dsa.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 *
 */
public class KthSmallest {

    public int kthSmallest(int[][] matrix, int k) {

        int N = matrix.length;

        record T(int i, int j, int val){}

        Queue<T> heap = new PriorityQueue<>(Comparator.comparingInt(T::val));

        for(int i = 0; i < Math.min(k, N); i++) {
            heap.offer(new T(i, 0, matrix[i][0]));
        }

        while (k-- > 1) {
            T t = heap.poll();
            int i = t.i();
            int j = t.j();
            if(j+1 < N) heap.offer(new T(i, j+1, matrix[i][j+1]));
        }

        return heap.peek().val;

    }
}
