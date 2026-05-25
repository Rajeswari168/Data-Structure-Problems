import java.util.*;
class Node {
    int data;
    Node next;
    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LL {
    Node head = null;
    Node temp = null;
    public void create(int data) {
        Node newnode = new Node(data);
        if (head == null) {
            head = newnode;
            temp = newnode;
        } else {
            temp.next = newnode;
            temp = newnode;
        }
    }
    public static void commonElements(LL list1, LL list2) {
        Node temp1 = list1.head;
        while (temp1 != null) {
            Node temp2 = list2.head;
            while (temp2 != null) {
                if (temp1.data == temp2.data) {
                    System.out.print(temp1.data + " ");
                    return;
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
    }
}
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        LL list1 = new LL();
        for (int i = 0; i < n1; i++) {
            list1.create(sc.nextInt());
        }
        int n2 = sc.nextInt();
        LL list2 = new LL();
        for (int i = 0; i < n2; i++) {
            list2.create(sc.nextInt());
        }
        LL.commonElements(list1, list2); 
    }
}
