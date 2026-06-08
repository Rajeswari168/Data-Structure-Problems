import java.util.*;
class Main{
    int size;
    int stack[];
    int top;
    Main(int size){
        this.size = size;
        stack = new int[size];
        top = -1;
    }
    public void push(int val){
        if(top == size-1){
            System.out.println("Overflow");
        }else{
            stack[++top] = val;
        }
    }
    public int pop(){
        if(top == -1){
            return -1;
        }else{
            return stack[top--];
        }
    }
    boolean isEmpty(){
        return top==-1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        int graph[][]=new int[v][v];
        int visited[]=new int[v];
        for(int i=0;i<e;i++){
            int u=sc.nextInt();
            int w=sc.nextInt();
            graph[u][w]=1;
            graph[w][u]=1;
        }
        Main stack=new Main(v);
        int start=0;
        stack.push(start);
        visited[start]=1;
        while(!stack.isEmpty()){
            int node=stack.pop();
            System.out.print(node + " ");
            for(int i=v-1;i>=0;i--){
                if(visited[i]==0 && graph[node][i] !=0){
                    stack.push(i);
                    visited[i]=1;
                }
            }
        }
    }
}
