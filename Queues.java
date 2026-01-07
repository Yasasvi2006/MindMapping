import java.util.*;
class StackUsingQueues{
    Queue<Integer> q1;
    Queue<Integer> q2;
    public StackUsingQueues(){
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    void push(int x){
        q1.add(x);
    }
    int pop(){
        if(isEmpty()){
            return -1;
        }
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int ele = q1.remove();
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return ele;
    }
    int top(){
        if(isEmpty()){
            return -1;
        }
        while(q1.size()>1){
            q2.add(q1.remove());
        }
        int ele = q1.remove();
        q2.add(ele);
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        return ele;
    }

    boolean isEmpty(){
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println("Top element: " + stack.top()); // 30
        System.out.println("Popped element: " + stack.pop()); // 30
        System.out.println("Top element: " + stack.top()); // 20
    }
    
}

class QueueUsingStacks{
    Stack<Integer> s1;
    Stack<Integer> s2;
    public QueueUsingStacks(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    void enqueue(int x){
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        s1.push(x);
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
    }
    int dequeue(){
        if(s1.isEmpty()){
            return -1;
        }
        return s1.pop();
    }
    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println("Dequeued element: " + queue.dequeue()); // 10
        System.out.println("Dequeued element: " + queue.dequeue()); // 20
    }
}

class Pair{
    int num;
    int steps;
    public Pair(int num, int steps){
        this.num = num;
        this.steps = steps;
    }
}

class Nto1{
    public static int minSteps(int n){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n,0));
        while(true){ 
            Pair p = q.remove();
            int val = p.num;
            int lvl = p.steps;
            if(val == 1){
                return lvl;
            }
            if(val % 2 == 0){
                q.add(new Pair(val/2,lvl+1));
            }
            if(val % 3 == 0){
                q.add(new Pair(val/3,lvl+1));
            }
            q.add(new Pair(val-1,lvl+1));
        }
    }
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Minimum steps to reduce " + n + " to 1: " + minSteps(n));
    }
}

class LevelOrderTraversal{
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    public static List<List<Integer>> levelOrder(Node root){
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                level.add(curr.data);
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            ans.add(level);
        }
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        System.out.print("Level Order Traversal: ");
        levelOrder(root);
    }
}

class BurnATree{
    static class Node{
        int data;
        Node left, right;
        public Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    public static int burnTree(Node root, int target){
        Map<Node, Node> parentMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node targetNode = null;
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr.data == target){
                targetNode = curr;
            }
            if(curr.left != null){
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
        Set<Node> visited = new HashSet<>();
        q.add(targetNode);
        visited.add(targetNode);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean burned = false;
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                if(curr.left != null && !visited.contains(curr.left)){
                    visited.add(curr.left);
                    q.add(curr.left);
                    burned = true;
                }
                if(curr.right != null && !visited.contains(curr.right)){
                    visited.add(curr.right);
                    q.add(curr.right);
                    burned = true;
                }
                Node parent = parentMap.get(curr);
                if(parent != null && !visited.contains(parent)){
                    visited.add(parent);
                    q.add(parent);
                    burned = true;
                }
            }
            if(burned) time++;
        }
        return time;
    }
}