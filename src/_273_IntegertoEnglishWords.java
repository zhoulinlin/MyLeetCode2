public class _273_IntegertoEnglishWords {

    public String numberToWords(int num) {

        int length = String.valueOf(num).length();
        if(length == 1){
            return length1(num);
        }else if(length == 2){
            return length2(num);
        }else if(length == 3){
            return combineString(num,2,"Hundred");
        }else if(length <= 6){
            return combineString(num,3,"Thousand");
        }else if(length <= 9){
            return combineString(num,6,"Million");
        }else{
            return combineString(num,9,"Billion");
        }

    }

    String combineString(int num,int pow,String m){
        StringBuffer sb = new StringBuffer();
        int base = (int) Math.pow(10,pow);
        sb.append(numberToWords(num/base)).append(" ").append(m);
        if(num%base !=0){
            sb.append(" ").append(numberToWords(num%base));
        }

        return sb.toString();
    }

    String length2(int num){

        String str = length2_1(num);

        if(str == null || str.length() ==0){
            return new StringBuffer(length2_2(num/10)).append(" ").append(length1(num%10)).toString();
        }else{
            return str;
        }


    }

    String length2_1(int num){
        String str = new String();

        switch(num){
            case 10: str = "Ten";break;
            case 11: str = "Eleven";break;
            case 12: str =  "Twelve";break;
            case 13: str =  "Thirteen";break;
            case 14: str =  "Fourteen";break;
            case 15: str =  "Fifteen";break;
            case 16: str =  "Sixteen";break;
            case 17: str =  "Seventeen";break;
            case 18: str =  "Eighteen";break;
            case 19: str =  "Nineteen";break;
            case 20: str =  "Twenty";break;
            case 30: str =  "Thirty";break;
            case 40: str =  "Forty";break;
            case 50: str =  "Fifty";break;
            case 60: str =  "Sixty";break;
            case 70: str =  "Seventy";break;
            case 80: str =  "Eighty";break;
            case 90: str =  "Ninety";break;
        }
        return  str;
    }


    String length2_2(int num){
        String str = new String();

        switch(num){
            case 2: str =  "Twenty";break;
            case 3: str =  "Thirty";break;
            case 4: str =  "Forty";break;
            case 5: str =  "Fifty";break;
            case 6: str =  "Sixty";break;
            case 7: str =  "Seventy";break;
            case 8: str =  "Eighty";break;
            case 9: str =  "Ninety";break;
        }
        return  str;
    }


    String length1(int num){
        String str = new String();

        switch(num){
            case 1: str ="One";break;
            case 2: str = "Two";break;
            case 3: str = "Three";break;
            case 4: str = "Four";break;
            case 5: str = "Five";break;
            case 6: str = "Six";break;
            case 7: str = "Seven";break;
            case 8: str = "Eight";break;
            case 9: str = "Nine";break;
            case 0: str = "Zero";break;
        }
        return str;
    }

    class Solution {
        public String one(int num) {
            switch(num) {
                case 1: return "One";
                case 2: return "Two";
                case 3: return "Three";
                case 4: return "Four";
                case 5: return "Five";
                case 6: return "Six";
                case 7: return "Seven";
                case 8: return "Eight";
                case 9: return "Nine";
            }
            return "";
        }

        public String twoLessThan20(int num) {
            switch(num) {
                case 10: return "Ten";
                case 11: return "Eleven";
                case 12: return "Twelve";
                case 13: return "Thirteen";
                case 14: return "Fourteen";
                case 15: return "Fifteen";
                case 16: return "Sixteen";
                case 17: return "Seventeen";
                case 18: return "Eighteen";
                case 19: return "Nineteen";
            }
            return "";
        }

        public String ten(int num) {
            switch(num) {
                case 2: return "Twenty";
                case 3: return "Thirty";
                case 4: return "Forty";
                case 5: return "Fifty";
                case 6: return "Sixty";
                case 7: return "Seventy";
                case 8: return "Eighty";
                case 9: return "Ninety";
            }
            return "";
        }

        public String two(int num) {
            if (num == 0)
                return "";
            else if (num < 10)
                return one(num);
            else if (num < 20)
                return twoLessThan20(num);
            else {
                int tenner = num / 10;
                int rest = num - tenner * 10;
                if (rest != 0)
                    return ten(tenner) + " " + one(rest);
                else
                    return ten(tenner);
            }
        }

        public String three(int num) {
            int hundred = num / 100;
            int rest = num - hundred * 100;
            String res = "";
            if (hundred*rest != 0)
                res = one(hundred) + " Hundred " + two(rest);
            else if ((hundred == 0) && (rest != 0))
                res = two(rest);
            else if ((hundred != 0) && (rest == 0))
                res = one(hundred) + " Hundred";
            return res;
        }

        public String numberToWords(int num) {
            if (num == 0)
                return "Zero";

            int billion = num / 1000000000;
            int million = (num - billion * 1000000000) / 1000000;
            int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
            int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

            String result = "";
            if (billion != 0)
                result = three(billion) + " Billion";
            if (million != 0) {
                if (! result.isEmpty())
                    result += " ";
                result += three(million) + " Million";
            }
            if (thousand != 0) {
                if (! result.isEmpty())
                    result += " ";
                result += three(thousand) + " Thousand";
            }
            if (rest != 0) {
                if (! result.isEmpty())
                    result += " ";
                result += three(rest);
            }
            return result;
        }
    }

}
