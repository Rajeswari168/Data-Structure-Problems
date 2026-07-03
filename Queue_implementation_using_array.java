import java.util.*;
class Queue{
    int size;
    int arr[];
    int front;
    int rear;
    Queue(int size){
        this.size = size;
        arr = new int[size];
        front = -1;
        rear = -1;
    }
    public void enqueue(int data){
        if(rear == size-1){
            System.out.println("Queue is full");
        }
        else{
            if(front == -1){ 
                front = 0;
            }
            arr[++rear] = data;
        }
    }
    public void dequeue(){
        if(front == -1 && rear == -1){
            System.out.println("Queue is empty");
        }else if(front == rear){
            System.out.println(arr[front]);
            front = -1;
            rear = -1;
        }else{
            System.out.println(arr[front]);
            front++;
        }
    }
    public void display(){
        if(front == -1 && rear == -1){
            System.out.println("Queue is empty");
        }
        else{
            for(int i = front; i <= rear; i++){
                System.out.print(arr[i] + " ");
            }
        }
    }
}
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        Queue que = new Queue(size);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            que.enqueue(val);
        }
        que.dequeue();
        que.display();
    }
}
