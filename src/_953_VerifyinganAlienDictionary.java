import java.util.HashMap;

/**
 * ["kuvp","q"]
 * "ngxlkthsjuoqcpavbfdermiywz"
 */
public class _953_VerifyinganAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character,Integer> dict = new HashMap<>();
        for(int i=1; i<= order.length();i++){
            dict.put(order.charAt(i-1),i);
        }

        for(int i=1;i<words.length;i++){
            if(compareWordNum(dict,words[i-1],words[i])){
                return false;
            }
        }

        return true;
    }

    // if b is smaller, smaller comes front
    private boolean compareWordNum(HashMap<Character,Integer> dict,String a,String b){
        int l1 = a.length();
        int l2 = b.length();
        boolean isEqual = true;



        for(int i=0;i<Math.min(l1,l2);i++){

            System.out.println("a:" +a.charAt(i) + "->" + dict.get(a.charAt(i)) +
                    " b:" +b.charAt(i) + "->" + dict.get(b.charAt(i)) );

            if(dict.get(a.charAt(i)) > dict.get(b.charAt(i))){
                return true;
            }else if(dict.get(a.charAt(i)) < dict.get(b.charAt(i))){
                return false;
            }
        }

        return l2 < l1;
    }



}
