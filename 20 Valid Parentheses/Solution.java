import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public boolean isValid(String s) {
        if(s == null)
            return false;
        if((s.length() & 0x01) != 0)
            return false;
            
        //using stack to match the string
        Deque<Character> stack = new LinkedList<Character>();
        
        for(int i = 0 ; i < s.length(); i++) {
            Character c = s.charAt(i);
            Character to_match = stack.peek();
            
            if(to_match != null && match(to_match, c)) {
                stack.poll();
                continue;
            } else
                stack.push(c);
        }
        
        if(stack.size() != 0)
            return false;
        else
            return true;
    }
    
    private static boolean match(Character c1, Character c2) {
        if(c1.equals('(')) 
            return c2.equals(')')? true : false;
        else if(c1.equals('{'))
            return c2.equals('}')? true : false;
        else if(c1.equals('['))
            return c2.equals(']')? true : false;
        else
            return false;
    }
}