/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 *
 * 0 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 */
public class _14LongestCommonPrefix {

    //Mine
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length == 0 || strs[0].isEmpty())
            return "";

        if(strs.length == 1){
            return strs[0];
        }

        StringBuffer result = new StringBuffer();

        char cur;
        for(int p=0;p<strs[0].length();p++){
            cur = strs[0].charAt(p);
            for(int i=1;i< strs.length;i++){
                if(strs[i].isEmpty() || strs[i].length() <= p ||strs[i].charAt(p) != cur){
                    return result.toString();
                }
            }
            result.append(cur);
        }
        return result.toString();
    }

}
