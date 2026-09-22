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
    // INFIX TO POSTFIX
    void postfix(String str){
        char[] stack = new char[str.length()];
        int top = -1;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            // Operand
            if(Character.isLetterOrDigit(ch)){
                System.out.print(ch);
            }
            // Opening bracket
            else if(ch == '('){
                stack[++top] = ch;
            }
            // Closing bracket
            else if(ch == ')'){
                while(top != -1 && stack[top] != '('){
                    System.out.print(stack[top--]);
                }
                top--; // remove '('
            }
            // Operator
            else{
                while(top != -1 &&
                      precedence(stack[top]) >= precedence(ch)){
                    System.out.print(stack[top--]);
                }
                stack[++top] = ch;
            }
        }
        // Remaining operators
        while(top != -1){
            System.out.print(stack[top--]);
        }
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
public class infix_to_postfix{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        stack s = new stack();
        String str = sc.nextLine();
        s.postfix(str);
    }
}