/**
 * 10. Regular Expression Matching 
 * 
 * (aa,a*)-> true (ab,.*)->true 
 * (aab,c*a*b) ->true 
 * (mississippi,mis*is*p*)->false
 * (aab,c*a**b) ->false
 *
 */
public class RegularExpressionMatching {

    public boolean test(REM_TestCase c){
        return isMatch(c.getS(),c.getP()) == c.expected;
    }

    public boolean isMatch(String s, String p) {

        int sPointer = s.length()-1;
        int pPointer = p.length()-1;
        char curS,curP, repeatChar = '/';

        while(sPointer >= 0 && pPointer >= 0){

            curS = s.charAt(sPointer);
            curP = p.charAt(pPointer);

            if(curP == '*' && sPointer >0){
                curP = p.charAt(--pPointer);
                repeatChar = curP;
            }

            if(repeatChar != '/'){

                while(isEqual(curS,repeatChar) && sPointer >=0){
                    sPointer--;
                    if(sPointer < 0){
                        break;
                    }
                    curS = s.charAt(sPointer);
                }

                pPointer--;
                repeatChar='/';
            }else{
                if(isEqual(curS,curP)){
                    sPointer--;
                    pPointer--;

                }else{
                    // System.out.println("RegularExpressionMatching: false");
                    return false;
                }
            }
        }

        while(pPointer >=0 && p.charAt(pPointer)=='*'){
            pPointer = pPointer-2;
        }
        return sPointer == -1 && pPointer == -1;
    }

    private boolean isEqual(char s, char p) {
        if (p == '.') {
            return true;
        } else {
            return s == p;
        }
    }
}
