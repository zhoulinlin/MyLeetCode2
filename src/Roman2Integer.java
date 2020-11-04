import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 *
 * Example 5:
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class Roman2Integer {
    public int romanToInt(String s) {

        Map<Character, Integer> dic = new HashMap<>();
        dic.put('I',1);
        dic.put('V',5);
        dic.put('X',10);
        dic.put('L',50);
        dic.put('C',100);
        dic.put('D',500);
        dic.put('M',1000);

        int pre = 0,cur,result = 0;

        for(int i = s.length()-1; i >= 0 ; i--){
            cur = dic.get(s.charAt(i));

            if(cur >= pre){
                result = result + cur;
            }else{
                result-=cur;
            }
            pre = cur;
        }

        return result;
    }

}


















