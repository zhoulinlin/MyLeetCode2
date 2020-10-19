public class javaTest {

    public static void main(String[] args) {

        REMTest();

    }


    public static void REMTest(){

        RegularExpressionMatching reg = new RegularExpressionMatching();

        REM_TestCase case1 = new REM_TestCase("mississippi", "mis*is*p*.",false);
        REM_TestCase case2 = new REM_TestCase("aa", "a*",true);
        REM_TestCase case3 = new REM_TestCase("ab", ".*",true);
        REM_TestCase case4 = new REM_TestCase("aab", "c*a*b",true);
        REM_TestCase case5 = new REM_TestCase("aab", "c*a**b",false);
        REM_TestCase case6 = new REM_TestCase("aaa", "ab*ac*a",true);


//        System.out.println("case1:" + case1 + "  result:" +reg.test(case1));
//        System.out.println("case2:" + case2 + "  result:" +reg.test(case2));
//        System.out.println("case3:" + case3 + "  result:" +reg.test(case3));
//        System.out.println("case4:" + case4 + "  result:" +reg.test(case4));
//        System.out.println("case5:" + case5 + "  result:" +reg.test(case5));
        System.out.println("case6:" + case6 + "  result:" +reg.test(case6));
    }

  
}