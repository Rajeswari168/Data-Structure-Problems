import java.util.*;
public class BFS_adjacencylist {
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
        Queue<Integer> queue = new LinkedList<>();
        int start = 1;
        // Root Step
        visited[start] = 1;
        queue.add(start);
        // Repetitive Step
        while(!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");
            for(int i : list.get(node)) {
                if(visited[i] == 0) {
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }
    }
}