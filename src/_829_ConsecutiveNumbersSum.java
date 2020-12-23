import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _829_ConsecutiveNumbersSum {


        public int consecutiveNumbersSum(int N) {

            if(N<=2){
                return 1;
            }

            Queue<Integer> q = new LinkedList<>();
            int sum = 0;
            int result = 1;
            for(int i = 1;i<=(N/2+1);i++){

                sum+=i;
                q.add(i);

                while (sum>N && q.size() >0){
                    sum-= q.remove();
                }


                if(sum == N){
                    result++;
                }

            }

            return result;

        }

    class Solution {
        public int consecutiveNumbersSum(int N) {
            int count = 0;
            // x > 0 --> N/k - (k + 1)/2 > 0
            int upper_limit = (int)(Math.sqrt(2 * N + 0.25) - 0.5);
            for (int k = 1; k <= upper_limit; ++k) {
                // x should be an integer
                if ((N - k * (k + 1) / 2) % k == 0)
                    count++;
            }
            return count;
        }
    }
}
