import java.util.*;
public class PrefixSum {
    //static sum range queries
    public static int[] prefixSum(int[] arr, int n, int[][] queries, int q) {
        int[] ps = new int[n];
        ps[0] = arr[0];
        for (int i = 1; i < n; i++) {
            ps[i] = ps[i - 1] + arr[i];
        }
        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            if (l == 0) {
                result[i] = ps[r];
            } else {
                result[i] = ps[r] - ps[l - 1];
            }
        }
        return result;
    }

    //Interview Question: Given an array of integers, find the length of the longest subarray with sum equal to zero.
    public static int longestZeroSumSubarray(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                maxLength = i + 1;
            }
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
    //Interview Question: Given an array of integers, find the length of the longest subarray with sum equal to k.
    public static int longestKSumSubarray(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == k) {
                maxLength = i + 1;
            }
            if (map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
    //Index marking - from index a to b add k to all elements in that range (leetcode 370)
    public static int[] indexMarking(int n, int[][] updates) {
        int[] arr = new int[n];
        for (int[] update : updates) {
            int a = update[0];
            int b = update[1];
            int k = update[2];
            arr[a] += k;
            if (b + 1 < n) {
                arr[b + 1] -= k;
            }
        }
        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }
        return arr;
    }

    //Product of Array Except Self
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] result = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }

        return result;
    }

    //Leetcode 525: Contiguous Array
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] == 0) ? -1 : 1;
            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        return maxLength;
    }
    
}
