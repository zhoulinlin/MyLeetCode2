public class REM_TestCase {
    String s;
    String p;
    boolean expected;

    public REM_TestCase(String s, String p, boolean expected) {
        this.s = s;
        this.p = p;
        this.expected = expected;
    }

    @Override
    public String toString() {
        return " s:"+s + " p:" + p;
    }

    public String getS() {
        return s;
    }

    public String getP() {
        return p;
    }

    public boolean getExpected() {
        return expected;
    }
}