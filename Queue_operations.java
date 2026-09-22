import java.util.*;
class Node{
    String data;
    Node next;
    Node(String data){
        this.data=data;
        this.next=null;
    }
}
class queue{
    Node front;
    Node rear;
    void enqueue(String data){
        Node newnode=new Node(data);
        if(front==null){
            front=newnode;
            rear=newnode;
        }
        else{
            rear.next=newnode;
            rear=newnode;
        }
    }
    void dequeue(){
        if(front==null){
            System.out.print("queue is empty");
        }else{
            System.out.print(front.data);
            front=front.next;
            if(front==null){
                rear=null;
            }
        }
    }
    void display(){
        if(front==null){
            System.out.print("queue is empty");
        }else{
            Node temp=front;
            while(temp!=null){
                System.out.print(temp.data);
                temp=temp.next;
            }
        }
    }
}
public class Queue_operations {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        queue q=new queue();
        int size=sc.nextInt();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            String str=sc.next();
            if(str.equals("ENQUEUE")){
                String s=sc.next();
                q.enqueue(s);
            }else if(str.equals("DEQUEUE")){
                q.dequeue();
            }else if(str.equals("DISPLAY")){
                q.display();
            }
        }
    }
}
