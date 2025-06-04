package interviewQA.GreedyAlgorithms;

import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String[] args) {
        String s = "((*)*";
        boolean ans = checkValidString(s);
        System.out.println(ans);//true
    }

    public static boolean checkValidString(String s) {
        //to store '('
        Stack<Integer> st1 = new Stack<>();
        //to store '*'
        Stack<Integer> st2 = new Stack<>();

        int n = s.length();
        char[] str = s.toCharArray();
        int index = 0;//using index to keep track of whether the '(' or '*' is coming  first.
        //ideally '(' should come first followed by '*' to be valid.

        for(char ch : str){
            if(ch == '('){
                st1.push(index);
            }
            if(ch == '*'){
                st2.push(index);
            }
            //delete from stack 1 or stack 2 if we encounter a ')', if we dont have anything to delete then its invalid
            //as closing braces are more compared to opening braces
            if(ch == ')'){
                if(!st1.isEmpty()){
                    st1.pop();
                }else if(!st2.isEmpty()){
                    st2.pop();
                }else {
                    return false;
                }
            }
            index++;
        }

        //checking if any '(' open braces are left to be matched.
        //If yes, then trying to match them with '*' as ')' closing brace
        //Here we make use of index to check whether the '*' is coming after '('
        while(!st1.isEmpty() && !st2.isEmpty()){
            if(st2.peek() > st1.peek()){
                st2.pop();
                st1.pop();
            }else{
                break; // this means a '*' is coming before '(' which is invalid so breaking then and there
            }
        }

        //if all the open braces '(' have found a match, then st1 should be empty else invalid
        if(st1.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

}
