class void dfs(node,par){
    if(node==null) return;
    if(node is visited) return;
    mark node as visited;
    process node;
    for(child:node.children){
        if(child!=par){
            dfs(child,node);
        }
    }
}
public void bfs(startNode){
    Queue<Node> queue=new LinkedList<>();
    Set<Node> visited=new HashSet<>();
    queue.add(startNode);
    visited.add(startNode);
    while(!queue.isEmpty()){
        Node node=queue.remove();
        process(node);
        for(child:node.children){
            if(!visited.contains(child)){
                queue.add(child);
                visited.add(child);
            }
        }
    }
}
class cycleDetectionUndirectedGraph {
    public boolean hasCycle(Node node, Node parent, Set<Node> visited) {
        for(int i=0;i<=n;i++){
            if(par[i]==-1){
                if(dfsCycle(i,-1)) return true;
            }
        }
    }
    public boolean dfsCycle(int node,int parent){
        if(visit[node]  == 1) return true;
        visit[node] = 1;
        parent[node] = parent;
        for(int ch:mp.get(node)){
            if(ch!=parent){
                if(dfsCycle(ch,node)) return true;
            }
        }
        return false;
    }
}
class cycleDetectionDirectedGraph{
    public boolean hasCycle(int n, Map<Integer, List<Integer>> mp) {
        int[] visit = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (visit[i] == 0) {
                if (dfsCycle(i, visit, mp)) return true;
            }
        }
        return false;
    }
    public boolean dfsCycle(int node, int[] visit, Map<Integer, List<Integer>> mp) {
        for(int[]:edge:edges){
            int u=edge[0];
            int v=edge[1];
            mp.get(u).add(v);
            inDegree[v]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int curr=queue.remove();
            lt.add(curr);
            for(int ch:mp.get(curr)){
                inDegree[ch]--;
                if(inDegree[ch]==0){
                    queue.add(ch);
                }
            }
        }
        if(lt.size()!=n) return true;
        return false;
    }
}
