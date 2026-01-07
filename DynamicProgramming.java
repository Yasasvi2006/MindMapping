import java.util.*;
public class DynamicProgramming {
    class CountingDP{
        //Climbing Stairs
        public int climbStairs(int n) {
            if(n <= 1) return 1;
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            for(int i = 2; i <= n; i++){
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
        //Arranging Coins
        public int arrangeCoins(int n) {
            int left = 0, right = n;
            while(left <= right){
                int mid = left + (right - left) / 2;
                long curr = (long)mid * (mid + 1) / 2;
                if(curr == n) return mid;
                if(curr < n) left = mid + 1;
                else right = mid - 1;
            }
            return right;
        }
        //Top Down Approach for Climbing Stairs
        public int climbStairsTopDown(int n) {
            int[] memo = new int[n + 1];
            return climb(n, memo);
        }
        private int climb(int n, int[] memo){
            if(n <= 1) return 1;
            if(memo[n] != 0) return memo[n];
            memo[n] = climb(n - 1, memo) + climb(n - 2, memo);
            return memo[n];
        }
    }

    class GridDP{
        //Unique Paths in a Grid
        public int uniquePaths(int m, int n) {
            int[][] dp = new int[m][n];
            for(int i = 0; i < m; i++){
                dp[i][0] = 1;
            }
            for(int j = 0; j < n; j++){
                dp[0][j] = 1;
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
            return dp[m - 1][n - 1];
        }
        //collecting apples in a grid
        public int maxApples(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[][] dp = new int[m][n];
            dp[0][0] = grid[0][0];
            for(int i = 1; i < m; i++){
                dp[i][0] = dp[i - 1][0] + grid[i][0];
            }
            for(int j = 1; j < n; j++){
                dp[0][j] = dp[0][j - 1] + grid[0][j];
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                }
            }
            return dp[m - 1][n - 1];
        }
        //Toll Booth Problem
        int tollBooth(int[][] mat, int rows, int cols) {
            int ans = Integer.MAX_VALUE;
            int[][] dp = new int[rows][cols];
            for (int[] r : dp) Arrays.fill(r, Integer.MAX_VALUE);

            for (int i = 0; i < rows; i++) {
                ans = Math.min(ans, helper(mat, dp, i, cols - 1));
            }
            return ans;
        }

        int helper(int[][] mat, int[][] dp, int i, int j) {
            if (i < 0 || i >= mat.length) return Integer.MAX_VALUE;
            if (j == 0) return mat[i][j];
            if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

            int leftUp = helper(mat, dp, i - 1, j - 1);
            int left = helper(mat, dp, i, j - 1);
            int leftDown = helper(mat, dp, i + 1, j - 1);

            return dp[i][j] = Math.min(leftUp, Math.min(left, leftDown)) + mat[i][j];
        }



    }

    class SubsetDP{
        //0-1 Knapsack Problem
        public int knapsack(int W, int[] wt, int[] val, int n) {
            int[][] dp = new int[n + 1][W + 1];
            for(int i = 1; i <= n; i++){
                for(int w = 0; w <= W; w++){
                    if(wt[i - 1] <= w){
                        dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                    } else {
                        dp[i][w] = dp[i - 1][w];
                    }
                }
            }
            return dp[n][W];
        }
        //subset sum problem using memoization
        public boolean isSubsetSum(int[] set, int n, int sum) {
            Boolean[][] memo = new Boolean[n + 1][sum + 1];
            return subsetSumHelper(set, n, sum, memo);
        }
        private boolean subsetSumHelper(int[] set, int n, int sum, Boolean[][] memo){
            if(sum == 0) return true;
            if(n == 0) return false;
            if(memo[n][sum] != null) return memo[n][sum];
            if(set[n - 1] <= sum){
                memo[n][sum] = subsetSumHelper(set, n - 1, sum - set[n - 1], memo) || subsetSumHelper(set, n - 1, sum, memo);
            } else {
                memo[n][sum] = subsetSumHelper(set, n - 1, sum, memo);
            }
            return memo[n][sum];
        }
        //Partition Equal Subset Sum
        public boolean canPartition(int[] nums) {
            int total = 0;
            for(int num : nums) total += num;
            if(total % 2 != 0) return false;
            int target = total / 2;
            int n = nums.length;
            Boolean[][] memo = new Boolean[n + 1][target + 1];
            return subsetSumHelper(nums, n, target, memo);
        }
        //Minimum Subset Sum Difference
        public int minSubsetSumDifference(int[] nums) {
            int total = 0;
            for(int num : nums) total += num;
            int n = nums.length;
            boolean[][] dp = new boolean[n + 1][total + 1];
            for(int i = 0; i <= n; i++) dp[i][0] = true;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= total; j++){
                    if(nums[i - 1] <= j){
                        dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            int minDiff = Integer.MAX_VALUE;
            for(int s1 = 0; s1 <= total / 2; s1++){
                if(dp[n][s1]){
                    int s2 = total - s1;
                    minDiff = Math.min(minDiff, Math.abs(s2 - s1));
                }
            }
            return minDiff;
        }
        //Unbounded Knapsack Problem
        public int unboundedKnapsack(int W, int[] wt, int[] val, int n) {
            int[] dp = new int[W + 1];
            for(int w = 0; w <= W; w++){
                for(int i = 0; i < n; i++){
                    if(wt[i] <= w){
                        dp[w] = Math.max(dp[w], dp[w - wt[i]] + val[i]);
                    }
                }
            }
            return dp[W];
        }
    }
    class StringDP{
        //Longest Common Subsequence
        public int longestCommonSubsequence(String text1, String text2) {
            int m = text1.length();
            int n = text2.length();
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[m][n];
        }
        //Longest Common Substring
        public int longestCommonSubstring(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            int[][] dp = new int[m + 1][n + 1];
            int maxLength = 0;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(s1.charAt(i - 1) == s2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                        maxLength = Math.max(maxLength, dp[i][j]);
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            return maxLength;
        }

        //Longest Palindromic Subsequence
        public int longestPalindromicSubsequence(String s) {
            int n = s.length();
            int[][] dp = new int[n][n];
            for(int i = n - 1; i >= 0; i--){
                dp[i][i] = 1;
                for(int j = i + 1; j < n; j++){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return dp[0][n - 1];
        }
        //Longest Palindromic Substring using memoization
        public String longestPalindromicSubstring(String s) {
            int n = s.length();
            Boolean[][] memo = new Boolean[n][n];
            String longest = "";
            for(int i = 0; i < n; i++){
                for(int j = i; j < n; j++){
                    if(isPalindrome(s, i, j, memo)){
                        if(j - i + 1 > longest.length()){
                            longest = s.substring(i, j + 1);
                        }
                    }
                }
            }
            return longest;
        }
        private boolean isPalindrome(String s, int left, int right, Boolean[][] memo){
            if(left >= right) return true;
            if(memo[left][right] != null) return memo[left][right];
            if(s.charAt(left) == s.charAt(right)){
                memo[left][right] = isPalindrome(s, left + 1, right - 1, memo);
            } else {
                memo[left][right] = false;
            }
            return memo[left][right];
        }
        //Edit Distance
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for(int i = 0; i <= m; i++) dp[i][0] = i;
            for(int j = 0; j <= n; j++) dp[0][j] = j;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                    }
                }
            }
            return dp[m][n];
        }
    }
}
