/**
 * 10. Regular Expression Matching
 * <p>
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 */
public class RegularExpressionMatching {

    public boolean test(REM_TestCase c) {
        return isMatch(c.getS(), c.getP()) == c.expected;
    }

    public boolean isMatch2(String s, String p) {

        if (p.isEmpty()) return s.isEmpty();

        int sPointer = s.length() - 1;
        int pPointer = p.length() - 1;
        char curS, curP, repeatChar = '/';

        while (sPointer >= 0 && pPointer >= 0) {

            curS = s.charAt(sPointer);
            curP = p.charAt(pPointer);

            if (curP == '*' && pPointer > 0) {
                curP = p.charAt(--pPointer);
                repeatChar = curP;
            }

            if (repeatChar != '/') {

                while (isEqual(curS, repeatChar) && sPointer >= 0) {

                    int offset = 1;
                    while (sPointer + offset >= 0 && isEqual(s.charAt(sPointer - offset), repeatChar)) {
                        offset++;
                    }

                    sPointer--;
                    if (sPointer < 0) {
                        break;
                    }
                    curS = s.charAt(sPointer);
                }

                pPointer--;
                repeatChar = '/';
            } else {
                if (isEqual(curS, curP)) {
                    sPointer--;
                    pPointer--;
                } else {
                    return false;
                }
            }
        }

        while (pPointer >= 0 && p.charAt(pPointer) == '*') {
            pPointer = pPointer - 2;
        }
        return sPointer == -1 && pPointer == -1;
    }

    public boolean isMatch(String s, String p) {
        return solution(s, p);
    }

    private boolean solution(String text, String pattern) {

        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    private char getPattenRepeat(int pointer, String str) {
        int offset = 1;
        char reChar = str.charAt(pointer);
        int temp = pointer;
        char cur = 0;
        boolean isStarPre = false;

        while (temp - offset >= 0) {
            cur = str.charAt(temp - offset);
            if (cur == '*') {
                offset++;
                isStarPre = true;
            } else if (isStarPre) {
                offset++;
                isStarPre = false;
            } else if (isEqual(cur, reChar)) {
                offset++;
            }

        }
        return cur;
    }


    private boolean isEqual(char s, char p) {
        if (p == '.') {
            return true;
        } else {
            return s == p;
        }
    }
}
