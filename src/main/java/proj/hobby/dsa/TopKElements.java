package proj.hobby.dsa;

import java.util.*;

public class TopKElements {

    public int[] frequentK(int[] nums, int K) {
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int val : nums) {
            frequency.put(val, frequency.getOrDefault(val,0)+1);
        }
        PriorityQueue<NumFrequency> pq = new PriorityQueue<>();
        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            pq.add(new NumFrequency(entry.getKey(), entry.getValue()));
            if(pq.size() > K) {
                pq.poll();
            }
        }

        int[] frequentK = new int[K];
        for(int i =0; i < K; i++) {
            NumFrequency next = pq.poll();
            if(next != null) {
                frequentK[i]  = next.num;
            }
        }
        return frequentK;
    }

    class NumFrequency implements Comparable<NumFrequency> {

        int num;
        int frequency;

        NumFrequency(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(NumFrequency other) {
            return Integer.compare(this.frequency, other.frequency);
        }
    }

}
