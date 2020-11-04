public class String2Integer {

    public int myAtoi(String s) {
        if (s== null || s.isEmpty()){
            return 0;
        }

        int i = 0;

        while(i < s.length() && s.charAt(i)==' '){
           i++;
        }

        StringBuffer num = new StringBuffer();

        boolean isNeg = false;
        if(i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
            isNeg = s.charAt(i) == '-';
            i++;
        }

        char cur;
        while (i < s.length()){
            cur = s.charAt(i);
            if(Character.isDigit(cur)){
                num.append(cur);
                i++;
            }else{
                break;
            }
        }

        int  re = 0;
        if(num.length() > 0) {
            String str = num.toString();
            if(isNeg)
                str = '-'+str;

            try {
                re = Integer.parseInt(str);
            } catch (NumberFormatException e) {

                re = isNeg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
        }
       return re;
    }

}
