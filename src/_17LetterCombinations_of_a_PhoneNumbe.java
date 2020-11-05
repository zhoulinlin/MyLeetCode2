import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 *Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 *
 * Example 1:
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * Example 2:
 * Input: digits = ""
 * Output: []
 *
 * Example 3:
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 *
 */
public class _17LetterCombinations_of_a_PhoneNumbe {

    public List<String> letterCombinations(String digits) {
        List<String> re = new ArrayList<>();

        if(digits.isEmpty()){
            return re;
        }

        Map<Character, String> dic = new HashMap<>();
        dic.put('2',"abc");
        dic.put('3',"def");
        dic.put('4',"ghi");
        dic.put('5',"jkl");
        dic.put('6',"mno");
        dic.put('7',"pqrs");
        dic.put('8',"tuv");
        dic.put('9',"wxyz");

        for(int i=0;i < digits.length();i++){
            re = stringProduct(re,dic.get(digits.charAt(i)));

        }

        return re;
    }

    private List<String> stringProduct(List<String> list,String str){

        char c;
        int len =  list.size();
        List<String> newList = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            c = str.charAt(i);
            if(len == 0){
                newList.add(c+"");
            }else{
                for(int j = 0;j < len;j++){
                    String s = list.get(j);
                    newList.add(s+c);
                }
            }
        }
        return newList;
    }

}





















