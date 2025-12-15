package proj.hobby.dsa.binaryTree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * https://leetcode.com/problems/shopping-offers/
 */
public class ShoppingOffers {

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        Map<List<Integer>, Integer> memo = new HashMap<>();
        return dfs( price, special, needs, memo);
    }

    private int dfs(List<Integer> price, List<List<Integer>> sp, List<Integer> needs, Map<List<Integer>, Integer> memo) {
        // HashMap key must not mutate;
        List<Integer> key = new ArrayList<>(needs);
        Integer cached =  memo.get(key);
        if(cached != null) return cached;

        int n = price.size();

        // baseline: buy items as given price
        int best = 0;
        for(int i = 0; i < needs.size(); i++) {
            best += needs.get(i) * price.get(i);
        }

        // try each offer
        for(List<Integer> s : sp) {
            List<Integer> next = new ArrayList<>(n);
            boolean ok = true;
            for(int i = 0; i < n; i++) {
                int remain = needs.get(i) - s.get(i);
                if(remain < 0) {
                    ok = false;
                    break;
                }
                next.add(remain);
            }

            if(ok) {
                best = Math.min(best, s.get(n) + dfs(price, sp, next, memo));
            }
        }

        memo.put(key, best);
        return best;
    }
}
