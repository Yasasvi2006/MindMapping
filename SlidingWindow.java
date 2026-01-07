import java.util.*;

public class SlidingWindowProblems {

    /* ---------- Count subarrays with sum <= K ---------- */
    public static int countSubarraysSumAtMostK(int[] arr, int k) {
        int l = 0, sum = 0, count = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum > k) {
                sum -= arr[l++];
            }
            count += (r - l + 1);
        }
        return count;
    }

    /* ---------- Smallest subarray length with sum <= K ---------- */
    public static int smallestSubarraySumAtMostK(int[] arr, int k) {
        int l = 0, sum = 0, ans = Integer.MAX_VALUE;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum > k) {
                sum -= arr[l++];
            }
            ans = Math.min(ans, r - l + 1);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /* ---------- Count subarrays with sum >= K ---------- */
    public static int countSubarraysSumAtLeastK(int[] arr, int k) {
        int l = 0, sum = 0, count = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum >= k) {
                count += (arr.length - r);
                sum -= arr[l++];
            }
        }
        return count;
    }

    /* ---------- Longest subarray length with sum >= K ---------- */
    public static int longestSubarraySumAtLeastK(int[] arr, int k) {
        int l = 0, sum = 0, ans = 0;
        for (int r = 0; r < arr.length; r++) {
            sum += arr[r];
            while (sum >= k) {
                ans = Math.max(ans, r - l + 1);
                sum -= arr[l++];
            }
        }
        return ans;
    }

    /* ---------- Fixed Window: Sum of each window ---------- */
    public static List<Integer> windowSum(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i >= k - 1) {
                res.add(sum);
                sum -= arr[i - k + 1];
            }
        }
        return res;
    }

    /* ---------- Fixed Window: Max of each window ---------- */
    public static List<Integer> windowMax(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) dq.pollLast();
            dq.addLast(i);
            if (i >= k - 1) res.add(arr[dq.peekFirst()]);
        }
        return res;
    }

    /* ---------- Fixed Window: Min of each window ---------- */
    public static List<Integer> windowMin(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) dq.pollFirst();
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) dq.pollLast();
            dq.addLast(i);
            if (i >= k - 1) res.add(arr[dq.peekFirst()]);
        }
        return res;
    }

    /* ---------- Fixed Window: Count unique elements ---------- */
    public static List<Integer> windowUniqueCount(int[] arr, int k) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> freq = new HashMap<>();
        int l = 0;
        for (int r = 0; r < arr.length; r++) {
            freq.put(arr[r], freq.getOrDefault(arr[r], 0) + 1);
            if (r - l + 1 == k) {
                res.add(freq.size());
                freq.put(arr[l], freq.get(arr[l]) - 1);
                if (freq.get(arr[l]) == 0) freq.remove(arr[l]);
                l++;
            }
        }
        return res;
    }
}
