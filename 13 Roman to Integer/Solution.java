public class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() <= 0)
            return 0;
        int result = 0;
        char last_char = s.charAt(0);
        int last_value = getRomanValue(last_char);
        int sub = last_value;
        for(int i = 1; i < s.length(); i++) {
            char cur_char = s.charAt(i);
            int cur_value = getRomanValue(cur_char);
            if(cur_value == last_value)
                sub += cur_value;
            else if(cur_value > last_value)
                sub = cur_value - sub;
            else {
                result += sub;
                sub = cur_value;
            }
            last_value = cur_value;
        }
        result += sub;
        return result;
        
    }
    
    private int getRomanValue(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
            default: return -1; 
        }
    }
}