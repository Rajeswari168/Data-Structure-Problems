import java.util.*;
public class DFS_adjacencylist {
    static void dfs(int start, ArrayList<ArrayList<Integer>> list, int visited[]) {
        // 1. Mark start as visited
        visited[start] = 1;
        // 2. Process / display
        System.out.print(start + " ");
        // 3. Find adjacent vertices
        for(int i : list.get(start)) {
            // 4. If unvisited, recursive call
            if(visited[i] == 0) {
                dfs(i, list, visited);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            list.get(u).add(w);
            list.get(w).add(u);
        }
        int visited[] = new int[v + 1];
        int start = 1;
        dfs(start, list, visited);
    }
}