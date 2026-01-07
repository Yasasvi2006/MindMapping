import java.util.*;
class BitManipulation {
    //Finding missing and repeating number
    public static int[] findMissingAndRepeating(int[] arr, int n) {
        int xor = 0;
        for (int num : arr) {
            xor ^= num;
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int setBit = xor & -xor;
        int x = 0, y = 0;
        for (int num : arr) {
            if ((num & setBit) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & setBit) != 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        for (int num : arr) {
            if (num == x) {
                return new int[]{y, x};
            }
        }
        return new int[]{x, y};
    }
    //Finding Akela
    public static int findAkela(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result ^= num;
        }
        return result;
    }
    //check,set,clear, flip bits
    public static boolean checkBit(int num, int i) {
        return (num & (1 << i)) != 0;
    }   
    public static int setBit(int num, int i) {
        return num | (1 << i);
    }
    public static int clearBit(int num, int i) {
        return num & ~(1 << i);
    }
    public static int flipBit(int num, int i) {
        return num ^ (1 << i);
    }

    //Given array of element where every element occurs thrice except one. Find that element.
    public static int findUnique(int[] arr) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (int num : arr) {
                if ((num & (1 << i)) != 0) {
                    sum++;
                }
            }
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
    //Power of two
    public static boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
    //power of any number
    public static int power(int x, int n) {
        int result = 1;
        while (n > 0) {
            if ((n & 1) != 0) {
                result *= x;
            }
            x *= x;
            n >>= 1;
        }
        return result;
    }
    //generate subsets
    public static List<List<Integer>> generateSubsets(int[] arr) {          
        List<List<Integer>> subsets = new ArrayList<>();
        int n = arr.length;
        int totalSubsets = 1 << n; 
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(arr[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }
}
