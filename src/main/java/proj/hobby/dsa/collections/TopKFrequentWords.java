package proj.hobby.dsa.collections;

import java.util.*;

/**
 *
 * https://leetcode.com/problems/top-k-frequent-words
 *
 */
public class TopKFrequentWords {

    class WordFreq{
        String word;
        int freq;

        WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {

        // count word freq's
        final Map<String, Integer> wc = new HashMap<>();
        for(String w : words) {
            wc.merge(w, 1, Integer::sum);
        }

        // collect into a list
        final List<WordFreq> wordFreqs = new ArrayList<>();
        wc.keySet().stream().forEach(A -> wordFreqs.add(new WordFreq(A, wc.get(A)) ));

        // sort
        Comparator<WordFreq> comp = Comparator.comparingInt((WordFreq A) -> -1 * A.freq) // compare by frequency desc
                // .thenComparing( (wf1, wf2)  -> wf1.word.compareTo(wf2.word)); // compare by String lexic
                .thenComparing(wf -> wf.word); // compare by String lexic
        wordFreqs.sort(comp);

        // collect answer
        List<String> result = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            result.add(wordFreqs.get(i).word);
        }

        return result;
    }
}
