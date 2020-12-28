/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 *
 * Follow up: If you have figured out the O(n) solution,
 * try coding another solution using the divide and conquer approach, which is more subtle.
 */
public class _53_MaximumSubarray {
    //wrong answer
    public int maxSubArray(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int sum = nums[0];
        int left = 0 ,right = 0,pre = 0;
        for(int i = 1;i < nums.length;i++){

            if(nums[i]>0){

                if(i == right+1){
                    right++;
                    sum += nums[i];
                    if(nums[left] < 0){
                        sum-=nums[left];
                        left++;
                    }

                }else if(nums[i] >= sum){
                    left= right = i;
                    pre=0;
                    sum = nums[i];
                }else if((pre+=nums[i]) > 0){
                    right = i;
                    sum += pre;
                    pre = 0;
                }

            }else{
                pre+=nums[i];
            }
            //    System.out.println("sum:" + sum + " left:" + left + " right:" + right + " pre:" + pre);

        }
        return sum;

    }

    //Greedy time:O(n) Space:O(1)
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int currSum = nums[0], maxSum = nums[0];

            for(int i = 1; i < n; ++i) {
                currSum = Math.max(nums[i], currSum + nums[i]);
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }
    }


}
