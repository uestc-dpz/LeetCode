public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null)
            return null;
        if(strs.length == 0)
            return "";
        if(strs.length == 1)
            return strs[0];
        
        int maxPrefixLen = strs[0].length();
        
        for(int i = 0; i < maxPrefixLen; i++) {
            for(int j = 1; j < strs.length; j++) {
                char c = strs[0].charAt(i);
                if(strs[j].length() <= i || c != strs[j].charAt(i)) 
                    return strs[0].substring(0,i);
            }
        }

        return strs[0];
    }
}