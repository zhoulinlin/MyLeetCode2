/**
 * 12. Integer to Roman
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 *
 * Example 1:
 * Input: num = 3
 * Output: "III"
 *
 * Example 2:
 * Input: num = 4
 * Output: "IV"
 *
 * Example 3:
 * Input: num = 9
 * Output: "IX
 *
 * Example 4:
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 5:
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * Constraints:
 * 1 <= num <= 3999
 */
public class Integer2Roman {

    public String intToRoman(int num) {
        String result="";

        int th = num/1000;
        if(th > 0){
            for(int i=0;i<th;i++){
                result = result + "M";
            }
        }

        int rest = num%1000;
        int hun = rest/100;
        if(hun > 0){
            if(hun<=3){
                for(int i=0;i<hun;i++){
                    result = result + "C";
                }
            }else if(hun == 4){
                result = result + "CD";
            }else if(hun == 5){
                result = result + "D";
            }else if(hun == 9){
                result = result + "CM";
            }else {
                result = result + "D";
                for(int i=0;i<hun-5;i++){
                    result = result + "C";
                }
            }
        }

        rest = num%100;
        int te = rest/10;
        if(te > 0){
            if(te <=3){
                for(int i=0;i<te;i++){
                    result = result + "X";
                }
            }else if(te == 4){
                result = result + "XL";
            }else if(te == 5){
                result = result + "L";
            }else if(te == 9){
                result = result + "XC";
            }else {
                result = result + "L";
                for(int i=0;i<te-5;i++){
                    result = result + "X";
                }
            }
        }

        rest = num%10;
        int s = rest;

        if(s > 0){
            if(s <=3){
                for(int i=0;i<s;i++){
                    result = result + "I";
                }
            }else if(s == 4){
                result = result + "IV";
            }else if(s == 5){
                result = result + "V";
            }else if(s == 9){
                result = result + "IX";
            }else {
                result = result + "V";
                for(int i=0;i<s-5;i++){
                    result = result + "I";
                }
            }
        }


        return result;
    }

    /**
     * Input: num = 1994
     * Output: "MCMXCIV"
     * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
     */
    class Solution {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        //Approach 1: Greedy
        public String intToRoman(int num) {
            StringBuilder sb = new StringBuilder();
            // Loop through each symbol, stopping if num becomes 0.
            for (int i = 0; i < values.length && num >= 0; i++) {
                // Repeat while the current symbol still fits into num.
                while (values[i] <= num) {
                    num -= values[i];
                    sb.append(symbols[i]);
                }
            }
            return sb.toString();
        }

        //Approach 2: Hardcode Digits
        public String intToRoman2(int num) {

            String[] thousands = {"", "M", "MM", "MMM"};
            String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

            return thousands[num / 1000] + hundreds[num % 1000 / 100] + tens[num % 100 / 10] + ones[num % 10];
        }
    }

}
