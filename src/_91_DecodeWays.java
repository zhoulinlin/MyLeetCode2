import java.util.HashMap;



public class _91_DecodeWays {

    HashMap<Integer, Integer> memo = new HashMap<>();

    private int recursiveWithMemo(int index, String str) {

        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length()-1) {
            return 1;
        }

        // Memoization is needed since we might encounter the same sub-string.
        if (memo.containsKey(index)) {
            return memo.get(index);
        }

        int ans = recursiveWithMemo(index+1, str);
        if (Integer.parseInt(str.substring(index, index+2)) <= 26) {
            ans += recursiveWithMemo(index+2, str);
        }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        return recursiveWithMemo(0, s);
    }



//    HashMap<String, Integer> memo = new HashMap<>();
//    public int numDecodings2(String s) {
//        System.out.println("numDecodings:" + s);
//
//        if(s.length() == 1 && s.charAt(0)==0){
//            return 0;
//        }
//
//        if(memo.containsKey(s)){
//            return memo.get(s);
//        }
//
//        int result,len = s.length();
//
//        if(len == 1){
//            result = 1;
//        }else if(len == 2){
//            result = iscomb(s.charAt(0),s.charAt(1))?2:1;
//        } else if(len%2 == 1){
//            int mi = len/2;
//            int leftHalf = numDecodings(s.substring(0, mi));
//            int rightHalf= numDecodings(s.substring(mi+1));
//            int mid = (iscomb(s.charAt(mi-1),s.charAt(mi))?
//                    rightHalf*(mi-1>0?numDecodings(s.substring(0, mi-1)):1):0)
//                    +
//                    (iscomb(s.charAt(mi),s.charAt(mi+1))?
//                            leftHalf*((mi+2< len)?numDecodings(s.substring(mi+2)):1):0);
//            System.out.println("leftHalf:" + leftHalf + " rightHalf:" + rightHalf + " mid:" + mid);
//            result = leftHalf * rightHalf + mid;
//        }else{
//            result = numDecodings("9" + s);// add a 9 before doesn't affect result
//        }
//
//        memo.put(s,result);
//        return result;
//    }
//
//    boolean iscomb(char a,char b){
//        return a==0?false:Character.getNumericValue(a)*10+Character.getNumericValue(b) <= 26;
//    }

}
