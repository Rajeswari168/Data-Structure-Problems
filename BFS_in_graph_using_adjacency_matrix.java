import java.util.*;
class Main {
    int size;
    int queue[];
    int front;
    int rear;
    Main(int size) {
        this.size = size;
        queue = new int[size];
        front = -1;
        rear = -1;
    }
    public void enqueue(int data) {
        if (rear == size - 1) {
            System.out.println("Queue is full");
        } else {
            if (front == -1) {
                front = 0;
            }
            queue[++rear] = data;
        }
    }
    public int dequeue() {
        if (front == -1 && rear == -1) {
            return -1;
        } else {
            int val = queue[front];
            front++;
            return val;
        }
    }
    public boolean isEmpty() {
        return (front == -1 && rear == -1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt(); 
        int graph[][] = new int[v][v];
        int visited[] = new int[v];
        for (int i = 0; i < e; i++) {
            int u = sc.nextInt();
            int w = sc.nextInt();
            graph[u][w] = 1;
            graph[w][u] = 1;
        }
        Main queue = new Main(v);
        int start = 0;
        queue.enqueue(start);
        visited[start] = 1;
        while (!queue.isEmpty()) {
            int node = queue.dequeue();
            System.out.print(node + " ");
            for (int i = 0; i < v; i++) {
                if (visited[i] == 0 && graph[node][i] == 1) {
                    queue.enqueue(i);
                    visited[i] = 1;
                }
            }
        }
    }
}
