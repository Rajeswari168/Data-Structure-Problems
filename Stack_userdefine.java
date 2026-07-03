import java.util.Scanner;
class UserDefinedStack {
    int index, size;
    int[] stack;
    UserDefinedStack(int size) {
        this.size = size;
        this.index = -1;
        this.stack = new int[size];
    }
    public boolean isFull() {
        return size == index + 1;
    }
    public boolean isEmpty() {
        return index == -1;
    }
    public void push(int input) {
        if (isFull()) {
            System.out.println("Stack is full");
            return;
        }
        stack[++index] = input;
    }
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[index--];
    }
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[index];
    }
    public int getSize() {
        return index+1;
    }
    public void clear() {
        index = -1;
    }
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i = 0; i <= index; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        UserDefinedStack s = new UserDefinedStack(size);
        s.push(10);
        s.push(50);
        s.push(30);
        System.out.println(s.getSize());
        s.display();
        s.push(20);
        s.push(40);
        System.out.println(s.getSize());
        s.display();
        System.out.println(s.pop());
        s.display();
        System.out.println(s.peek());
        s.display();
        s.clear();
        s.display();
    }
}
