import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class stack{
    Node top = null;
    void push(int data){
        Node newnode=new Node(data);
        if(top==null){
            top = newnode;
        }
        else{
            newnode.next = top;
            top = newnode;
        }
    }
    void pop(){
        if(top==null){
            System.out.print("Underflow");
        }
        else{
            top = top.next;
        }
    }
    void peek(){
        if(top==null){
            System.out.print("Underflow");
        }
        else{
            System.out.print(top.data);
        }
    }
    void display(){
        Node temp = top;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    // INFIX TO PREFIX
    void postfix(String str){
        char[] stack = new char[str.length()];
        int top = -1;
        String res = "";
        for(int i=str.length()-1; i>=0; i--){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res = ch + res;
            }
            else if(ch == ')'){
                stack[++top] = ch;
            }
            else if(ch == '('){
                while(top != -1 && stack[top] != ')'){
                    res = stack[top--] + res;
                }
                top--;
            }
            else{
                while(top != -1 &&
                      stack[top] != ')' &&
                      precedence(stack[top]) > precedence(ch)){

                    res = stack[top--] + res;
                }
                stack[++top] = ch;
            }
        }
        while(top != -1){
            res = stack[top--] + res;
        }
        System.out.print(res);
    }
    int precedence(char ch){
        if(ch == '+' || ch == '-'){
            return 1;
        }
        if(ch == '*' || ch == '/'){
            return 2;
        }
        if(ch == '^'){
            return 3;
        }
        return 0;
    }
}
public class infix_to_prefix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack s = new stack();
        String str = sc.nextLine();
        s.postfix(str);
    }
}