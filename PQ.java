import java.util.*;

class MinCostToMakeLongestChain{
    public static int minCostLongChain(List<Integer> arr){
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(arr);
        while(pq.size() > 1){
            int first = pq.remove();
            int second = pq.remove();
            pq.add(first+second);
            ans += first + second;
        }
        return ans;
    } 
}