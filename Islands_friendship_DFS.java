import java.util.Scanner;
public class Islands_friendship_DFS{
    static void dfs(int node, int[][] graph, boolean visited[], int n){
        visited[node]=true;
        for(int i=0;i<n;i++){
            if(graph[node][i]==1 && !visited[i]){
                dfs(i,graph,visited,n);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int graph[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=sc.nextInt();
            }
        }
        boolean visited[]=new boolean[n];
        int groups=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i,graph,visited,n);
                groups++;
            }
        }
        System.out.print(groups);
    }
}
