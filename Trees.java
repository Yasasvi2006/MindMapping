import java.util.*;
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
class BSTOperations{

    Node root;

    Node insert(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insert(root.left, key);
        else if (key > root.data)
            root.right = insert(root.right, key);
        return root;
    }
    Node deleteNode(Node root, int key) {
        if (root == null) return root;
        if (key < root.data)
            root.left = deleteNode(root.left, key);
        else if (key > root.data)
            root.right = deleteNode(root.right, key);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValue(root.right);
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }
    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }
    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
    void postorder(Node root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}

class DiameterOfBinaryTree{
    static int maxDiameter = 0;
    public static int diameter(Node root){
        if(root == null) return 0;
        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return Math.max(leftHeight, rightHeight) + 1;
    }
}

class LevelOrderTraversal{
    public static List<Integer> nodesAtKthLevel(Node root, int k){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(level == k){
                for(int i=0;i<size;i++){
                    Node curr = q.remove();
                    result.add(curr.data);
                }
                break;
            }
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            level++;
        }
        return result;
    }

    public static int noofSiblingsandCousins(Node root, int key){
        if(root == null || root.data == key) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            int count = 0;
            boolean found = false;
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                if((curr.left != null && curr.left.data == key) || (curr.right != null && curr.right.data == key)){
                    found = true;
                } else {
                    if(curr.left != null){
                        q.add(curr.left);
                        count++;
                    }
                    if(curr.right != null){
                        q.add(curr.right);
                        count++;
                    }
                }
            }
            if(found){
                return count;
            }
        }
        return 0;
    }
    public static List<Integer> leftView(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                if(i == 0){
                    result.add(curr.data);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }
    public static List<Integer> rightView(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                if(i == size - 1){
                    result.add(curr.data);
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return result;
    }
    public static List<Integer> zigZagTraversal(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = true;
        currentLevel.push(root);
        while(!currentLevel.isEmpty()){
            Node curr = currentLevel.pop();
            result.add(curr.data);
            if(leftToRight){
                if(curr.left != null) nextLevel.push(curr.left);
                if(curr.right != null) nextLevel.push(curr.right);
            } else {
                if(curr.right != null) nextLevel.push(curr.right);
                if(curr.left != null) nextLevel.push(curr.left);
            }
            if(currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
        return result;
    }
    public static int coveredNodesCount(Node root){
        if(root == null) return 0;
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                if(curr.left != null || curr.right != null){
                    count++;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return count;
    }
    public static int uncoveredNodesCount(Node root){
        if(root == null) return 0;
        int count = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Node curr = q.remove();
                if(curr.left == null && curr.right == null){
                    count++;
                }
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
        }
        return count;
    }
}

class Pair<Node, Integer> {
    private Node key;
    private int value;

    public Pair(Node key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }
}
class VerticalOrderTraversal{
    public static Map<Integer, List<Integer>> verticalOrder(Node root){
        Map<Integer, List<Integer>> columnTable = new TreeMap<>();
        if(root == null) return columnTable;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        while(!q.isEmpty()){
            Pair<Node, Integer> p = q.remove();
            Node curr = p.getKey();
            int column = p.getValue();
            columnTable.putIfAbsent(column, new ArrayList<>());
            columnTable.get(column).add(curr.data);
            if(curr.left != null) q.add(new Pair<>(curr.left, column - 1));
            if(curr.right != null) q.add(new Pair<>(curr.right, column + 1));
        }
        return columnTable;
    }
    public static List<Integer> topView(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Map<Integer, Integer> columnTable = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        while(!q.isEmpty()){
            Pair<Node, Integer> p = q.remove();
            Node curr = p.getKey();
            int column = p.getValue();
            if(!columnTable.containsKey(column)){
                columnTable.put(column, curr.data);
            }
            if(curr.left != null) q.add(new Pair<>(curr.left, column - 1));
            if(curr.right != null) q.add(new Pair<>(curr.right, column + 1));
        }
        for(Integer key : columnTable.keySet()){
            result.add(columnTable.get(key));
        }
        return result;
    }
    public static List<Integer> bottomView(Node root){
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Map<Integer, Integer> columnTable = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));
        while(!q.isEmpty()){
            Pair<Node, Integer> p = q.remove();
            Node curr = p.getKey();
            int column = p.getValue();
            columnTable.put(column, curr.data);
            if(curr.left != null) q.add(new Pair<>(curr.left, column - 1));
            if(curr.right != null) q.add(new Pair<>(curr.right, column + 1));
        }
        for(Integer key : columnTable.keySet()){
            result.add(columnTable.get(key));
        }
        return result;
    }
    //Least Common Ancestor in BST
    public static Node lcaBST(Node root, int n1, int n2){
        if(root == null) return null;
        if(root.data > n1 && root.data > n2){
            return lcaBST(root.left, n1, n2);
        }
        if(root.data < n1 && root.data < n2){
            return lcaBST(root.right, n1, n2);
        }
        return root;
    }
    //Binary Lifting
    public static Node lcaBinaryLifting(Node root, int n1, int n2){
        List<Node> path1 = new ArrayList<>();
        List<Node> path2 = new ArrayList<>();
        findPath(root, n1, path1);
        findPath(root, n2, path2);
        Node lca = null;
        int i=0, j=0;
        while(i < path1.size() && j < path2.size()){
            if(path1.get(i).data == path2.get(j).data){
                lca = path1.get(i);
            } else {
                break;
            }
            i++;
            j++;
        }
        return lca;
    }
    public static boolean findPath(Node root, int n, List<Node> path){
        if(root == null) return false;
        path.add(root);
        if(root.data == n) return true;
        if(findPath(root.left, n, path) || findPath(root.right, n, path)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
    //serializer and deserializer
    public static String serialize(Node root){
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(curr == null){
                sb.append("n ");
                continue;
            }
            sb.append(curr.data + " ");
            q.add(curr.left);
            q.add(curr.right);
        }
        return sb.toString();
    }
    public static Node deserialize(String data){
        if(data.isEmpty()) return null;
        String[] values = data.split(" ");
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(Integer.parseInt(values[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty()){
            Node curr = q.remove();
            if(!values[i].equals("n")){
                curr.left = new Node(Integer.parseInt(values[i]));
                q.add(curr.left);
            }
            i++;
            if(!values[i].equals("n")){
                curr.right = new Node(Integer.parseInt(values[i]));
                q.add(curr.right);
            }
            i++;
        }
        return root;
    }
}

class Recursion{
    //Is Mirror Image of Each Other
    public static boolean isMirror(Node root1, Node root2){
        if(root1 == null && root2 == null) return true;
        if(root1 == null || root2 == null) return false;
        return (root1.data == root2.data) &&
                isMirror(root1.left, root2.right) &&
                isMirror(root1.right, root2.left);
    }
}