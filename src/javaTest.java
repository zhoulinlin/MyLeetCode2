public class javaTest {

    public static void main(String[] args) {

//        ContainerWithMostWaterTest();
//        REMTest();
//        String2IntegerTest();
//        Roman2IntegerTest();
        _14LongestCommonPrefixTest();

    }

    public static void _14LongestCommonPrefixTest(){
        _14LongestCommonPrefix l = new _14LongestCommonPrefix();
        String[] strs = {"flower","flower","flower","flower"};
        System.out.println("_14LongestCommonPrefixTest:" +l.longestCommonPrefix(strs));
    }

    public static void Roman2IntegerTest(){
        Roman2Integer r = new Roman2Integer();
        System.out.println("Roman2IntegerTest:" +r.romanToInt("III"));
    }

    public static void Integer2RomanTest(){
        Integer2Roman i = new Integer2Roman();
        System.out.println("Integer2RomanTest:" +i.intToRoman(4));
    }


    public static void ContainerWithMostWaterTest(){
        ContainerWithMostWater c = new ContainerWithMostWater();
        int height[] = {1,8,6,2,5,4,8,3,7};
        System.out.println("ContainerWithMostWater:" + c.maxArea(height));

    }

    public static void String2IntegerTest(){
        String2Integer f = new String2Integer();
        System.out.println("String2IntegerTest:" + f.myAtoi("42"));
        System.out.println("String2IntegerTest:" + f.myAtoi("   -42"));
        System.out.println("String2IntegerTest:" + f.myAtoi("4193 with words"));
        System.out.println("String2IntegerTest:" + f.myAtoi("words and 987"));
        System.out.println("String2IntegerTest:" + f.myAtoi("-91283472332"));
        System.out.println("String2IntegerTest:" + f.myAtoi("+-12"));
        System.out.println("String2IntegerTest:" + f.myAtoi(""));
        System.out.println("String2IntegerTest:" + f.myAtoi(" "));
    }


    public static void REMTest(){

        RegularExpressionMatching reg = new RegularExpressionMatching();

        REM_TestCase case1 = new REM_TestCase("mississippi", "mis*is*p*.",false);
        REM_TestCase case2 = new REM_TestCase("aa", "a*",true);
        REM_TestCase case3 = new REM_TestCase("ab", ".*",true);
        REM_TestCase case4 = new REM_TestCase("aab", "c*a*b",true);
        REM_TestCase case5 = new REM_TestCase("aab", "c*a**b",false);
        REM_TestCase case6 = new REM_TestCase("aaa", "ab*ac*a",true);
        REM_TestCase case7 = new REM_TestCase("aaa", "ab*a*c*a",true);


//        System.out.println("case1:" + case1 + "  result:" +reg.test(case1));
//        System.out.println("case2:" + case2 + "  result:" +reg.test(case2));
//        System.out.println("case3:" + case3 + "  result:" +reg.test(case3));
//        System.out.println("case4:" + case4 + "  result:" +reg.test(case4));
//        System.out.println("case5:" + case5 + "  result:" +reg.test(case5));
        System.out.println("case6:" + case6 + "  result:" +reg.test(case6));
        System.out.println("case7:" + case7 + "  result:" +reg.test(case7));
    }

  
}