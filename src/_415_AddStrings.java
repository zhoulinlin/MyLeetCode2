/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class _415_AddStrings {

    public String addStrings(String num1, String num2) {

        StringBuilder result = new StringBuilder();

        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        int sum;
        boolean isOne = false;
        char cn1,cn2;
        while(n1>=0 || n2 >=0){
            cn1 = n1>=0?num1.charAt(n1):'0';
            cn2 = n2>=0?num2.charAt(n2):'0';
            sum = Integer.valueOf(cn1) + Integer.valueOf(cn2);
            sum += isOne?1:0;
            isOne = sum >=10;
            result.append(sum%10);
            n1++;
            n2++;
        }


        return result.reverse().toString();

    }

}
