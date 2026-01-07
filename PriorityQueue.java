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
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(4, 3, 2, 6);
        int result = minCostLongChain(arr);
        System.out.println("Minimum cost to make longest chain: " + result); // Output: 29
    }
}

class MeetingRooms{
    public static int meetingRooms(ArrayList<ArrayList<Integer>> list){
        Collections.sort(list, (a,b) -> a.get(0) - b.get(0));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).get(1));
        for(int i=1;i<list.size();i++){
            if(list.get(i).get(0) >= pq.peek()){
                pq.remove();
            }
            pq.add(list.get(i).get(1));
        }
        return pq.size();
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> meetings = new ArrayList<>();
        meetings.add(new ArrayList<>(Arrays.asList(0, 30)));
        meetings.add(new ArrayList<>(Arrays.asList(5, 10)));
        meetings.add(new ArrayList<>(Arrays.asList(15, 20)));
        int result = meetingRooms(meetings);
        System.out.println("Minimum number of meeting rooms required: " + result); // Output: 2
    }
}

class RunningMedian{
    PriorityQueue<Integer> left; // lower half
    PriorityQueue<Integer> right; // upper half

    public RunningMedian(){
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }
    public float[] solve(int A[], int n) {
        float[] ans = new float[n];
        for(int i=0;i<n;i++){
            //Insert
            if(left.isEmpty()){
                left.add(A[i]);
            } else if(A[i] <= left.peek()){
                left.add(A[i]);
            } else {
                right.add(A[i]);
            }
            //Balance
            if(left.size() - right.size() > 1){
                right.add(left.remove());
            } else if(right.size() - left.size() > 1){
                left.add(right.remove());
            }
            //Get Median
            if(left.size() == right.size()){
                ans[i] = (left.peek() + right.peek()) / 2.0f;
            } else if(left.size() > right.size()){
                ans[i] = left.peek();
            } else {
                ans[i] = right.peek();
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        RunningMedian rm = new RunningMedian();
        int[] stream = {5, 15, 1, 3};
        float[] medians = rm.solve(stream, stream.length);
        System.out.println("Running medians: " + Arrays.toString(medians)); // Output: [5.0, 10.0, 5.0, 4.0]
    }
}

//Fraction Knapsack using Priority Queue
class Item{
    int value, weight;
    Item(int value, int weight){
        this.value = value;
        this.weight = weight;
    }
}   
class FractionKnapsack{
    public static double knapsack(int W, Item[] items, int n){
        PriorityQueue<Item> pq = new PriorityQueue<>((a,b) -> Double.compare((double)b.value/b.weight, (double)a.value/a.weight));
        pq.addAll(Arrays.asList(items));
        double totalValue = 0.0;
        while(W > 0 && !pq.isEmpty()){
            Item curr = pq.remove();
            if(curr.weight <= W){
                W -= curr.weight;
                totalValue += curr.value;
            } else {
                totalValue += curr.value * ((double)W / curr.weight);
                W = 0;
            }
        }
        return totalValue;
    }
    public static void main(String[] args) {
        Item[] items = {new Item(60, 10), new Item(100, 20), new Item(120, 30)};
        int W = 50;
        double maxValue = knapsack(W, items, items.length);
        System.out.println("Maximum value in Knapsack = " + maxValue); // Output: 240.0
    }
}

class MergeKSortedArrays{
    public static List<Integer> mergeKArrays(List<List<Integer>> arrays){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for(List<Integer> array : arrays){
            for(int num : array){
                pq.add(num);
            }
        }
        while(!pq.isEmpty()){
            result.add(pq.remove());
        }
        return result;
    }
    
}