import java.util.*;

class Stacks{
    //next greater element
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nge,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                nge[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return nge;
    }
    //next smallest element
    public static int[] nextSmallerElement(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(nse,-1);
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                nse[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return nse;
    }
    //previous greater element
    public static int[] previousGreaterElement(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(pge,-1);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] > arr[st.peek()]){
                pge[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return pge;
    }
    //previous smaller element
    public static int[] previousSmallerElement(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(pse,-1);
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                pse[st.pop()] = arr[i];
            }
            st.push(i);
        }
        return pse;
    }
    public static void main(String[] args) {
        int[] arr = {4,5,2,10,8};
        System.out.println("Next Greater Element: " + Arrays.toString(nextGreaterElement(arr)));
        System.out.println("Next Smaller Element: " + Arrays.toString(nextSmallerElement(arr)));
        System.out.println("Previous Greater Element: " + Arrays.toString(previousGreaterElement(arr)));
        System.out.println("Previous Smaller Element: " + Arrays.toString(previousSmallerElement(arr)));
    }
}

