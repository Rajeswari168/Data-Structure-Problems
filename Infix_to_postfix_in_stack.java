import java.util.*;
public class Main{
    public static int precedence(char ch){
        if(ch == '+' || ch == '-') 
            return 1;
        else if(ch == '*' || ch == '/') 
            return 2;
        else if(ch == '^') 
            return 3;
        else 
            return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Stack<Character> st = new Stack<>();
        String res = "";
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                res += ch;
            }
            else if(ch == '('){
                st.push(ch);
            }
            else if(ch == ')'){
                while(!st.isEmpty() && st.peek() != '('){
                    res += st.pop();
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && precedence(st.peek()) >= precedence(ch)){
                    res += st.pop();
                }
                st.push(ch);
            }
        }
        while(!st.isEmpty()){
            res += st.pop();
        }
        System.out.println(res);
    }
}
