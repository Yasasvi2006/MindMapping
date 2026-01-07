class unionOfTwoArrays{
    public List<Integer> unionOfTwoArrays(List<Integer> a, List<Integer> b) {
        List<Integer> lt = new ArrayList<>();
        int i = 0, j = 0, al = a.size(), bl = b.size();
        while (i < al && j < bl) {
            if (a.get(i) < b.get(j)) {
                if (lt.size() == 0 || !lt.get(lt.size() - 1).equals(a.get(i))) {
                    lt.add(a.get(i));
                }
                i++;
            } else {
                if (lt.size() == 0 || !lt.get(lt.size() - 1).equals(b.get(j))) {
                    lt.add(b.get(j));
                }
                j++;
            }
        }
        while (i < al) {
            if (lt.size() == 0 || !lt.get(lt.size() - 1).equals(a.get(i))) {
                lt.add(a.get(i));
            }
            i++;
        }
        while (j < bl) {
            if (lt.size() == 0 || !lt.get(lt.size() - 1).equals(b.get(j))) {
                lt.add(b.get(j));
            }
            j++;
        }
        return lt;
    }
}
class CountSubarrays {
    public static int countSubarraysSumKOrZero(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0, count = 0;
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            if (map.containsKey(prefixSum)) {
                count += map.get(prefixSum);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
class longestSubarraySum{
    public int longestSubarraySum0 ( List < Integer > a , int n ) {
        Map<Long,Integer m= new HashMap <>() ;
        long sum=0;
        int maxlen=0;
        m.put((long )0,-1);
        for(int i=0;i<n;i++){
            sum+=a.get(i);
            if (m.containsKey(sum)) maxlen=Math.max(i-m.get(sum),maxlen);
            else m.put(sum,i);
        }
        return maxlen ;
    }
}
class SquareSorted{
    public long[] solve(int a[],int n){
        long res[]=new long[n];
        int i=0,j=n-1;
        int k=n-1;
        while(i<=j){
            if((long)a[i]*(long)a[i]>(long)a[j]*(long)a[j]){
                res[k--]=(long)a[i]*(long)a[i];
                i++;
            }else{
                res[k--]= (long)a[j]*(long)a[j];
                j--;
            }
        }
        return res;
    }
}