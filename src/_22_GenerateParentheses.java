import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses
 * Example 1:
 * Input: n = 3
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 *
 * Constraints:
 * 1 <= n <= 8
 *
 */
public class _22_GenerateParentheses {

    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){

        System.out.println("cur:" + cur + "open:" + open + " close:" + close + " max:" + max);

        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }

    public List<String> generateParenthesisq2(int n) {

        for(int i=1;i<n;i++){
            result.add(getPureP(i)+getPureP(n-i));
        }
        result.add(getNumP(n));
        result.add(getPureP(n));
        return result;
    }

    public String getNumP(int n){
        StringBuffer s =  new StringBuffer();
        for(int i=0;i<n;i++){
            s.append("()");
        }
        return s.toString();
    }

    public String getPureP(int n){
        StringBuffer s =  new StringBuffer();
        for(int i=0;i<n;i++){
            s.append("(");
        }

        for(int i=0;i<n;i++){
            s.append(")");
        }
        return s.toString();
    }
}
